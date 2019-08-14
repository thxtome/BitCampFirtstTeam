package challenge.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
public class SqlExecutor {
	public static int update(String sql, Object... args) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			ConnectionPool.getConnection();
			pstmt = con.prepareStatement(sql);
			int index = 1;
			for (Object arg : args) {
				pstmt.setObject(index++, arg);
			}
			return pstmt.executeUpdate();
			
		} finally {
			ConnectionFactory.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
	}
}