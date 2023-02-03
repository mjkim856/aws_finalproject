package board.spring.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardservice")
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDao dao;
	
	@Override
	public int getTotalBoard() {
		return dao.getTotalBoard();
	}

	@Override
	public List<BoardDto> getBoardList(int limit) {
		return dao.getBoardList(limit);
	}

	@Override
	public BoardDto getOneBoard(int seq) {
		dao.updateViewcount(seq);
		return dao.getOneBoard(seq);
	}
	

	@Override
	public void insertBoard(BoardDto dto) {
		dao.insertBoard(dto);
		
	}

}
