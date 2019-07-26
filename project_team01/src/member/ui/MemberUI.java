package member.ui;

import java.util.Scanner;

import member.dao.MemberDAO;
import member.vo.Member;

public class MemberUI {
	Scanner sc = new Scanner(System.in);
	MemberDAO dao = new MemberDAO();
	MenuMemberUI menu= new MenuMemberUI(dao);
    //첫번째 틀
	public void service() {
		while (true) {
			serviceBefore();
			serviceAfter();
		}
	}

	//로그인 전 틀
	void serviceBefore() {
		BaseMemberUI ui = null;
		while (true) {
			if (dao.isLoginCheck() == true) return;
			switch (menu.menu()) {
			case 1: ui = new LoginMemberUI(dao); break;
			case 2: ui = new SignUpMemberUI(dao); break;
			case 3:
			case 4:
			case 0: exit();
			default:
				System.out.println("번호를 잘못입력하셨습니다.");
				System.out.println("다시 입력해주세요.");
			}
			if(ui != null) ui.service();
		}
	}

	//로그인 후 틀
	void serviceAfter() {
		while (true) {
			if (dao.isLoginCheck() == false) return;
			switch (menu.menu()) {
			case 1: logout(); break;
			case 2:
			case 3:
			case 0: exit();
			default:
				System.out.println("번호를 잘못입력하셨습니다.");
				System.out.println("다시 입력해주세요.");
			}
		}
	}

    
	//로그아웃
	void logout() {
		dao.setLoginCheck(false);
	}
	
    //종료
	void exit() {
		sc.close();
		System.out.println("종료되었습니다.");
		System.exit(0);
	}

}
