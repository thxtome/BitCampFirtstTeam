package challenge.vo;

import java.util.Date;

public class Participant {
	private int chalNo; // 챌린지 글번호
	private String userId; // 챌린지 참여자 아이디
	private Date joinDate; // 참여 날짜
	
	

	public Participant() {
	}

	public Participant(int chalNo, String userId) {
		this.chalNo = chalNo;
		this.userId = userId;
		joinDate = new Date();
	}

	public int getChalNo() {
		return chalNo;
	}

	public void setChalNo(int chalNo) {
		this.chalNo = chalNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

}
