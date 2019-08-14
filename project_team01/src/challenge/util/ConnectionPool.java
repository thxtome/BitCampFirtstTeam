package challenge.util;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
	private static final int INIT_COUNT = 3;
	private static List<Connection> free = new ArrayList<>();
	private static List<Connection> used = new ArrayList<>();
	
	static {
		try {
			for (int i = 0; i < INIT_COUNT; i++) {
				free.add(ConnectionFactory.getConnection());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		Connection con = free.remove(0);
		used.add(con);
		return con;
	}
	
	public static void releaseConnection(Connection con) {
		used.remove(con);
		free.add(con);
	}
	
	
}
