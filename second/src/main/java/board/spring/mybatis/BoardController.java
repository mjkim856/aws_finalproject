package board.spring.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;
import spring.mybatis.MemberDTO;
import spring.mybatis.MemberService;

@Controller
public class BoardController {
	
	@Autowired
	@Qualifier("boardservice")
	BoardService service;
	
	@Autowired
	@Qualifier("memberservice")
	MemberService mservice;
	
	@RequestMapping("/boardlist")
	public ModelAndView boardlist(@RequestParam(value="page", required=false, defaultValue="1") int page) {
		// 1. 전체 글 갯수 불러오고 => 불러오고 => 보여준다
		
		int totalboard = service.getTotalBoard();
		int limit = (page-1)*3;
		List<BoardDto> list = service.getBoardList(limit);
		ModelAndView mv = new ModelAndView();
		mv.addObject("totalboard", totalboard);
		mv.addObject("list", list);
		mv.setViewName("board/list");
		return mv;
	}
	
	@GetMapping("/oneBoard")
	public ModelAndView getOneBoard(int seq) {
		ModelAndView mv = new ModelAndView();
		// 1. 게시물 조회수 1 증가 + 게시물 번호 객체 저장
		BoardDto oneboard = service.getOneBoard(seq);
		mv.addObject("oneboard", oneboard);
		
		// 2. 뷰
		mv.setViewName("board/oneboard");
		
		return mv;
	}
	
	@GetMapping("/insertboard")
	public String insertboardform() {
		return "board/insertform";//login 세션 전달
	}
	
	@PostMapping("/insertboard")
	public ModelAndView insertboardprocess(BoardDto dto) {
		ModelAndView mv= new ModelAndView();
		service.insertBoard(dto);//제목 내용 (세션id-작성자) 
		
		/*mv.addObject("list", 1페이지3개게시물);
		mv.addObject("totalboard", 전체게시물수);	
		mv.setViewName("board/list"); //board/list.jsp 뷰 
		*/
		
		mv.setViewName("redirect:/boardlist"); //매핑url /boardlist 메소드 호출
		return mv;
	}

}
