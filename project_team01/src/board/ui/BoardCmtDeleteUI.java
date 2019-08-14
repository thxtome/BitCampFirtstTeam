package board.ui;

import java.util.ArrayList;
import java.util.List;

import board.dao.BoardCmtDAO;
import board.dao.BoardDAO;
import board.vo.BoardCmtVO;
import board.vo.BoardVO;
import total.Login;

public class BoardCmtDeleteUI extends BaseUI{
	BoardCmtDAO dao;
	public BoardCmtDeleteUI(BoardCmtDAO dao) {
		this.dao = dao;
	}
	
	public void service() {
		BoardCmtVO boardCmt = new BoardCmtVO();
		int no= getInt("삭제할 글번호를 입력해주세요 : ");
		if(dao.deleteBoardCmt(no) == 0 ) {
			System.out.println("삭제할 게시글이 없습니다.");
			return;
		}
		System.out.println("게시글이 삭제되었습니다.");
	}

}
