package board.ui;

import java.util.ArrayList;
import java.util.List;

import board.dao.BoardCmtDAO;
import board.dao.BoardDAO;
import board.vo.BoardCmtVO;
import board.vo.BoardVO;

public class BoardDetailUI extends BaseUI {
	BoardDAO dao;
	BoardCmtDAO cdao = new BoardCmtDAO();
	List<BoardVO> list = new ArrayList<>(); 
	public BoardDetailUI(BoardDAO dao) {
		this.dao = dao;
	}

	public void service() {
//		selectOne();
		while (true) {
			BaseUI ui = null;
			switch (menu()) {
			case 1: selectOne(); break; 
			case 2: ui = new BoardInsertUI(dao); break;
			case 3: ui = new BoardUpdateUI(dao); break;
			case 4: ui = new BoardDeleteUI(dao); break;
			case 5: ui = new BoardCmtInsertUI(cdao); break;
			case 6: ui = new BoardCmtUpdateUI(cdao); break;
			case 7: ui = new BoardCmtDeleteUI(cdao); break;
			case 8: break;
			case 0:	return;
			}
			if(ui != null) ui.service();
		}

	}

	public int menu() {
		System.out.println("-----------------");
		System.out.println("글 번호 조회");
		System.out.println("-----------------");
		System.out.println("1. 다른 글번호 조회");
		System.out.println("2. 글 등록");
		System.out.println("3. 글 수정");
		System.out.println("4. 글 삭제");
		System.out.println("5. 댓글 작성");
		System.out.println("6. 댓글 수정");
		System.out.println("7. 댓글 삭제");
		System.out.println("0. 이전");
		System.out.println("-----------------");
		System.out.print("메뉴 중 처리할 항목을 선택하세요 : ");
		return Integer.parseInt(sc.nextLine());
	}

	public void selectOne() {
		System.out.println("-------------------------------------------");
		int no = getInt("조회할 글번호를 입력해주세요 : ");
		BoardVO b = new BoardVO();
		if (b == null) {
			System.out.println("조회할 게시물이 없습니다.");
			return;
		}
		System.out.println("-------------------------------------------");
		System.out.println("번호 : " + b.getBoardNo());
		System.out.println("글쓴이 : " + b.getWriter());
		System.out.println("제목 : " + b.getTitle());
		System.out.println("내용 : " + b.getContent());
		System.out.println("작성일시 : " + b.getReg_date());
		System.out.println("-------------------------------------------");
		List<BoardCmtVO> list = new ArrayList<>();
		if (list.size() == 0)
			return;
		System.out.println("댓글");
		for (BoardCmtVO bc : list) {
			System.out.printf("%s\t%s\t%s\t\n", bc.getWriter(), bc.getContent(), bc.getRegDate());
		}

		System.out.println("-------------------------------------------");
	}
	

}
