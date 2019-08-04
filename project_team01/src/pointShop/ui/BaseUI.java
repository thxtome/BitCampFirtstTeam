package pointShop.ui;

import java.util.Scanner;

public abstract class BaseUI {
	Scanner sc = new Scanner(System.in);

	protected abstract void service();

	protected String getString(String msg) {
		System.out.print(msg);
		return sc.nextLine();
	}

	protected int getInt(String msg) {
		return Integer.parseInt(getString(msg));
	}
}
