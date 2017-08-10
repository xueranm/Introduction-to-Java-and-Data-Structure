import java.util.*;
import java.lang.Double;

//main class
public class Main {
	//return double (0,1]
	private static double nextDouble(){
		Random randomno = new Random();
		return randomno.nextDouble()+ Double.MIN_VALUE;
	}
	
	//return sum of all in arraylist
	private static double calculateSum(ArrayList<Measurable> measurablearray){
		double sum = 0;
		for (Measurable i:measurablearray){
			sum = sum + i.getArea();
		}
		return sum;
	}
	
	//main method
	public static void main(String arg[]){
		//create a arraylist of measurable type
    	ArrayList<Measurable> measurablearray = new ArrayList<>();
    	//create the random constructor
    	Random randomnoo = new Random();
    	//initialize the counts of 4 types of stuff
    	int rects = 0;
    	int boxes = 0;
    	int circles = 0;
    	int spheres = 0;
    	//put 1000 random measurable instances inside the measurable arraylist
    	for (int i=0;i<1000;++i){
    		//get a random double between [0,1)
    		double chance = randomnoo.nextDouble();
    		
    		//if double is between [0,0.25), call nextDouble() and pass the parameters inside a Rectangl instance 
    		//and count it once, and add the instance to measurable arraylist 
    		if (chance < 0.25){
    			double length1 = nextDouble();
    			double wide1 = nextDouble();
    			Rectangl obj1 = new Rectangl();
    			obj1.Rectangl(length1,wide1);
    			rects++;	
    			measurablearray.add(obj1);
    		//if double is between [0.25,0.5), call nextDouble() and pass the parameters inside a Box instance 
        	//and count it once, and add the instance to measurable arraylist 
    		}else if (chance>=0.25&&chance<0.5){
    			double length2 = nextDouble();
    			double wide2 = nextDouble();
    			double high2 = nextDouble();
    			Box obj2 =new Box();
    			obj2.Box(length2,wide2,high2);
    			boxes++;
    			measurablearray.add(obj2);
    		//if double is between [0.5,0.75), call nextDouble() and pass the parameters inside a Circle instance 
        	//and count it once, and add the instance to measurable arraylist 
    		}else if (chance>=0.5&&chance<0.75){
    			double radius1 = nextDouble();
    			Circle obj3 = new Circle();
    			obj3.Circle(radius1);
    			circles++;
    			measurablearray.add(obj3);
    		//if double is between [0.75,1), call nextDouble() and pass the parameters inside a Sphere instance 
        	//and count it once, and add the instance to measurable arraylist 
    		}else if (chance>=0.75){
    			double radius2 = nextDouble();
    			Sphere obj4 = new Sphere();
    			obj4.Sphere(radius2);
    			spheres++;
    			measurablearray.add(obj4);
    		}
    	}
    	//print out 
    	System.out.println("rects: "+rects+" boxes: "+boxes+" circles: "+circles+" spheres: "+spheres);
    	System.out.println("sum: "+calculateSum(measurablearray));
    }
}
