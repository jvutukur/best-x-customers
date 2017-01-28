package life.time.value;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Comparator;
import net.sf.json.JSONObject;

public class LTV {

	public static void main(String args[]) {

		Data d = new Data(); // loads the data from the txt file
		LTV ltv = new LTV();
		
		ArrayList<Customer> topCustomers = ltv.topXSimpleLTVCustomers(1, d);
		for(Customer currentCustomer : topCustomers){
			System.out.println(currentCustomer.getCustomerId());
		}

	}
	
	
	public boolean Ingest(Event e, Data d){
		boolean success = false;
	    JSONObject jsonObj = e.getJsonObject();
	    
	    // add this jsonObj to input file
	    
	    // add this to d
	    
		return success;
	}
	
	public ArrayList<Customer> topXSimpleLTVCustomers(int x, Data d) {

		// min priority queue
		PriorityQueue<Customer> queue = new PriorityQueue<Customer>(
				new Comparator<Customer>() {
					public int compare(Customer c1, Customer c2) {
						if (c1.getLtv() > c2.getLtv()) {
							return 1;
						} else if (c1.getLtv() < c2.getLtv()) {
							return -1;
						} else {
							return 0;
						}

					}
				});

		Iterator it = d.map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			if (queue.size() == x) {
				if (((Customer) pair.getValue()).getLtv() > queue.peek()
						.getLtv()) {
					queue.remove();
					queue.add((Customer) pair.getValue());
				}
			} else if (queue.size() < x) {
				queue.add((Customer) pair.getValue());
			}
		}

		return new ArrayList<Customer>(queue);
	}
}
