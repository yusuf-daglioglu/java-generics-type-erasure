package org.example;

import java.util.ArrayList;
import java.util.List;

public class TypeTest {

	public static class DemoClass <T> {
		
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
	
	 /******
     * 
     * @TEST 1
     */
	public String typeTest1() {	
    	
		// The compiler will not compile the below line:
		// DemoClass<Object> a1 = new DemoClass<Object[]>();
		
		// But compiler can not detect the type-mismatch on below code block.
		// And on the runtime, JVM set all below instances properly...
		
    	DemoClass<Object>             a1 = find2();
    	DemoClass<Object[]>           a2 = find2();
    	DemoClass<String>             a3 = find2();
    	DemoClass<String[]>           a4 = find2();
    	DemoClass<? extends String>   a5 = find2();
    	DemoClass                     a6 = find2();

    	// All above instances equal to:
    	// DemoClass with name = jack.
    	
    	return "type matched";
    }
    
    private DemoClass find2() {
    	
		DemoClass el = new DemoClass<Object[]>();
		el.setName("jack");
		return el;
    }
    
    /******
     * 
     * @TEST 2
     */
	public String typeTest2() {

    	List<Object>   a1 = find();
    	List<Object[]> a2 = find();
    	List<String>   a3 = find();
    	List<String[]> a4 = find();
    	List<String>   a5 = find();
    	List           a6 = find();
    	
    	return "type matched";
    }
    
    private List find() {
		ArrayList list = new ArrayList<Object[]>();
		list.add("hello1");
		list.add("hello2");
		return list;
    }
}