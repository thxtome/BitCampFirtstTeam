package challenge.vo;

import java.util.Date;

public class Challenge {
	//챌린지 게시글 작성자
	private String userId;
	//챌린지 게시글 제목
	private String title;
	//챌린지 게시글 내용
	private String content;
	//챌린지 게시글 작성일
	private String regDate;
	//챌린지 참가금액
	private int partFee;
	//챌린지 제한 참여인원
	private int limitPart;
	//챌린지 글번호
	private int chalNo;
	//진행상황 : 모집중(1), 진행중(2), 완료(3), 인증기간(4)
	private int condition;
	//챌린지 참여인원 모집기간
	private String recruitDate;
	//시험날짜(챌린지 종료)
	private String examDate;
	//챌린지 포상 날짜
	private String rewardDate;
	//해당 챌린지 참가인원수
	private int partCnt;

	public int getPartCnt() {
		return partCnt;
	}
	public void setPartCnt(int partCnt) {
		this.partCnt = partCnt;
	}
	public int getLimitPart() {
		return limitPart;
	}
	public void setLimitPart(int limitPart) {
		this.limitPart = limitPart;
	}
	public String getRewardDate() {
		return rewardDate;
	}
	public void setRewardDate(String rewardDate) {
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
	public String getRecruitDate() {
		return recruitDate;
	}
	public void setRecruitDate(String date) {
		this.recruitDate = date;
	}
	public String getExamDate() {
		return examDate;
	}
	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getChalNo() {
		return chalNo;
	}
	public void setChalNo(int chalNo) {
		this.chalNo = chalNo;
	}
}
