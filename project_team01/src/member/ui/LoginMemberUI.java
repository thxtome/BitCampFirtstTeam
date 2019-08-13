package member.ui;

import member.dao.MemberDAO;

public class LoginMemberUI extends BaseMemberUI{
	MemberDAO dao;;
	
	public LoginMemberUI(MemberDAO dao){
		this.dao = dao;
	}
	
	public void service() {
		String id = getString("아이디를 입력해주세요 : ");
		String pw = getString("비밀번호를 입력해주세요 : ");
		int result = dao.loginMember(id, pw);
		if (result == -1) {
			System.out.println("아이디 또는 비밀번호를 확인해주세요.");
			return;
		}
		System.out.println("로그인 되었습니다.");
		dao.setLoginCheck(true);
	}

}
