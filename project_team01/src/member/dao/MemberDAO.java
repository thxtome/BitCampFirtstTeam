package member.dao;

import member.util.ObjectArrayList;
import member.vo.Member;

public class MemberDAO {
	ObjectArrayList list = new ObjectArrayList();
	boolean loginCheck = false;
    
	//회원가입
	public int signUpBoard(Member m) {
		if (duplicateCheck(m.getId(), 1)) return -2;
		if(emptyCheck(m)) return -1;
		list.add(m);
		return 1;
	}
    
	
	//로그인
	public int loginMember(String id, String pw) {
		for (int i = 0; i < list.size(); i++) {
			Member m = (Member) list.get(i);
			if (id.equals(m.getId())) {
				if (pw.equals(m.getPass())) {
					setLoginCheck(true);
					return 1;
				}
			}
		}
		return -1;
	}
	
	
    //로그인관리변수 
	public boolean isLoginCheck() {
		return loginCheck;
	}
	public void setLoginCheck(boolean loginCheck) {
		this.loginCheck = loginCheck;
	}

	
	
	//회원가입시 빈칸체크
	public boolean emptyCheck(Member m) {
		if(m.getId().equals("")  || m.getPass().equals("")) {
			return true;
		}
		return false;	
	}
	
	//회원가입시 아이디 중복체크
	public boolean duplicateCheck(String content, int type) {
		for (int i = 0; i < list.size(); i++) {
			Member m = (Member) list.get(i);
			switch (type) {
			case 1:
				if (content.equals(m.getId()))
					return true;
				break;
			}
		}
		return false;

	}
}
