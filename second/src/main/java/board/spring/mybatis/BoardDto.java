package board.spring.mybatis;

import org.springframework.stereotype.Component;

@Component
public class BoardDto {
	int seq;
	String title, contents, writer;
	int viewcount;
	String writingtime;
	
	// 컬럼명 순서로 insert되기에, 순서대로 적는 것을 추천한다.
	// @getter @setter lombok 사용하지 않는 이유는 dto가 server, console, javamain 등 여러 곳에서 사용되기 때문이다.
	// 의존성을 줄인 코드를 생성하기 위해서이다.
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getViewcount() {
		return viewcount;
	}
	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}
	public String getWritingtime() {
		return writingtime;
	}
	public void setWritingtime(String writingtime) {
		this.writingtime = writingtime;
	}

	
	
}
