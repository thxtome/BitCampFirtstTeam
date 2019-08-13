package board.ui;

import java.util.ArrayList;
import java.util.List;

import board.dao.BoardDAO;
import board.vo.BoardVO;

public class BoardSelectUI extends BaseUI {
	BoardDAO dao;
	List<BoardVO> list = new ArrayList<>();

	public BoardSelectUI(BoardDAO dao) {
		this.dao = dao;
	}

	public void service() {
//		select();
		while (true) {
			BaseUI ui = null;
			switch (menu()) {
			case 1: ui = new BoardDetailUI(dao); break;
			case 2: ui = new BoardInsertUI(dao); break;
			case 3: ui = new BoardUpdateUI(dao); break;
			case 4: ui = new BoardDeleteUI(dao); break;
			case 5:
			case 6:
			case 0: return; 
			}
			if(ui != null) ui.service();
		}

	}

	public int menu() {
		System.out.println("-----------------");
		System.out.println("전체 조회");
		System.out.println("-----------------");
		System.out.println("1. 글번호 조회");
		System.out.println("2. 글 등록");
		System.out.println("3. 글 수정");
		System.out.println("4. 글 삭제");
		System.out.println("5. 검색");
		System.out.println("6. 페이지 선택");
		System.out.println("0. 이전");
		System.out.println("-----------------");
		System.out.print("메뉴 중 처리할 항목을 선택하세요 : ");
		return Integer.parseInt(sc.nextLine());
	}

	public void select() {
		System.out.println("-------------------------------------------");
		System.out.println("번호\t글쓴이\t제목\t작성일\t페이지번호\t");
		System.out.println("-------------------------------------------");
		for (BoardVO board : list) {
			System.out.printf("%d%t%s%t%s%t%s%t&s", board.getBoardNo(), board.getWriter(), board.getTitle(),
					board.getReg_date());
		}
		if (list.size() == 0) {
			System.out.println("게시글이 없습니다.");
			return;
		}
	}

}
