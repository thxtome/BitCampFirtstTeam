package member.ui;

import java.util.Scanner;

import member.dao.MemberDAO;

public class MenuMemberUI extends BaseMemberUI {
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

	public MenuMemberUI(MemberDAO dao) {
		this.dao = dao;
	}

	public void service() {

	}

	public int menu() {

		if (dao.isLoginCheck()) {
			System.out.println(menuAfter);
			return Integer.parseInt(sc.nextLine());
		}
		System.out.println(menuBefore);
		return Integer.parseInt(sc.nextLine());
	}

}
