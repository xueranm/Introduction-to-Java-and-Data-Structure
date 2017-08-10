//rectangl with class constructor and  getarea
public class Rectangl implements Measurable{
	private double length;
	private double wide;
	
	public void Rectangl(double length, double wide){
		this.length = length;
		this.wide = wide;
	}
    
	public double getArea(){
    	return length*wide;
    }
}
