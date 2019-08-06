package challenge.dao;

import java.util.ArrayList;
import java.util.List;

import challenge.vo.Challenge;

public class ChallengeDAO extends Challenge{

	List<Challenge> list = new ArrayList<>();
	Challenge challenge = new Challenge();
	int boardNo = 0;
	
	// 챌린지 등록
	public void insertChallenge(Challenge challenge){
		//게시글 번호 부여
		if(challenge.getNo() == 0) {
			challenge.setNo(++boardNo);
		}
		list.add(challenge);
	}
	public List<Challenge> selectChallenge() {
		return list;
	}
	public Challenge selectOneChallenge(int no) {
		for (int i = 0; i < list.size(); i++) {
			Challenge c = list.get(i);
			if (c.getNo() != no) continue;
			return c;
		}
		return null;
	}
	public int participation(String yn, int no/*로그인 아이디*/) {
		if (yn.equals("Y")) {
			for (int i = 0; i < list.size(); i++) {
				Challenge c = list.get(i);
				if (c.getNo() != no) continue;
//				c.setParticipant(로그인아이디);
				if(c.getParticipant().length == c.getPartNo()) {
					//게시글이 게시판 조회 되지 않도록하고 스터디 게시판 개설
				}
			} 
			return 1;
		} 
		return 0;
	}
}
