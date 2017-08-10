
public class Sphere extends Circle{
    private double radius;
    public void sphere(double radius){
        this.radius=radius;	 
    }
    public double getArea(){
    	return Math.PI*4*radius**2;
    }
}
