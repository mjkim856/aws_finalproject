package board.spring.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BoardDao {
	int getTotalBoard();
	List<BoardDto> getBoardList(int limit);
	void updateViewcount(int seq);
	BoardDto getOneBoard(int seq);
	void insertBoard(BoardDto dto);
}
