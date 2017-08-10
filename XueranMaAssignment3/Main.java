import java.util.*;
import java.lang.Double;


public class Main {
	//The nextDouble () method should simply return a double on the range (0.0, 1.0]
	//(i.e., 0.0 exclusive to 1.0 inclusive) so that there are no 0.0 areas.
	private static nextDouble(){
		Random randomno = new Random();
		return randomno.nextDouble()+ double.Min_VALUE;
	}
	
	//The calculateSum () method should take an ArrayList of type Measurable as an
    //argument and return the sum of all areas in the list.
	private static calculateSum(){
		
	}
	
	
    public static main(){
    	
    }
}
