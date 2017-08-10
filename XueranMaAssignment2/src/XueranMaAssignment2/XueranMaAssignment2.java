package XueranMaAssignment2;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class XueranMaAssignment2 {
	//a method which takes an integer length and an array density of type double
	//as arguments and returns a new array of type int representing a dense array
	private static int[] createDenseArray(int length, double density){
		//create new dense array with length
		int[] densearray = new int[length];
		//create a random object
		Random random = new Random();
		//decide each value of dense array
		for (int i = 0; i < length; ++i){
			//judge if the entry should be 0
			//if the entry should be 0, simply populate it as such
			if (random.nextDouble() > density)//check next double value between [0.0,1.0)
				densearray[i] = 0;
			//if the entry should not be 0, populate it with a random integer between[0,1000000]
			else
				densearray[i] = random.nextInt(1000000)+1; //random integer from [1,1000000]
		}//end method createDenseArray
		return densearray;//return the array
		
	}
	//a method which takes an integer length and an array density of type double
	//as arguments and returns a new ArrayList representing a sparse array
	private static ArrayList<int[]> createSparseArray(int length, double density){
		
		//create new sparse ArrayList with length
		ArrayList<int[]> sparsearray = new ArrayList<>();
		//create a random object
		Random random2 = new Random();
		//store index and value inside sparse array
		for (int i = 0; i < length; ++i){
			//judge if the entry should be 0
			//if the entry should be 0, do nothing. Otherwise, store its index and value
			if (random2.nextDouble() <= density)//check next double value between [0.0,1.0)
	            //store index and value in sparsearray
				sparsearray.add(new int[] {i,random2.nextInt(1000000)+1});
			
		}//end method createSparseArray
		return sparsearray;//return the array
			
	}
	
	//a method which take a dense array as an argument and returns a new equivalent sparse array
	private static ArrayList<int[]> DensetoSparse(int[] densearray){
		//create new equivalent sparse ArrayList 
		ArrayList<int[]> sparsearray = new ArrayList<>();
		//store the non-zero element inside the sparsearray with index and value
		for (int i=0;i<densearray.length;++i){
			if (densearray[i] != 0){
				sparsearray.add(new int[] {i,densearray[i]});
			}
		}
		return sparsearray;
		
	}
	
	//a method which take a sparse array as an argument and returns a new equivalent dense array
	private static int[] SparsetoDense(ArrayList<int[]> sparsearray){
		//create new equivalent dense Array
		int len = 0;//the length of sparsearray
		int total = 0;//the 
		len = sparsearray.size();
		int[] temp = sparsearray.get(len-1);//get the final array inside sparsearray 
		total = temp[0];//get the index of the final array inside sparsearray
		int[] densearray = new int[total+1];//create a array which is big enough to fit all the values
		
		for (int[] i:sparsearray){
			int index = i[0];
			int value = i[1];
			densearray[index]=value;
				
		}
		return densearray;
		
	}
	
	//a method which takes a dense array as an argument and prints the max value in the array and the index
	private static int[] DenseMax(int[] densearray){
		//create the array with 2 parameters
		int[] max = new int[2];
		max[0] = 0;
		max[1] = densearray[0];
		for (int i = 1; i<densearray.length;++i){
			if (densearray[i] > max[1]){
				max[0]=i;
				max[1]=densearray[i];
			}
		}
		System.out.printf("find max (dense): %d at: %d", max[1],max[0]);//print out
		return max;
	}

	
	//a method which takes a sparse array as an argument and prints the max value in the array and the index
	private static int[] SparseMax(ArrayList<int[]> sparsearray){
		//intialize the max to the first array in sparsearray
		int[] max = sparsearray.get(0);
		//find the max inside the sparsearray
		for (int[] i:sparsearray){
			int index = i[0];
			int value = i[1];
			if (value>max[1]){
				max[0]=index;
				max[1]=value;
			}
		}
		System.out.printf("find max (sparse): %d at: %d", max[1],max[0]);//print out
		return max;
	}
	
	
	//main method begins execution of java application
    public static void main(String[] args){
        //create Scanner to obtain input from command line
  		Scanner input = new Scanner(System.in);
  	
  		int length= 0;
  		double density= 0;
  		boolean check = false;
  	    while (check == false){
  	    	try{
  	            System.out.print("Please array length:\n");//prompt
  	    	    length = input.nextInt();//read the length from user
  	    	    if (length>0){//check if length is bigger than 0 and then quit the loop
  	    	    	check = true;
  	  	        }
  	    	}catch(InputMismatchException e){
  	    		check = false;//continue loop
  	    		String c = input.nextLine();//clean the keyboard's input
  	    	}
  	    }
  	    boolean check2 = false;
  	    while (check2 == false){
  	  	    try{
  	  	        System.out.print("Enter density:\n");//prompt
  	  	        density = input.nextDouble();//read the density from user
  	  	        if (density>=0&&density<=1){//check if density is between[0,1] and quit loop
  	  	  	    	check2 = true;
  	  	  	    }
  	  	    }catch(InputMismatchException e){
  	  	    	check2 = false;//continue loop
  	  	    	String c = input.nextLine();//clean the keyboard's input
  	  	    }
  	    }
  	    //create dense array and count the time 
  	    long startTime0 = System.nanoTime();
  	    int[] densearray = createDenseArray(length,density);
  	    System.out.println("create dense length: "+length+" time: "+(System.nanoTime() - startTime0)*0.000001);
  	    
  	    //convert dense array to sparse arraylist and count the time
  	    long startTime1 = System.nanoTime();
  	    ArrayList<int[]> densetosparse = DensetoSparse(densearray);
  	    System.out.println("convert to sparse length: "+densetosparse.size()+" time: "+(System.nanoTime() - startTime1)*0.000001);
  	    
  	    //create sparse arraylist and count the time
  	    long startTime2 = System.nanoTime();
  	    ArrayList<int[]> sparsearray = createSparseArray(length,density);
  	    System.out.println("create sparse length: "+sparsearray.size()+" time: "+(System.nanoTime() - startTime2)*0.000001);
  	    
  	    //convert sparse arraylist to dense and count the time
  	    long startTime3 = System.nanoTime();
  	    int[] sparsetodense = SparsetoDense(sparsearray);
  	    System.out.println("convert to dense length: "+sparsetodense.length+" time: "+(System.nanoTime() - startTime3)*0.000001);
  	    
  	    //find the max inside the dense array and count the time
  	    long startTime4 = System.nanoTime();
  	    int[] maxdense = DenseMax(sparsetodense);
  	    System.out.println("\ndense find time: "+(System.nanoTime() - startTime4)*0.000001);
  	    
  	    //find the max inside the sparse arraylist and count the time
  	    long startTime5 = System.nanoTime();
  	    int[] maxsparse = SparseMax(densetosparse);
  	    System.out.println("\nsparse find time: "+(System.nanoTime() - startTime5)*0.000001);
  	    
  	}
}//Findings: the ''create'' methods change most in various cases and finding max in sparse is the fastest.
