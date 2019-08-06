package challenge.ui;

import java.util.Scanner;

import challenge.dao.ChallengeDAO;

public class ChallengeUI {
	ChallengeDAO dao = new ChallengeDAO();
	Scanner sc = new Scanner(System.in);
	
	
	public void service() {
		BaseUI ui = null;
		while (true) {
			switch(menu()) {
			case 1: ui = new ListChallengeUI(dao); break;
			case 2: ui = new WriteChallengeUI(dao); break;
			case 3: ui = new MyChallengeUI(dao); break;
			case 4: break;
			default : 
				System.out.println("잘못된 메뉴입니다.");
				System.out.println("다시 선택해주세요.");
			}
			if(ui != null) ui.service();
		}
	}
	
	
	
	
	
	int menu() {
		//메인화면에서 2.챌린지 선택한다음화면
		System.out.println("챌린지");
		System.out.println("--------------------");
		System.out.println("1. 챌린지조회");
		System.out.println("2. 챌린지등록");
		System.out.println("3. 마이챌린지");
		System.out.println("4. 이전");
		System.out.println("--------------------");
		System.out.print("메뉴를 입력하세요 : ");
		return Integer.parseInt(sc.nextLine());
	}
}
