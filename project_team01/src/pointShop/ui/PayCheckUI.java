package pointShop.ui;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import pointShop.dao.PointShopDAO;
import pointShop.vo.PointVO;

public class PayCheckUI {
	PointShopDAO dao;


	Scanner sc = new Scanner(System.in);
	int amount;
	
	public PayCheckUI(PointShopDAO dao, int amount) {
		this.dao = dao;
		this.amount = amount;
	}
	
	void check(int choice) {
		String date = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
		switch (choice) {

		case 1:
			System.out.println("결제정보를 입력해주세요.");
			System.out.print("카드 회사 : ");
			String cardComp = sc.nextLine();
			System.out.print("카드 번호 (\"-\" 제외) : ");
			long cardNum = Long.parseLong(sc.nextLine());
			System.out.println("충전이 완료되었습니다.");
			dao.add(new PointVO(cardComp, cardNum, amount,date, choice, 1));
			return;

		case 2:
			System.out.println("결제정보를 입력해주세요.");
			System.out.print("입금 은행 : ");
			String bank = sc.nextLine();
			System.out.print("입금자 명 : ");
			String chargeName = sc.nextLine();
			System.out.println("충전이 완료되었습니다.");
			dao.add(new PointVO(bank, chargeName, amount,date, choice, 1));
			return;
			
		default: System.out.println("메뉴를 잘못 선택하셨습니다.");

		}
	}

}
