package pointShop.vo;

public class PointVO {
	private String cardComp;
	private long cardNum;
	private int amount;
	private String name;
	private String bank;
	private String payType;
	private String regDate;
	private String deWi;
	private String id;
	private String accountNum;

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public PointVO(String cardComp, long cardNum, int amount, String date, int payType, int dewi) {
		this.cardComp = cardComp;
		this.cardNum = cardNum;
		this.amount = amount;
		this.regDate = date;
		this.payType = (payType == 1 ? "신용카드" : "현금");
		this.deWi = (dewi == 1 ? "충전" : "환급");
	}
	
	public PointVO(String bank, String accountNum, int amount, String regDate, int dewi) {
		this.amount = amount;
		this.bank = bank;
		this.regDate = regDate;
		this.deWi = (dewi == 1 ? "충전" : "환급");
		this.accountNum = accountNum;
		this.payType = "계좌입금";
	}

	public PointVO(String bank, String name, int amount, String date, int payType, int dewi) {
		this.bank = bank; 
		this.name = name;
		this.amount = amount;
		this.regDate = date;
		this.payType = (payType == 1 ? "신용카드" : "현금");
		this.deWi = (dewi == 1 ? "충전" : "환급");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeWi() {
		return deWi;
	}

	public void setDeWi(String deWi) {
		this.deWi = deWi;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}


	public String getCardComp() {
		return cardComp;
	}

	public void setCardComp(String cardComp) {
		this.cardComp = cardComp;
	}


	public long getCardNum() {
		return cardNum;
	}

	public void setCardNum(long cardNum) {
		this.cardNum = cardNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	

}
