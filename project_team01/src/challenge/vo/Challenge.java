package challenge.vo;

public class Challenge {
	//챌린지 게시글 작성자, 제목, 내용, 작성일시, 해당 챌린지 참가 금액, 참가 제한인원수, 글번호
	private String writer;
	private String title;
	private String content;
	private String regDate;
	private int point;
	private int partNo;
	private int no;
	private String[] participant;
	
	
	public String[] getParticipant() {
		return participant;
	}
	
	//참가 제한인원수 = participant.length
	public void setParticipant(String[] participant) {
		this.participant = participant;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
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
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getPartNo() {
		return partNo;
	}
	public void setPartNo(int participant) {
		this.partNo = participant;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
}
