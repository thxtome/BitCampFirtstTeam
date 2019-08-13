package pointShop.ui;

import java.util.List;

import pointShop.dao.PointShopDAO;
import pointShop.vo.PointVO;

public class PointSelectUI extends BaseUI{
	PointShopDAO dao;

	public PointSelectUI(PointShopDAO dao) {
		this.dao = dao;
	}
	
	public void service() {
		switch (menu()) {
		case 1:	System.out.println("--------------------");
 				System.out.printf("현재 잔액 : %,d원\n",dao.getBalance());
 				System.out.println("--------------------");
		
			break;
		case 2: List<PointVO> list = dao.select();
		System.out.println("--------------------");
		for(int i = 0; i < list.size(); i++) {
			PointVO p = list.get(i);
			System.out.printf("일자 : %s\t   금액 : %,3d원   %s%n",p.getRegDate(),p.getAmount(),p.getPayType());
		}
		if(list.size() == 0) {
			System.out.println("내역이 없습니다.");
		}
		System.out.println("--------------------");

			break;
			
		case 0:
			
			return;
			
		default:System.out.println("번호를 잘못입력하셨습니다.");
			break;
		}
		
	}
	
	int menu() {
		System.out.println("1. 잔액 조회");
		System.out.println("2. 내역 조회");
		System.out.println("0. 이전");
		System.out.println("----------------");
		return getInt("메뉴를 선택해주세요 : ");
	}

}
