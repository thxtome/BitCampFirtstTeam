package challenge.ui;

import challenge.dao.ChallengeDAO;
import challenge.vo.Challenge;

public class DetailChallengeUI extends BaseUI {
	ChallengeDAO dao;

	public DetailChallengeUI() {
	}

	public DetailChallengeUI(ChallengeDAO dao) {
		this.dao = dao;
	}

	public void service() {

		System.out.println("---------------------------------");
		int no = getInt("조회할 게시물 글번호를 입력하세요 : ");
		Challenge c = dao.selectOneChallenge(no);
		int cnt = dao.count(no);
		int condition = dao.condition(no);
		System.out.println("---------------------------------");
		System.out.println("글번호 : " + c.getChNo());
		System.out.println("글쓴이 : " + c.getUserName());
		System.out.println("제목 : " + c.getTitle());
		System.out.println("내용 : " + c.getContent());
		// 참여중인원 / 참가제한인원
		System.out.printf("참가인원 : %d/%d", cnt, c.getLimitNo());
		// 참가비 / 모금된금액
		System.out.printf("참가금액 : %d/%d", c.getPartFee(), c.getPartFee() * cnt);
		System.out.println("작성일 : " + c.getRegDate());
		System.out.println("모집기간 : " + c.getLimitDate());
		System.out.println("---------------------------------");

		// if : 진행상태가 1이 아니라면 참여여부 묻지 않음
		if (condition == 1) {
			String yn = getString("참여하시겠습니까? (Y: 참가, N: 불참) : ");
			if (yn.equals("N"))
				return;
			dao.participation(no/* 로그인한 아이디 */);
			System.out.println("참가에 성공하셨습니다.");
		}
	}
}
