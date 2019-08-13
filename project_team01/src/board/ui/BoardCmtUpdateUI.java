package board.ui;

import java.util.ArrayList;
import java.util.List;

import board.dao.BoardCmtDAO;
import board.vo.BoardCmtVO;

public class BoardCmtUpdateUI extends BaseUI{
	BoardCmtDAO dao;
	public BoardCmtUpdateUI(BoardCmtDAO dao) {
		this.dao = dao;
	}
	
	public void service() {
		int no= getInt("삭제할 글번호를 입력해주세요 : ");
		BoardCmtVO boardCmt = dao.selectOneBoard(no);
		if(boardCmt == null) {
			System.out.println("조회할 게시글이 없습니다.");
			return;
		}
		String title = getString("제목을 입력하세요 : ");
		String content = getString("내용을 입력하세요 : ");
		if(content == "") { System.out.println("내용을 입력해주세요."); return;}
		boardCmt.setContent(content);
		dao.updateBoardCmt(boardCmt);
	}


}
