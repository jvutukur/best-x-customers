package life.time.value;

import java.util.Date;
import java.util.Comparator;

public class Customer implements Comparator<Customer>{
	private int customerId;
	private Date startDate;
	private Date endDate;
	private double ltv;
	
	public Customer(int customerId){
		ltv = 0;
		this.customerId = customerId;
	}
	public int compare(Customer c1, Customer c2){
		if(c1.ltv > c2.ltv){
			return 1;
		}
		else if(c1.ltv < c2.ltv){
			return -1;
		}
		else{
			return 0;
		}
		
	}
	
}
