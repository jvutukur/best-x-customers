package life.time.value;

import java.io.File;
import java.util.HashMap;

public class Data {
	HashMap<Integer, Customer> map;
	
	public Data(){
		File input = new File("input/input.txt");
		System.out.println(input.getAbsolutePath());
		
	}
}
