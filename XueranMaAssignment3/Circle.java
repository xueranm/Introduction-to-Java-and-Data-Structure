
public class Circle implements Measurable{
    private double radius;
	public void circle(double radius){
    	 this.radius = radius;
    }
	public double getArea(){
		return radius**2*Math.PI;
	}
}
