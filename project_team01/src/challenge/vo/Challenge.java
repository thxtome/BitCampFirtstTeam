package challenge.vo;

import java.util.Date;

public class Challenge {
	//챌린지 게시글 작성자
	private String userName;
	//챌린지 게시글 제목
	private String title;
	//챌린지 게시글 내용
	private String content;
	//챌린지 게시글 작성일
	private Date regDate;
	//챌린지 참가금액
	private int partFee;
	//챌린지 제한 참여인원
	private int limitNo;
	//챌린지 글번호
	private int chNo;
	//진행상황 : 모집중(1), 진행중(2), 완료(3), 인증기간(4)
	private int condition;
	//챌린지 참여인원 모집기간
	private Date limitDate;
	//시험날짜(챌린지 종료)
	private Date examDate;
	//챌린지 포상 날짜
	private Date rewardDate;

	public int getLimitNo() {
		return limitNo;
	}
	public void setLimitNo(int limitNo) {
		this.limitNo = limitNo;
	}
	public Date getRewardDate() {
		return rewardDate;
	}
	public void setRewardDate(Date rewardDate) {
		this.rewardDate = rewardDate;
	}
	public int getPartFee() {
		return partFee;
	}
	public void setPartFee(int partFee) {
		this.partFee = partFee;
	}

	public int getCondition() {
		return condition;
	}
	public void setCondition(int condition) {
		this.condition = condition;
	}
	public Date getLimitDate() {
		return limitDate;
	}
	public void setLimitDate(Date date) {
		this.limitDate = date;
	}
	public Date getExamDate() {
		return examDate;
	}
	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getChNo() {
		return chNo;
	}
	public void setChNo(int chNo) {
		this.chNo = chNo;
	}
}
