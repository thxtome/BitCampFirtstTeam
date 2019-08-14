package challenge.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import challenge.util.ConnectionFactory;
import challenge.util.ConnectionPool;
import challenge.util.SqlExecutor;
import challenge.vo.Challenge;
import challenge.vo.Participant;
import total.Login;

public class ChallengeDAO {
	List<Participant> pList = new ArrayList<>();
	List<Challenge> cList = new ArrayList<>();
//	Challenge challenge = new Challenge();
	Participant participant = new Participant();
//	0000.00.00
//	to_date(?,'yyyy.mm.dd')

	// 챌린지 등록
	public void insertChallenge(Challenge c) {
		try {
			SqlExecutor.update(
					"insert into tb_ challenge (chal_no, user_id, title, content, part_fee, limit_part, limit_date, exam_date, part_cnt) values (seq_tb_challenge.next, ?, ?, ?, ?, ?, to_date(?,'yyyy-mm-dd'), to_date(?,'yyyy-mm-dd'),"
					+ "nvl((select count(*) from tb_participant)) + 1, 0)",
					c.getUserId(), c.getTitle(), c.getContent(), c.getPartFee(), c.getLimitPart(), c.getRecruitDate(), c.getExamDate());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 챌린지 전체조회 
	public List<Challenge> selectChallenge() {
		Connection con = null;
		PreparedStatement prtmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select chal_no, user_id, title, to_char(reg_date, 'yyyy-mm-dd') as reg_date,  limit_part, part_fee ");
			sql.append("  from tb_challenge");
			prtmt = con.prepareStatement(sql.toString());

			ResultSet rs = prtmt.executeQuery();

			while (rs.next()) {
				Challenge c = new Challenge();
				
				c.setChalNo(rs.getInt("chal_no")); 
				c.setUserId(rs.getString("user_id"));
				c.setTitle(rs.getString("title")); 
				c.setRegDate(rs.getString("reg_date"));
				c.setLimitPart(rs.getInt("limit_part")); 
				c.setPartFee(rs.getInt("part_fee"));

				cList.add(c);
			}
			return cList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(prtmt);
			ConnectionPool.releaseConnection(con);
		}
		return null;
	}

	// 1.챌린지 조회 -> 챌린지 글번호 조회
	public Challenge selectOneChallenge(int no) {
		Connection con = null;
		PreparedStatement prtmt = null;
		try {
			con = ConnectionPool.getConnection();

			StringBuffer sql = new StringBuffer();
			sql.append(
					"select chal_no, user_id, title, content, reg_date, part_fee, limit_part, recruit_date, exam_date, condition, reward_date ");
			sql.append("  from tb_challenge");
			sql.append(" where no = ?");
			prtmt = con.prepareStatement(sql.toString());
			prtmt.setInt(1, no);
			ResultSet rs = prtmt.executeQuery();
			if (rs.next()) {
				Challenge c = new Challenge();
				c.setChalNo(rs.getInt("chal_no"));
				c.setUserId(rs.getString("user_id"));
				c.setTitle(rs.getString("title"));
				c.setContent(rs.getString("content"));
				c.setRegDate(rs.getString("reg_date"));
				c.setPartFee(rs.getInt("part_fee"));
				c.setLimitPart(rs.getInt("limit_part"));
				c.setRecruitDate(rs.getString("recruit_date"));
				c.setExamDate(rs.getString("exam_date"));
				c.setCondition(rs.getInt("condition"));
				c.setRewardDate(rs.getString("reward_date"));
				cList.add(c);
				return c;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(prtmt);
			ConnectionPool.releaseConnection(con);
		}
		return null;
	}

	// 참가할때 아이디 추가, 참가 날짜 추가, 진행상태변경
	public void participation(int no, String login) {
		try {
			Participant p = getParticipant(no);
			if (p.getUserId().equals(login)) {
				System.out.println("이미 참가 중 입니다.");
				return;
			}
			SqlExecutor.update(
			"insert into tb_participant (chal_no, user_id) values (?, ?, ?)",
			no, login
			);
			SqlExecutor.update(
			"update tb_challenge set part_cnt = part_cnt + 1"
			);
			Challenge c = selectOneChallenge(no);
			if (c.getPartCnt() == c.getLimitPart()) {
				setCondition(2);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	// 일치하는 아이디를 찾아서 글번호 찾아낸다.
	// 일치하는 글번호 return

	// 사용자가 쓴 글만 조회
	public List<Challenge> selectMyChallenge(String loginId, int condition) {
		Connection con = null;
		PreparedStatement prtmt = null;
		try {
			con = ConnectionPool.getConnection();

			StringBuffer sql = new StringBuffer();
			sql.append(
					"select c.chal_no, c.user_id, c.title, c.content, c.reg_date, c.part_fee, c.limit_part, c.recruit_date, c.exam_date, c.condition, c.reward_date ");
			sql.append("  from tb_challenge c");
			sql.append("  inner join tb_participant p");
			sql.append("     on c.chal_no = p.chal_no");
			sql.append(" where p.user_id = ?,");
			sql.append(" where c.condition = ?");
			prtmt = con.prepareStatement(sql.toString());
			int index = 1;
			prtmt.setString(index++, loginId);
			prtmt.setInt(index++, condition);
			ResultSet rs = prtmt.executeQuery();
			if (rs.next()) {
				Challenge c = new Challenge();
				c.setChalNo(rs.getInt("chal_no"));
				c.setUserId(rs.getString("user_name"));
				c.setTitle(rs.getString("title"));
				c.setContent(rs.getString("content"));
				c.setRegDate(rs.getString("reg_date"));
				c.setPartFee(rs.getInt("part_fee"));
				c.setLimitPart(rs.getInt("limit_part"));
				c.setRecruitDate(rs.getString("recruit_date"));
				c.setExamDate(rs.getString("exam_date"));
				c.setCondition(rs.getInt("condition"));
				c.setRewardDate(rs.getString("reward_date"));

				cList.add(c);
				return cList;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 참가자 정보 받기
	public Participant getParticipant(int no) {
		Connection con = null;
		PreparedStatement prtmt = null;
		try {
			con = ConnectionPool.getConnection();

			StringBuffer sql = new StringBuffer();
			sql.append("select chal_no, user_id, join_date");
			sql.append("  from tb_participant");
			sql.append(" where no = ?");
			prtmt = con.prepareStatement(sql.toString());
			prtmt.setInt(1, no);
			ResultSet rs = prtmt.executeQuery();
			if (rs.next()) {
				Participant p = new Participant();
				p.setChalNo(rs.getInt("chal_no"));
				p.setUserId(rs.getString("user_id"));
				p.setJoinDate(rs.getDate("join_date"));

				pList.add(p);
				return p;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//진행 상태 변경
	public void setCondition(int no) {
		try {
			ConnectionPool.getConnection();
			SqlExecutor.update(
			"update tb_challenge set part_cnt = ?", no
			);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	//검색한 게시물 결과
	/*
	public List<Challenge> keywordSearch(){
		Connection con = null;
		PreparedStatement prtmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select chal_no, user_id, title, to_char(reg_date, 'yyyy-mm-dd') as reg_date,  limit_part, part_fee");
			sql.append("  from tb_challenge");
			// 여기부터 수정
			sql.append(" where ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
}

