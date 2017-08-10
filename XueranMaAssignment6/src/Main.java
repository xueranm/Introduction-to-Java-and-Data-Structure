import java.util.ArrayList;
import java.util.Iterator;

import java.util.Set;

public class Main {
	public static void main(String[] args){
		//First of type integer
		//create a OccurrenceSet with type Integer
    	OccurrenceSet<Integer> intSet = new OccurrenceSet<Integer>();
    	//check add method
    	intSet.add(1);
    	intSet.add(2);
    	
    	//create a Array list to check addAll
    	ArrayList<Integer> a = new ArrayList<>();
    	a.add(2);
    	a.add(5);
    	a.add(7);
    	a.add(10);
    	a.add(11);
    	intSet.addAll(a);
    	
    	
    	//print out to check if things have been added
    	System.out.println("Print the keys and value inside the set:");
    		
    	//check isEmpty
    	System.out.println("Check if it isEmpty: "+ intSet.isEmpty());
    	//check the contains method
    	System.out.println("contain 4? "+intSet.contains(4));
    	System.out.println("contain 2? "+intSet.contains(2));
    	//check the containsAll method
    	System.out.println("containall elements in [2,5,7,10,11]? "+ intSet.containsAll(a));
    	System.out.println("Print the mapping:");
    	Iterator<Integer> iterator0 = intSet.iterator();
    	while(iterator0.hasNext()){
        	System.out.println(iterator0.next());
    	}
    	
    	//check the retainAll method and also check the toString method 
    	intSet.retainAll(a);
    	System.out.println("After retainAll [2, 5, 7, 10, 11], print the set");
    	System.out.println(intSet);
    	
    	//check the toArray method
    	System.out.println("Check the toArray");
    	Object[] list = intSet.toArray();
        for (Object i:list){
        	System.out.println(i);
        }
      //int[] b = new int[5];
        //int[] intlist = intSet.toArray( b);
        
        //check remove and removeall
    	System.out.println("remove 11 from set and print set:");
        intSet.remove(11);
    	System.out.println(intSet);
    	System.out.println("remove [10, 20] from set and print set:");
    	//create a arraylise to remove
    	ArrayList<Integer> re = new ArrayList<>();
    	re.add(10);
    	re.add(20);
    	intSet.removeAll(re);
    	System.out.println(intSet);
    	
    	//check the size method
    	System.out.println("size is: " + intSet.size());
 
    	//create the iterator to check my iterator 
    	Iterator<Integer> iterator = intSet.iterator();
        //check the iterator remove
    	System.out.println("Check the iterator remove");
    	while(iterator.hasNext()){
    			iterator.remove();
    			System.out.println("After remove, the intSet:"+intSet);
    	}
    	
    	
        //add a element 2 into the set and check the clear method
    	intSet.add(2);
    	System.out.println("Add 2 the empty set and print the set: "+intSet);
    	intSet.clear();
    	System.out.println("And then clear it, print the set: " + intSet);
    	
    	
    	//Second of type String
    	//create a OccurrenceSet with type String
    	OccurrenceSet<String> strSet = new OccurrenceSet<String>();
    	//check add method
    	strSet.add("1");
    	strSet.add("2");
    	
    	
    	//create a Array list to check addAll
    	ArrayList<String> c = new ArrayList<>();
    	c.add("2");
    	c.add("5");
    	c.add("7");
    	c.add("10");
    	c.add("11");
    	strSet.addAll(c);
    	
    	
    		
    	//check isEmpty
    	System.out.println("Check if it isEmpty: "+ strSet.isEmpty());
    	//check the contains method
    	System.out.println("contain '4'? "+strSet.contains("4"));
    	System.out.println("contain '2'? "+strSet.contains("2"));
    	//check the containsAll method
    	System.out.println("containall elements in ['2','5','7','10','11']? "+ strSet.containsAll(c));
    	System.out.println(strSet);
    	System.out.println("Print the mapping:");
    	
    	
    	//check the retainAll method and also check the toString method 
    	intSet.retainAll(c);
    	System.out.println("After retainAll ['2', '5', '7', '10', '11'], print the set");
    	System.out.println(strSet);
    	System.out.println("Print the mapping:");
    	Iterator<String> iterator1 = strSet.iterator();
    	while(iterator1.hasNext()){
        	System.out.println(iterator1.next());
    	}
    	
    	//check the toArray method
    	System.out.println("Check the toArray");
    	Object[] list1 = strSet.toArray();
        for (Object i:list){
        	System.out.println(i);
        }
        //int[] b = new int[5];
        //int[] intlist = intSet.toArray( b);
        
        //check remove and removeall
    	System.out.println("remove '11' from set and print set:");
        strSet.remove("11");
    	System.out.println(strSet);
    	System.out.println("remove ['10', '20'] from set and print set:");
    	//create a arraylise to remove
    	ArrayList<String> re1 = new ArrayList<>();
    	re1.add("10");
    	re1.add("20");
    	strSet.removeAll(re1);
    	System.out.println(strSet);
    	
    	//check the size method
    	System.out.println("size is: " + strSet.size());
 
    	//create the iterator to check my iterator 
    	Iterator<String> iterator2 = strSet.iterator();
        //check the iterator remove
    	System.out.println("Check the iterator remove");
    	while(iterator2.hasNext()){
    			iterator2.remove();
    			System.out.println("After remove, the strSet:"+strSet);
    	}
    	
    	
        //add a element 2 into the set and check the clear method
    	strSet.add("2");
    	System.out.println("Add '2' the empty set and print the set: "+strSet);
    	strSet.clear();
    	System.out.println("And then clear it, print the set: " + strSet);
    	
    	
    }
}
