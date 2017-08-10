//Circle with class constructor and  getarea
public class Circle implements Measurable{
    private double radius;
	
    public void Circle(double radius){
    	 this.radius = radius;
    }
	
    public double getArea(){
		return (radius*radius)*Math.PI;
	}
}
