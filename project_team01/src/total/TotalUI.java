package total;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import board.dao.BoardDAO;
import board.ui.BoardUI;
import challenge.dao.ChallengeDAO;
import challenge.ui.ChallengeUI;
import member.dao.MemberDAO;
import member.ui.BaseMemberUI;
import member.ui.LoginMemberUI;
import member.ui.SignUpMemberUI;
import member.vo.MemberVO;
import pointShop.dao.PointShopDAO;
import pointShop.ui.PointShopUI;
import pointShop.vo.PointVO;

public class TotalUI {
	Scanner sc = new Scanner(System.in);
	MemberDAO dao = new MemberDAO();
	List<PointVO> list = new ArrayList<>();
	PointShopDAO pdao = new PointShopDAO(list);
	PointShopUI pui= new PointShopUI(pdao);
	TotalMenuUI menu= new TotalMenuUI(dao);
	ChallengeDAO cdao = new ChallengeDAO();
	ChallengeUI cui = new ChallengeUI(cdao);
	BoardDAO bdao = new BoardDAO();
	BoardUI bui = new BoardUI(bdao);
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
			case 3: cui.service();break;
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
			case 2: cui.service();break;
			case 3: pui.service(); break;
			case 4: bui.service(); break;
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
