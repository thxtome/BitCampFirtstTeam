package challenge.ui;

import challenge.dao.ChallengeDAO;

public class MyChallengeUI extends BaseUI {
	private ChallengeDAO dao;
	public MyChallengeUI(ChallengeDAO dao) {
		this.dao = dao;
	}
	public void service() {
		BaseUI ui = null;
		while (true) {
			switch (menu()) {
//			case 1: ui = new 
			}
		}
	}
	int menu() {
		System.out.println("마이챌린지");
		System.out.println("-----------------------");
		System.out.println("1. 조회");
		System.out.println("2. 취소");
		System.out.println("3. 스터디");
		System.out.println("0. 이전");
		System.out.println("-----------------------");
		return getInt("메뉴를 입력하세요");
	}
}
