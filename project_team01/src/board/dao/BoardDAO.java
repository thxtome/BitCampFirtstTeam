package board.dao;

import java.util.ArrayList;
import java.util.List;

import board.vo.BoardVO;

public class BoardDAO {
	public List<BoardVO> selectBoard() {
		return new ArrayList<BoardVO>();
	}
	
	public BoardVO selectOneBoard(int no) {
		return new BoardVO();
	}
	
	
	public int addBoard(BoardVO board) {
		int result = 0;
		return result;
	}
	
	public int updateBoard(BoardVO board) {
		int result = 0;
		return result;

	}
	
	public int deleteBoard(int no) {
		int result = 0;
		return result;

	}

}
