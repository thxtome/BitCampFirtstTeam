package challenge.ui;

import challenge.dao.ChallengeDAO;

public class MyChallengeUI extends BaseUI {
	private ChallengeDAO dao;
	SelectMyChallengeUI smc = new SelectMyChallengeUI(dao);
	public MyChallengeUI(ChallengeDAO dao) {
		this.dao = dao;
	}
	public void service() {
		while (true) {
			switch (menu()) {
			case 1: smc.service(1);
					smc.service(2);
			case 2: smc.service(3);
			case 3: smc.service(4);
			case 0: // 이전화면으로 되돌리기
			default : System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
			}

		}
	}
	int menu() {
		System.out.println("마이챌린지");
		System.out.println("-----------------------");
		System.out.println("1. 신청한 챌린지 조회");
		System.out.println("2. 진행 중인 챌린지 조회");
		System.out.println("3. 완료된 챌린지 조회");
		System.out.println("0. 이전");
		System.out.println("-----------------------");
		return getInt("메뉴를 입력하세요 : ");
	}
}
