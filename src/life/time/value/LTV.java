package life.time.value;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;





public class LTV {

	public static void main(String args[]){
		
		File input = new File("input/input.txt");
		System.out.println(input.getAbsolutePath());
		


	}
	
	public ArrayList<Customer> topXSimpleLTVCustomers(int x, Data d){
		ArrayList<Customer> topXCustomers = new ArrayList<Customer>();
		
		PriorityQueue<Customer> queue = new PriorityQueue<Customer>();
		
		Iterator it = d.map.entrySet().iterator();
		
		
		
		return topXCustomers;
	}
}
