package challenge.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import challenge.vo.Challenge;
import challenge.vo.Participant;

public class ChallengeDAO extends Challenge {
	List<Participant> pList = new ArrayList<>();
	List<Challenge> cList = new ArrayList<>();
	Challenge challenge = new Challenge();
	Participant participant = new Participant();
	int boardNo = 0;

	// 챌린지 등록
	public void insertChallenge(Challenge challenge) {
		// 게시글 번호 부여
		challenge.setChNo(++boardNo);
		cList.add(challenge);
	}

	// 챌린지 전체조회
	public List<Challenge> selectChallenge() {
		return cList;
	}

	// 챌린지 글번호 조회
	public Challenge selectOneChallenge(int no) {
		for (int i = 0; i < cList.size(); i++) {
			Challenge c = cList.get(i);
			if (c.getChNo() != no)
				continue;
			return c;
		}
		return null;
	}

	// 챌린지 참가인원 가져오기
	public int count(int no) {
		for (int i = 0; i < pList.size(); i++) {
			Participant p = pList.get(i);
			if (p.getChNo() != no)
				continue;
			return p.getCnt();
		}
		return 0;
	}

	// 챌린지 진행상태 가져오기
	public int condition(int no) {
		for (int i = 0; i < pList.size(); i++) {
			Challenge c = cList.get(i);
			if (c.getChNo() != no)
				continue;
			return c.getCondition();
		}
		return 0;
	}

	// 참가할때 아이디 추가, 참가 날짜 추가, 진행상태변경
	public void participation(int no/* 로그인 아이디 */) {
		int limitNo = 0;
		// 모집인원 가져오기
		for (int i = 0; i < cList.size(); i++) {
			Challenge c = cList.get(i);
			if (c.getChNo() != no)
				continue;
			limitNo = c.getLimitNo();
			break;
		}
		for (int i = 0; i < pList.size(); i++) {
			Participant p = pList.get(i);
			if (p.getChNo() != no)
				continue;
			// 로그인 아이디와 연동후 수정하기
			// 로그인된 아이디를 참가자에 추가
//			p.setUser_id(/* 로그인 아이디 */);
			// 참가일 추가
			String date = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
			p.setJoinDate(date);
			// 코드 개선
			// 모집인원이 모두 채워지면 진행상태 2로 변경
			if (limitNo == p.getCnt()) {
				for (int j = 0; j < cList.size(); j++) {
					Challenge c = cList.get(j);
					if (c.getChNo() != no)
						continue;
					c.setCondition(2);
				}
			}

		}
	}
	
	// 일치하는 아이디를 찾아서 글번호 찾아낸다.
	// 일치하는 글번호 return
	public void MyChallengeSelect() {
		for (int i = 0; i < pList.size(); i++) {
			
		}
	}
}
