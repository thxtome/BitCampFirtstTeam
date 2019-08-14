package challenge.ui;

import java.util.Date;

import challenge.dao.ChallengeDAO;
import challenge.vo.Challenge;
import total.Login;

public class WriteChallengeUI extends BaseUI {
	
	private ChallengeDAO dao;
	public WriteChallengeUI(ChallengeDAO dao) {
		this.dao = dao;
	}
	//메인화면->2.챌린지->2.챌린지등록
	
	public void service() {
		Challenge c = new Challenge();
		String loginId = Login.getLoginId();
		if(loginId.equals("")) {
			System.out.println("로그인해 주시기 바랍니다.");
			return;
		}

		c.setUserId(loginId);
		c.setTitle(getString("챌린지 제목을 입력하세요 : "));
		c.setContent(getString("챌린지 내용을 입력하세요 : "));
		c.setExamDate(getString("시험날짜를 입력하세요 : "));
		c.setLimitPart(getInt("함께 도전할 인원을 입력하세요 : "));
		c.setPartFee(getInt("도전 금액을 입력하세요 : "));
		c.setRecruitDate(getString("모집기한을 입력하세요 : "));

		
		dao.insertChallenge(c);
		
		System.out.println();
		System.out.println("챌린지글이 등록되었습니다.");
	}
}
