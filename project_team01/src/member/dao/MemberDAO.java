package member.dao;

import java.util.ArrayList;
import java.util.List;

import member.vo.MemberVO;
import total.Login;

public class MemberDAO {
	List<MemberVO> list = new ArrayList<>();
	boolean loginCheck = false;

	// 회원가입
	public int signUpBoard(MemberVO m) {
		if (duplicateCheck(m.getId()))
			return -2;
		if (emptyCheck(m))
			return -1;
		list.add(m);
		return 1;
	}

	// 로그인
	public int loginMember(String id, String pw) {
		MemberVO m = getMemberVO(id);
		if (m != null && pw.equals(m.getPass())) {
			setLoginCheck(true);
			Login.setLoginInfo(m.getId());
			return 1;
		}

		return -1;
	}

	// 로그인관리변수
	public boolean isLoginCheck() {
		return loginCheck;
	}

	public void setLoginCheck(boolean loginCheck) {
		this.loginCheck = loginCheck;
	}

	// 회원가입시 빈칸체크
	public boolean emptyCheck(MemberVO m) {
		if (m.getId().equals("") || m.getPass().equals("") || m.geteMail().equals("")) {
			return true;
		}
		return false;
	}

	// 회원가입시 아이디 중복체크
	public boolean duplicateCheck(String id) {
		MemberVO m = getMemberVO(id);
		if (m != null && id.equals(m.getId())) return true;
		return false;
	}

	public String findPw(String id,String email) {
		MemberVO m = getMemberVO(id);
		if(m != null && m.getId().equals(id) && email.equals(m.geteMail())) 
			return id +"님의 비밀번호는 "+m.getPass() + "입니다";
		return "입력하신 정보가 없습니다.";
	}

	public MemberVO getMemberVO(String id) {
		for (int i = 0; i < list.size(); i++) {
			MemberVO m = list.get(i);
			if (id.equals(m.getId()))
				return m;
		}
		return null;

	}

}
