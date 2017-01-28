package life.time.value;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Comparator;

public class LTV {

	public static void main(String args[]) {

		File input = new File("input/input.txt");
		System.out.println(input.getAbsolutePath());

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
