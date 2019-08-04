package pointShop.ui;

import pointShop.dao.PointShopDAO;

public class ChargeUI extends BaseUI{
	public ChargeUI(PointShopDAO dao) {
		this.dao = dao;
	}
	PointShopDAO dao;
	public void service() {
		int amount = getInt("충전할 포인트를 입력해주세요 (1000포인트 이상) : ");
		if(amount < 1000) {
			System.out.println(" 금액을 잘못입력하셨습니다.");
			return;
		}
		System.out.println("결제 방법을 선택해주세요.");
		System.out.println("1. 신용 카드");
		System.out.println("2. 현금");
		System.out.println("0. 이전");
		System.out.println("-------------------");
		int choice = getInt("결제 방법 : ");
		PayCheckUI p = new PayCheckUI(dao, amount);
		p.check(choice);
		
		
	}

}
