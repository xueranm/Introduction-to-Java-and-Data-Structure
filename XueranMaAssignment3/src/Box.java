//Box with class constructor and  getarea
public class Box extends Rectangl{
    private double length;
    private double wide;
    private double high;
    
    public void Box(double length,double wide,double high){
    	this.length=length;
    	this.wide=wide;
    	this.high=high;
    }
    
    public double getArea(){
    	double area =0;
    	area = length*wide*2+length*high*2+wide*high*2;
    	return area;
    }
}
