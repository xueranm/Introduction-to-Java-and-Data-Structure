
public class Rectangl implements Measurable{
	private double length;
	private double wide;
	public void rectangl(double length, double wide){
		this.length = length;
		this.wide = wide;
	}
    public double getArea(){
    	return length*wide;
    }
}
