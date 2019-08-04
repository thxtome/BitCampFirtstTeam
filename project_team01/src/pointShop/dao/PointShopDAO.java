package pointShop.dao;

import java.util.ArrayList;
import java.util.List;

import pointShop.vo.PointVO;
import total.Login;

public class PointShopDAO {
	List<PointVO> list;

	public PointShopDAO(List<PointVO> list) {
		this.list = list;
	}

	private long balance;

	public void add(PointVO p) {
		p.setId(Login.getLoginId());
		list.add(p);
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance() {
		balance = 0;
		for (int i = 0; i < list.size(); i++) {
			PointVO p = list.get(i);
			if (p.getDeWi().equals("충전") && p.getId().equals(Login.getLoginId())) {
				balance += p.getAmount();
				continue;
			}
			if (p.getDeWi().equals("환급") && p.getId().equals(Login.getLoginId())) {
				balance -= p.getAmount();
				continue;
			}
		}
	}

	public List<PointVO> select() {
		List<PointVO> listS = new ArrayList<>(); 
		for (int i = 0; i < list.size(); i++) {
			PointVO p = list.get(i);
			if(p.getId() == Login.getLoginId()) {
				listS.add(p);
			}
		}
		
		return listS;

	}

}
