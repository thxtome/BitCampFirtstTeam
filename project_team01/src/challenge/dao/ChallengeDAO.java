package challenge.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import challenge.vo.Challenge;
import challenge.vo.Participant;

public class ChallengeDAO extends Challenge {
	List<Participant> pList = new ArrayList<>();
	List<Challenge> cList = new ArrayList<>();
//	Challenge challenge = new Challenge();
	Participant participant = new Participant();


	// 챌린지 등록
	public void insertChallenge(Challenge c) {
		Connection con = null;
		PreparedStatement prtmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe" , "hr", "hr"
			);
			StringBuffer sql = new StringBuffer();
			sql.append("insert into tb_ challenge ( ");
			sql.append("ch_no, user_name, title, content, part_fee, limit_no, limit_date, exam_date");
			sql.append(") values ( ");
			sql.append("seq_tb_challenge.next, ?, ?, ?, ?, ?, ?, ?");
			sql.append(") ");
			prtmt = con.prepareStatement(sql.toString());
			int index = 1;
			prtmt.setString(index++, c.getUserName());
			prtmt.setString(index++, c.getTitle());
			prtmt.setString(index++, c.getContent());
			prtmt.setInt(index++, c.getPartFee());
			prtmt.setInt(index++, c.getLimitNo());
			prtmt.setDate(index++,  (Date)c.getLimitDate());
			prtmt.setDate(index++, (Date)c.getExamDate());
			
			prtmt.executeUpdate();
			cList.add(c);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {prtmt.close();} catch (Exception e) {}
			try {con.close();} catch (Exception e) {}
		}
		
	}

	// 챌린지 전체조회 => 다시하기
	public List<Challenge> selectChallenge() {
		Connection con = null;
		PreparedStatement prtmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:mini201901"
			);
			StringBuffer sql = new StringBuffer();
			sql.append("select ch_no, user_name, title, reg_date,  limit_no, part_fee ");
			sql.append("  from tb_challenge");	
			prtmt = con.prepareStatement(sql.toString());

			ResultSet rs = prtmt.executeQuery();
			
			while (rs.next()) {
				Challenge c = new Challenge();
				for (Challenge challenge : cList) {
					// 연동 후 주석해제
					/*
					c.setChNo(rs.getInt(ch_no));
					c.setUserName(rs.getString(user_name));
					c.setTitle(rs.getString(title));
					c.setRegDate(rs.getDate(reg_date));
					c.setLimitNo(rs.getInt(limit_no));
					c.setPartFee(rs.getInt(part_fee));
					*/
					cList.add(c);
				}
			}
			return cList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {prtmt.close();} catch (Exception e) {	}
			try {con.close();} catch (Exception e) {	}
		}
		return null;
	}

	// 챌린지 글번호 조회
	public Challenge selectOneChallenge(int no) {
		Connection con = null;
		PreparedStatement prtmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(
			"jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr"
			);
			StringBuffer sql = new StringBuffer();
			sql.append("select ch_no, user_name, title, content, limit_no, part_fee, rdg_date, limit_date ");
			sql.append("  from tb_challenge ");
			sql.append(" where no = ?");
			
			prtmt.setInt(1, no);
			prtmt = con.prepareStatement(sql.toString());
			
			ResultSet rs = prtmt.executeQuery();
			
			if (rs.next()) {
				Challenge c = new Challenge();
				//연동후 주석해제
				/*
				c.setChNo(rs.getInt(ch_no));
				c.setUserName(rs.getString(user_name));
				c.setTitle(rs.getString(title));
				c.setContent(rs.getString(content));
				c.setLimitchNo(rs.getInt(limit_no));
				c.setPartFee(rs.getInt(part_fee));
				c.setRegDate(rs.getDate(reg_date));
				c.setLimitDate(rs.getDate(limit_date));
				*/
				cList.add(c);
				return c; 
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {prtmt.close();} catch (Exception e) {	}
			try {con.close();} catch (Exception e) {	}
		}
		return null;
	}

	// 챌린지 참가인원 가져오기
	public int count(int no) {
		for (int i = 0; i < pList.size(); i++) {
			Participant p = pList.get(i);
			if (p.getChNo() != no)
				continue;
			return p.getCnt();
		}
		return 0;
	}

	// 챌린지 진행상태 가져오기
	public int condition(int no) {
		for (int i = 0; i < pList.size(); i++) {
			Challenge c = cList.get(i);
			if (c.getChNo() != no)
				continue;
			return c.getCondition();
		}
		return 0;
	}

	// 참가할때 아이디 추가, 참가 날짜 추가, 진행상태변경
	public void participation(int no/* 로그인 아이디 */) {
		int limitNo = 0;
		// 모집인원 가져오기
		for (int i = 0; i < cList.size(); i++) {
			Challenge c = cList.get(i);
			if (c.getChNo() != no)
				continue;
			limitNo = c.getLimitNo();
			break;
		}
		for (int i = 0; i < pList.size(); i++) {
			Participant p = pList.get(i);
			if (p.getChNo() != no)
				continue;
			// 로그인 아이디와 연동후 수정하기
			// 로그인된 아이디를 참가자에 추가
//			p.setUser_id(/* 로그인 아이디 */);
			// 참가일 추가
			// import 할때 util과 sql Date 동시에 하는방법
//			p.setJoinDate(new Date());
			// 코드 개선
			// 모집인원이 모두 채워지면 진행상태 2로 변경
			if (limitNo == p.getCnt()) {
				for (int j = 0; j < cList.size(); j++) {
					Challenge c = cList.get(j);
					if (c.getChNo() != no)
						continue;
					c.setCondition(2);
				}
			}

		}
	}
	
	// 일치하는 아이디를 찾아서 글번호 찾아낸다.
	// 일치하는 글번호 return
	public void MyChallengeSelect() {
		for (int i = 0; i < pList.size(); i++) {
			
		}
	}
}
