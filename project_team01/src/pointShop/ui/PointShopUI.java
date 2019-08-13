package pointShop.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pointShop.dao.PointShopDAO;
import pointShop.vo.PointVO;

public class PointShopUI {
	BaseUI ui = null;

	PointShopDAO dao;
	
	public PointShopUI(PointShopDAO dao) {
		this.dao = dao;
	}


	Scanner sc = new Scanner(System.in);
	public void service() {
		while(true) {
			dao.setBalance();
			switch(menu()) {
			case 1 : ui = new ChargeUI(dao); break;
			case 2 : ui = new PayBackUI(dao); break;
			case 3 : ui = new PointSelectUI(dao); break;
			case 0 : return;
			}
			if(ui != null) ui.service();
		}
	}
	
	
	int menu() {
		System.out.println("1. 포인트 충전");
		System.out.println("2. 포인트 환급");
		System.out.println("3. 포인트 잔액 및 내역조회");
		System.out.println("0. 이전");
		System.out.println("---------------------");
		System.out.print("메뉴를 선택해주세요 : ");
		return Integer.parseInt(sc.nextLine());
	}

}
