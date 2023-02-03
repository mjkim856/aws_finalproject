package spring.mybatis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

	public static void main(String[] args) throws IOException {

		ApplicationContext factory2 = 
				new ClassPathXmlApplicationContext("spring/mybatis/spring-mybatis.xml");

		MemberService service = (MemberService)factory2.getBean("service");
		
//		String name[] = factory2.getBeanDefinitionNames();
//		for(String n:name) {
//			System.out.println(n);
//		}
		/*
		test 1 : 리스트 조회
		 */
		
		List<MemberDTO> list = service.memberlist();
		for(MemberDTO m:list) {
			System.out.println(m);
		}
		
		/*
		test2 : int 조회

		System.out.println("전체 회원수 : " + service.membercount());
		*/
		
		/*
		test3 : 입력파라미터가 존재하며 하나의 객체를 반환하는 것 조회

		MemberDTO m = service.onemember("4");
		if(m != null) {
			System.out.println(m.getId() +" : " + m.getPw() +" : " + m.getEmail());
		}
		 */
		
		/*
		test4 : 페이징처리 리스트 조회

		int limit[] = {0, 3};
		List<MemberDTO> list = service.paginglist(limit);
		for(MemberDTO m:list) {
			System.out.println(m);
		}		
		 */
		
		/*
		test5 : id가 mabas인 사람 insert

		MemberDTO insertdto = new MemberDTO();
		insertdto.setId("mabas");
		insertdto.setPw("mabas");
		insertdto.setName("mabas");
		insertdto.setPhone("01012312323");
		insertdto.setEmail("mabas@gmail.com");
		insertdto.setAddress("mabasHome");
		service.insertmember(insertdto);
		 */
		
		/*
		test6 : id가 mabas인 사람 정보 update
		
		MemberDTO updatedto = new MemberDTO();
		updatedto.setId("mabas");
		updatedto.setName("박한국");
		updatedto.setPhone("01087654321");
		updatedto.setEmail("bybqatis@b.com");
		service.updatemember(updatedto);
		*/
		
		/*
		test7 : id가 mabas인 사람 정보 delete
		
		String id = "maba3434s";
		service.deletemember(id);
		*/		
		
		/*
		test7-1 : id가 mabas인 사람 정보 delete
		1. 해당 id의 회원이 작성한 글이 있는지 검사
		2. 글이 있다면 사용자 탈퇴 전에 글도 삭제하시겠습니까? [Y/N]
		  3-1. Y : 사용자 탈퇴
		  3-2. N : 사용자 탈퇴 취소
		 */		
		/*
		// id값 설정
		String id = "1234";
		Scanner sc = new Scanner(System.in);
		String answer;
		
		// id의 회원이 작성한 글이 있는지 확인하기
		// 만약 작성한 글이 없다면 삭제한다
		// 만약 작성한 글이 있다면 글 삭제 여부를 물어본다
		int writeCount = service.countContentById(id);
		
		if(writeCount == 0) {
			service.deletemember(id);
		} else {
			System.out.println("작성한 글을 삭제하시겠습니까? [Y/N]");
			answer = sc.next();
			if(answer.equals("N")) {
				System.out.println("글 삭제에 찬성하셔야 탈퇴가 가능합니다.");
			} else if(answer.equals("Y")) {
				System.out.println("탈퇴되었습니다.");
				service.deletemember(id);
			}
		}
		
		sc.close();
		*/
		/*
		test8 : map으로 검색
		
		HashMap<String, String> map = new HashMap<>();
		// select * from member where name like '%길동%'
		// select * from member where ${colname} like #{colvalue}
		map.put("colname", "name");
		map.put("colvalue", "%이름%");
		List<MemberDTO> searchList = service.searchmember(map);
		for(MemberDTO m:searchList) {
			System.out.println(m);
		}	
		
		*/
		
		/*
		test 9 : open close seperate를 사용해서 검색
		
		ArrayList<String> addresslist = new ArrayList<String>();
		// select * from member where address in('서울시 용산구', '제주시 용산구', '서울시 중구')
		addresslist.add("서울시 용산구");
		addresslist.add("제주시 용산구");
		addresslist.add("서울시 중구");
		List<MemberDTO> addrlist = service.addresssearch(addresslist);
		for(MemberDTO m:addrlist) {
			System.out.println(m);
		}	
		*/
		
		/*
		test 10 : 조합 + 동적 조건으로 검색
		
		MemberDTO dto = new MemberDTO();
		dto.setName("이름3");
		List<MemberDTO> resultlist = service.combination(dto);
		for(MemberDTO m:resultlist) {
			System.out.println(m);
		}	
		 */
		
		/*
		test 11 : join시 resultmap 사용하기
		
		List<HashMap<String, String>> list = service.memberboard("234");
		for(HashMap map:list) {
			Set<String> keys = map.keySet();
			for(String s:keys) {
				System.out.println(s + " : " + map.get(s));
			}
		}
		
		 */
	}
}


