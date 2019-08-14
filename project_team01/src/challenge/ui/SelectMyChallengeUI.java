package challenge.ui;

import java.util.List;

import challenge.dao.ChallengeDAO;
import challenge.vo.Challenge;
import total.Login;

public class SelectMyChallengeUI extends BaseUI {
	ChallengeDAO dao;

	public SelectMyChallengeUI(ChallengeDAO dao) {
		this.dao = dao;
	}

	// 사용자가 참가한 챌린지 조회
	public void service(int condition) {
		List<Challenge> cList = dao.selectMyChallenge(Login.getLoginId(), condition);
		//게시글의 모집기한과 현재날짜를 비교해서 진행상태 변화
		
		System.out.println("마이챌린지" + cList.size() + "개");
		System.out.println("---------------------------------");
		System.out.println("번호\t글쓴이\t제목\t작성일\t참가인원\t참가금액");
		System.out.println("---------------------------------");
		if (cList.isEmpty()) {
			System.out.println("게시물이 존재하지 않습니다.");
			System.out.println("---------------------------------");
			return;
		}
		for (int i = cList.size() - 1; i >= 0; i--) {
			Challenge c = cList.get(i);
			System.out.printf("%3d%10s%20s%8s%7d%7d\n", c.getChalNo(), c.getUserId(), c.getTitle(), c.getRegDate(),  c.getLimitPart(), c.getPartFee());
		}
		System.out.println("---------------------------------");
		BaseUI ui = null;
		while (true) {
			switch (menu()) {
			case 1: ui = new DetailChallengeUI();
//			case 2: ui = new KeywordSearch();
//			case 3: ui = new PageChoiceUI();
			case 0: ui = new ChallengeUI();
			default : System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
			}
			if (ui != null) {
				ui.service();
			}
		}
	}
	int menu() {
		System.out.println("---------------------------------");
		System.out.println("1. 글번호 상세조회");
		System.out.println("2. 키워드 검색");
		System.out.println("3. 페이지 선택");
		System.out.println("0. 이전");
		System.out.println("---------------------------------");
		return getInt("번호를 입력하세요 : ");
	}

	public void service() {
	}
}
