package challenge.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public abstract class BaseUI {
	protected Scanner sc = new Scanner(System.in);
	
	public abstract void service();
	
	protected String getString(String msg) {
		System.out.print(msg);
		return sc.nextLine();
	}
	protected int getInt(String msg) {
		return Integer.parseInt(getString(msg));
	}
	protected Date getDate(String msg) {
		try {
			return new SimpleDateFormat("yyyy-mm-dd").parse(getString(msg));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
