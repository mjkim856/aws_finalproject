package spring.mybatis;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.MyWebConfig;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired
	@Qualifier("memberservice")
	MemberService service;
	

	@RequestMapping("/")
	public String start() {
		return "mybatis/start";
	}
	
	// 로그인폼 이동
	@GetMapping("/login")
	public String login() {
		return "mybatis/loginform";
	}
	
	// 로그아웃
	// 세션에서 loginid 속성값 찾기 => 존재하면 없애기 => start.jsp 이동
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		if(session.getAttribute("loginid") != null) {
			session.removeAttribute("loginid");
		}
		return "mybatis/start";
	}
	
	// 로그인 처리
	@PostMapping("/login")
	public String login(String id, String pw, HttpSession session) {
		MemberDTO dto = service.onemember(id);
		System.out.println(dto);
		String view = "";
		// 로그인의 경우 : 1. dto가 아예 없다 (회원가입 필요)
		//			 : 2. id는 있지만 pw가 틀린 경우
		//			 : 3. id와 pw가 맞았다
		if(dto==null) {
			//회원가입만 보여주는 컨트롤러 url
			view = "mybatis/memberinsert";
		} else {
			if(pw.equals(dto.getPw()) ) {
				session.setAttribute("loginid", id);
				view = "mybatis/start";
			} else {
				view = "mybatis/loginform";
				
			}
		}
		return view;
		
	}
	
	@RequestMapping("/mybatismemberlist")
	public ModelAndView memberlist() {
		List<MemberDTO> memberlist = service.memberlist();
		ModelAndView mv = new ModelAndView();
		mv.addObject("memberlist", memberlist);
		mv.setViewName("mybatis/memberlist");
		return mv;
	}
	
	@GetMapping("/memberinsert")
	public String memberinsert() {
		return "mybatis/memberinsert";
	}
	
	@PostMapping("/memberinsert")
	// dto.setxxxx(xxx파라미터 자동 저장 - name속성명과 dto 필드명이 같은 경우)
	// 파일업로드 처리
	// dto image 변수에 c:upload 저장파일명 세팅
	public ModelAndView memberinsert(MemberDTO dto) throws IOException {
		// 이렇게 되면 dto.set이 알아서 된다 ???????
		String savePath = MyWebConfig.savePath;
//		String savePath = "c:/upload/";
		MultipartFile imagefile = dto.getImagefile();
		
		String filename1 = imagefile.getOriginalFilename();
		String beforeext1 = filename1.substring(0, filename1.lastIndexOf('.'));
		String ext1 = filename1.substring(filename1.lastIndexOf('.'));
		String newfilename1 = beforeext1 + "(" + UUID.randomUUID().toString() + ")" + ext1;
		File serverfile1 = new File(savePath + newfilename1);
		imagefile.transferTo(serverfile1);
		
		dto.setImage(newfilename1);
		
		// 유저 중복 가입을 막기 위함
		MemberDTO db_dto = service.onemember(dto.getId());
		String insertresult = "";
		ModelAndView mv = new ModelAndView();

		if(db_dto == null) {
			int row = service.insertmember(dto);
			if(row == 1) {
				insertresult="정상회원가입처리";
			} else {
				insertresult="회원가입 오류 발생";
			}
		} else {
			insertresult = "이미 사용중인 아이디입니다.";			
		}
		mv.addObject("insertresult", insertresult);
		mv.setViewName("mybatis/memberinsert2");
		return mv;
	}
	
	/*
		1. HttpSession 객체에 저장된 loginid값을 가져온다.
		2. service.onemember()를 호출해서 memberDto에 담는다.
		3. 모델에 저장한다.
		4. mybatis/memberinform 뷰에 담는다.
		5. 뷰는 form 태그로 출력한다.
		6. submit을 누르면 내 정보 수정이 가능하다.

	 */
	@RequestMapping("/memberinform")
	public ModelAndView memberinform(HttpSession session) {
		String loginid =(String) session.getAttribute("loginid");
		String view = "";
		ModelAndView mv = new ModelAndView();
		
		if(loginid == null) {
			view="mybatis/memberinsert";
		} else {
			MemberDTO dto = service.onemember(loginid);
			mv.addObject("informdto", dto);
			view="mybatis/memberinform";
		}
		
		mv.setViewName(view);
		
		return mv;
		
		
		/*
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("loginid") != null) {
			MemberDTO dto = service.onemember((String)session.getAttribute("loginid"));
			mv.addObject("dto", dto);
			mv.setViewName("mybatis/memberinform");
		} else {
			mv.setViewName("mybatis/loginform");
		}
		return mv;
		 
		*/
	}
	
	@PostMapping("/memberupdate")
	public ModelAndView memberupdate(HttpSession session, MemberDTO dto) {
		ModelAndView mv = new ModelAndView();
		String loginid =(String) session.getAttribute("loginid");
		String view = "";
		String resultString = "";
		
		
		if(loginid == null) {
			view="mybatis/memberinsert";
		} 
		
		int result = service.updatemember2(dto);
		
		if(result == 1) {
			resultString = "회원가입 완료";
			mv.addObject("result", resultString);
			view = "mybatis/start";
		}
		
		mv.setViewName(view);
		
		return mv;
		
		/*
		int row = service.updatemember2(dto);
		String updateresult = "";
		if(row==1) {
			updateresult ="회원정보수정완료";
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", resultString);
		mv.setViewName(view);
		
	
		 */
	}
	
	// 회원 탍퇴
	// 세션에서 loginid 속성값 읽기 => serice.deletemember(loginid) 
	// => 2번 결과 1이면 "회원탈퇴정상처리" 모델로 updateresult에 저장 => start.jsp 저장
	@GetMapping("/memberdelete")
	public ModelAndView deletemember(HttpSession session) {
		String loginid =(String) session.getAttribute("loginid");
		ModelAndView mv = new ModelAndView();
		
		if(loginid != null) {
			int deleteresult = service.deletemember(loginid);
			
			if(deleteresult == 1) {
				mv.addObject("result", "회원탈퇴처리완료");
			} else {
				mv.addObject("result", "회원탈퇴오류발생");
			}
		}
		mv.setViewName("mybatis/start");
		return mv;
	}
	
	// id는... id는 사람을 물어...!
	@ResponseBody
	@GetMapping("/othermemberinform")
	public MemberDTO othermemberinform(HttpSession session, String id) {
		// 1. 로그인 되었는가?
		// 1-1. X => start.jsp로 보낸다.
		// 1-2. O 
		//		2. id = admin인가?
		// 2-1. X => alert("회원정보를 볼 권한이 없습니다.")
		// 2-2. O => 아래의 코드를 수행한다.
		String loginid =(String) session.getAttribute("loginid");
		String model = "";
		MemberDTO dto = new MemberDTO();
		
		if(loginid == null) {
			model = "로그인 하세요.";
			dto.setId(model);
		} else {
			if(!loginid.equalsIgnoreCase("admin")) {
				model = "관리자만 볼 수 있습니다.";
				dto.setId(model);
			} else {
				dto = service.onemember(id);
			}
		}
		return dto;
	}
	
}
