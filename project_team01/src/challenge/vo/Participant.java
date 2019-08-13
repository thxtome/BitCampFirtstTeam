package challenge.vo;

import java.util.Date;

public class Participant {
	private int chNo; // 챌린지 글번호
	private String user_id; // 챌린지 참여자 아이디
	private Date joinDate; // 참여 날짜
	private int cnt; // 
	
	

	public Participant() {
	}

	public Participant(int chNo, String user_id) {
		this.chNo = chNo;
		this.user_id = user_id;
		joinDate = new Date();
	}

	public int getChNo() {
		return chNo;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public void setChNo(int chNo) {
		this.chNo = chNo;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

}
