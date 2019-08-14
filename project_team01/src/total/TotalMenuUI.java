package total;

import java.util.Scanner;

import member.dao.MemberDAO;
import member.ui.BaseMemberUI;

public class TotalMenuUI extends BaseMemberUI {
	private Scanner sc = new Scanner(System.in);
	private MemberDAO dao;
	private String menuBefore = "-----------------------------\n" + "1. 로그인\n" + 
																	"2. 회원가입\n" + 
																	"3. 챌린지\n" + 
																	"4. 자유게시판\n"
																	+ "0. 종료\n"
																	+ "-----------------------------\n" + 
																	"메뉴를 선택해주세요 : ";

	private String menuAfter = "-----------------------------\n" + "1. 로그아웃\n" + 
																	"2. 챌린지\n" + 
																	"3. 포인트샵\n" +
																	"4. 자유게시판\n" 
																	+ "0. 종료\n"
																	+ "-----------------------------\n" +
																	"메뉴를 선택해주세요 : ";

	public TotalMenuUI(MemberDAO dao) {
		this.dao = dao;
	}

	public void service() {

	}

	public int menu() {

		if (dao.isLoginCheck()) {
			System.out.print(menuAfter);
			return Integer.parseInt(sc.nextLine());
		}
		System.out.print(menuBefore);
		return Integer.parseInt(sc.nextLine());
	}

}
