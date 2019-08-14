package board.ui;

import java.util.ArrayList;
import java.util.List;

import board.dao.BoardDAO;
import board.vo.BoardCmtVO;
import board.vo.BoardVO;

public class BoardDeleteUI extends BaseUI{
	BoardDAO dao;
	public BoardDeleteUI(BoardDAO dao) {
		this.dao = dao;
	}
	
	public void service() {
		int no= getInt("삭제할 글번호를 입력해주세요 : ");
		if(dao.deleteBoard(no) == 0 ) {
			System.out.println("삭제할 게시글이 없습니다.");
			return;
		}
		System.out.println("게시글이 삭제되었습니다.");
	}



}
