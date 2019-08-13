package pointShop.ui;

import pointShop.dao.PointShopDAO;
import pointShop.vo.PointVO;

public class PayBackUI extends BaseUI{
	public PayBackUI(PointShopDAO dao) {
		this.dao = dao;
	}
	PointShopDAO dao;
	public void service() {
		int amount = getInt("환급할 포인트를 입력해주세요 (1000포인트 이상) : ");
		if(amount < 1000) {
			System.out.println(" 금액을 잘못입력하셨습니다.");
			return;
		}
		
		if(amount > dao.getBalance()) {
			System.out.println(" 잔액이 부족합니다.");
			System.out.println("현재 잔액 : " + dao.getBalance());
			return;
		}
		
		String an= getString("환급 받을 계좌를 입력해주세요.");
		String bank = getString("환급 받을 은행을 입력해주세요.");
		dao.add(new PointVO(bank, an, amount,"2019/08/09", 2));
		System.out.println("환급이 완료되었습니다.");
		System.out.println("-------------------");

		
		
	}

}