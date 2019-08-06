package challenge.ui;

import java.util.List;

import challenge.dao.ChallengeDAO;
import challenge.vo.Challenge;

public class ListChallengeUI extends BaseUI {
	ChallengeDAO dao;
	public ListChallengeUI(ChallengeDAO dao) {
		this.dao = dao;
	}
	//챌린지 조회
	public void service() {
		
		List<Challenge> list = dao.selectChallenge();
		
		System.out.println("전체 챌린지" + list.size() + "개");
		System.out.println("---------------------------------");
		System.out.println("번호\t글쓴이\t제목\t작성일\t참가인원\t참가금액");
		System.out.println("---------------------------------");
		if (list.isEmpty()) {
			System.out.println("게시물이 없습니다.");
			System.out.println("---------------------------------");
			return;
		}
		for (int i = list.size() - 1; i >= 0; i--) {
			Challenge c = list.get(i);
			System.out.printf("%3d%10s%20s%8s%7d%7d\n", c.getNo(), c.getWriter(), c.getTitle(), c.getRegDate(),  c.getPartNo(), c.getPoint());
		}
		System.out.println("---------------------------------");
		int no = getInt("조회할 게시물 글번호를 입력하세요 : ");
		Challenge c = dao.selectOneChallenge(no);
		System.out.println("---------------------------------");
		System.out.println("글번호 : " + c.getNo());
		System.out.println("글쓴이 : " + c.getWriter());
		System.out.println("제목 : " + c.getTitle());
		System.out.println("내용 : " + c.getContent());
		System.out.println("참가인원 : " + c.getPartNo());
		System.out.println("참가금액 : " + c.getPoint());
		System.out.println("작성일 : " + c.getRegDate());
		System.out.println("---------------------------------");
		String yn = getString("참여하시겠습니까? (Y: 참가, N: 불참) : ");
		int result = dao.participation(yn,no/*로그인한 아이디*/);
		if (result == 1) {
			System.out.println("참가에 성공하셨습니다.");
		}
		
		
		/* 챌린지 글번호를 입력하면 상세조회로 가는것 구현
		 * 0을 입력하면 이전화면 혹은 메인메뉴 구현
		 */
		
	}
	
}
