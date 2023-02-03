package board.spring.mybatis;

import java.util.List;

public interface BoardService {
	// public 안 붙여도 public
	// 게시물 리스트를 보여주기 위한 서비스이다. 서비스 명세서이다.
	int getTotalBoard();
	List<BoardDto> getBoardList(int limit);
	BoardDto getOneBoard(int seq);
	void insertBoard(BoardDto dto);
}
