package board.ui;

import java.util.Scanner;

import board.dao.BoardDAO;

public class BoardUI {
	Scanner sc = new Scanner(System.in);
	BoardDAO dao;
		public BoardUI(BoardDAO dao) {
		this.dao = dao;
	}

	public void service() {

		while (true) {
			BaseUI ui = null;
			switch (menu()) {
			case 1: ui = new BoardSelectUI(dao); break;
			case 2: ui = new BoardDetailUI(dao); break;
			case 3: ui = new BoardInsertUI(dao); break;
			case 4: ui = new BoardUpdateUI(dao); break;
			case 5: ui = new BoardDeleteUI(dao); break;
			case 6: 
			case 0: return;
			}
			if(ui != null) ui.service();
		}
	}

	public int menu() {
		System.out.println("-----------------");
		System.out.println("자유게시판");
		System.out.println("-----------------");
		System.out.println("1. 전체 조회");
		System.out.println("2. 글번호 조회");
		System.out.println("3. 글 등록");
		System.out.println("4. 글 수정");
		System.out.println("5. 글 삭제");
		System.out.println("6. 검색");
		System.out.println("0. 이전");
		System.out.println("-----------------");
		System.out.print("메뉴 중 처리할 항목을 선택하세요 : ");
		return Integer.parseInt(sc.nextLine());
	}

}
