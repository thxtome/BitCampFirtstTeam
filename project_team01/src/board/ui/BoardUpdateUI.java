package board.ui;

import java.util.ArrayList;
import java.util.List;

import board.dao.BoardDAO;
import board.vo.BoardVO;

public class BoardUpdateUI extends BaseUI{
	BoardDAO dao;
	public BoardUpdateUI(BoardDAO dao) {
		this.dao = dao;
	}
	
	public void service() {
		BoardVO board = new BoardVO();
		String title = getString("제목을 입력하세요 : ");
		String content = getString("내용을 입력하세요 : ");
		boolean check = true;
		if(title == "") { System.out.println("제목을 입력해주세요."); check = false;}
		if(content == "") { System.out.println("내용을 입력해주세요."); check = false;}
		if(!check) return;
		board.setTitle(title);
		board.setContent(content);
		dao.addBoard(board);
	}


}
