//XUERANMAAssignment1.java
// To calculate	the	sum of a list of positive
// integers entered by	the	user.
import java.util.Scanner;//program uses class Scanner

public class XUERANMAAssignment1 
{
	//main method begins execution of java application
	public static void main(String[] args)
	{
		//create Scanner to obtain input from command line
		Scanner input = new Scanner(System.in);
		
		//initialization phase
		int number = 0; //the number to add 
		int sum = 0; //initial the sum
		
		//processing phase by while repetition 
		while (number !=-1)//quit when number is -1 otherwise continue loop
		    {
				
			System.out.print("Enter a positive integer (-3 to print, -2 to reset, -1 to quit)\n");
			//prompt
		    number = input.nextInt();//read the number from user
		    
		    if ((number == -1) || (number == -3))//judge the number for -1 or -3
				System.out.printf("Sum:%d\n",sum);//print out the sum
		    else if (number == -2)//number is -2
				sum = 0;//reset the sum to 0
		    else if (number >= 0)//number is integer
			    {
				sum = sum + number;//increment number to sum
				System.out.printf("Sum:%d\n",sum);//print out the sum
			    }
				
		    }
					
	}//end method main

	

}//end class XUERANMAAssignment1
