package board.ui;

import java.util.ArrayList;
import java.util.List;

import board.dao.BoardCmtDAO;
import board.dao.BoardDAO;
import board.vo.BoardCmtVO;
import board.vo.BoardVO;
import total.Login;

public class BoardCmtInsertUI extends BaseUI{
	BoardCmtDAO dao;
	public BoardCmtInsertUI(BoardCmtDAO dao) {
		this.dao = dao;
	}
	
	public void service() {
		BoardCmtVO boardCmt = new BoardCmtVO();
		String content = getString("내용을 입력하세요 : ");
		boolean check = true;
		if(content == "") { System.out.println("내용을 입력해주세요."); return;}
		boardCmt.setWriter(Login.getLoginId());
		boardCmt.setContent(content);
		dao.addBoardCmt(boardCmt);
	}

}
