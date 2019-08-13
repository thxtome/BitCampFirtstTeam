package challenge.vo;

public class Challenge {
	//챌린지 게시글 작성자
	private String user_name;
	//챌린지 게시글 제목
	private String title;
	//챌린지 게시글 내용
	private String content;
	//챌린지 게시글 작성일
	private String regDate;
	//챌린지 참가금액
	private int partFee;
	//챌린지 제한 참여인원
	private int limitNo;
	//챌린지 글번호
	private int chNo;
	//진행상황 : 모집중(1), 진행중(2), 완료(3), 인증기간(4)
	private int condition;
	//챌린지 참여인원 모집기간
	private String limitDate;
	//시험날짜(챌린지 종료)
	private String examDate;
	//챌린지 포상 날짜
	private String rewardDate;

	public int getLimitNo() {
		return limitNo;
	}
	public void setLimitNo(int limitNo) {
		this.limitNo = limitNo;
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
	public int getLimitchNo() {
		return limitNo;
	}
	public void setLimitchNo(int limitchNo) {
		this.limitNo = limitchNo;
	}
	public int getCondition() {
		return condition;
	}
	public void setCondition(int condition) {
		this.condition = condition;
	}
	public String getLimitDate() {
		return limitDate;
	}
	public void setLimitDate(String limitDate) {
		this.limitDate = limitDate;
	}
	public String getExamDate() {
		return examDate;
	}
	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}
	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String writer) {
		this.user_name = writer;
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

	public int getChNo() {
		return chNo;
	}
	public void setChNo(int chNo) {
		this.chNo = chNo;
	}
}
