package member;

import java.util.Scanner;

public class MemberUI {
	Scanner sc = new Scanner(System.in);
	MemberDAO dao = new MemberDAO();
    //첫번째 틀
	void service() {
		while (true) {
			serviceBefore();
			serviceAfter();
		}
	}
	//로그아웃
	void logout() {
		dao.setLoginCheck(false);
	}

	//로그인 전 틀
	void serviceBefore() {
		while (true) {

			switch (menuBefore()) {
			case 1: login(); break;
			case 2: signUp(); break;
			case 3:
			case 4:
			case 0: exit();
			default:
				System.out.println("번호를 잘못입력하셨습니다.");
				System.out.println("다시 입력해주세요.");
			}
			if (dao.isLoginCheck() == true)
				return;
		}
	}

	//로그인 후 틀
	void serviceAfter() {
		while (true) {
			switch (menuAfter()) {
			case 1: logout(); break;
			case 2:
			case 3:
			case 0: exit();
			default:
				System.out.println("번호를 잘못입력하셨습니다.");
				System.out.println("다시 입력해주세요.");
			}
			if (dao.isLoginCheck() == false)
				return;
		}
	}
	
    //로그인
	void login() {
		System.out.print("아이디를 입력해주세요 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호를 입력해주세요 : ");
		String pw = sc.nextLine();
		int result = dao.loginMember(id, pw);
		if (result == -1) {
			System.out.println("아이디 또는 비밀번호를 확인해주세요.");
			return;
		}
		System.out.println("로그인 되었습니다.");
	}
	
    //로그인 전 메뉴
	int menuBefore() {
		System.out.println("----------------------");
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("3. 챌린지");
		System.out.println("4. 자유게시판");
		System.out.println("0. 종료");
		System.out.println("----------------------");
		System.out.print("메뉴를 선택해주세요 : ");
		return Integer.parseInt(sc.nextLine());
	}
	//로그인 후 메뉴
	int menuAfter() {
		System.out.println("----------------------");
		System.out.println("1. 로그아웃");
		System.out.println("2. 챌린지");
		System.out.println("3. 자유게시판");
		System.out.println("0. 종료");
		System.out.println("----------------------");
		System.out.print("메뉴를 선택해주세요 : ");
		return Integer.parseInt(sc.nextLine());
	}
    //회원가입
	void signUp() {
		Member m = new Member();
		System.out.print("아이디를 입력해주세요 : ");
		m.setId(sc.nextLine());
		System.out.print("비밀번호를 입력해주세요 : ");
		m.setPass(sc.nextLine());
		System.out.print("이름을 입력해주세요 : ");
		m.setName(sc.nextLine());
		System.out.print("전화번호를 입력해주세요 : ");
		m.setPhoneNumber(sc.nextLine());
		System.out.print("이메일을 입력해주세요 : ");
		m.seteMail(sc.nextLine());
		System.out.print("주소를 입력해주세요 : ");
		m.setAddr(sc.nextLine());
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
    //종료
	void exit() {
		sc.close();
		System.out.println("종료되었습니다.");
		System.exit(0);
	}

}
