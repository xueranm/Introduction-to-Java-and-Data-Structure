//Sphere with class constructor and  getarea
public class Sphere extends Circle{
    private double radius;
    public void Sphere(double radius){
        this.radius=radius;	 
    }
    public double getArea(){
    	return Math.PI*4*radius*radius;
    }
}
