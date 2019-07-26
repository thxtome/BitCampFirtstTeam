package member.ui;

import member.dao.MemberDAO;
import member.vo.Member;

public class SignUpMemberUI extends BaseMemberUI{
	
	MemberDAO dao;
	SignUpMemberUI(MemberDAO dao){
		this.dao = dao;
		
	}
	
	public void service() {
		Member m = new Member();
		m.setId(getString("아이디를 입력해주세요 : "));
		m.setPass(getString("비밀번호를 입력해주세요 : "));
		m.setName(getString("이름을 입력해주세요 : "));
		m.setPhoneNumber(getString("전화번호를 입력해주세요 : "));
		m.seteMail(getString("이메일을 입력해주세요 : "));
		m.setAddr(getString("주소를 입력해주세요 : "));
		int result = dao.signUpBoard(m);
		if(result == -1) {
			System.out.println("아이디와 비밀번호는 필수입력입니다.");
			return;
		}
		if(result == -2) {
			System.out.println("중복된 아이디입니다.");
			return;
		}
		System.out.println("등록이 완료되었습니다.");

	}


}
