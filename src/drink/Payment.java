package drink;

public class Payment {
	//Field
	int amount; //총내가낸 금액
	int change;
	//Constructor
	public Payment() {}
	
	//Method
	public void setAmount(int amount) {
		this.amount += amount;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public int getChange() {
		return change;
	}
	public boolean getPayment(int total) { //일단 리턴객체를 하나 생성하자
		boolean result = false;
		if(amount >= total) {
			change = amount - total;
			System.out.println("=> 결제완료!!");
			result = true;
		}
		return result;
		
		
	}
	
	
}
