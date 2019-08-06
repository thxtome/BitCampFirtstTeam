package challenge.ui;

import java.text.SimpleDateFormat;
import java.util.Date;

import challenge.dao.ChallengeDAO;
import challenge.vo.Challenge;
import member.vo.MemberVO;

public class WriteChallengeUI extends BaseUI {
	
	private ChallengeDAO dao;
	public WriteChallengeUI(ChallengeDAO dao) {
		this.dao = dao;
	}
	//메인화면->2.챌린지->2.챌린지등록
	
	public void service() {
		Challenge c = new Challenge();
		//회원정보에서 작성자 가져오기
//		c.setWriter()
		c.setTitle(getString("챌린지 제목을 입력하세요 : "));
		c.setContent(getString("챌린지 내용을 입력하세요 : "));
		c.setPartNo(getInt("참가 제한 인원을 입력하세요 : "));
		c.setPoint(getInt("참가 금액을 입력하세요 : "));
		String date = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
		c.setRegDate(date);

		
		dao.insertChallenge(c);
		
		System.out.println();
		System.out.println("챌린지글이 등록되었습니다.");
	}
}
