import java.awt.Color;

//the template for the points
public class Template {
	
	public static final int LARGE_SIZE = 30;
	public static final int MEDIUM_SIZE = 20;
	public static final int SMALL_SIZE = 10;
	
    
	private final int _x;
    private final int _y;
    private final int _size;
    private final Color _currentcolor;
    
    public Template(int x, int y, int size, Color color){
       this._x=x;
       this._y=y;
       this._size=size;
       this._currentcolor=color;
    }
    
    public int getX(){
    	return this._x;
    }
    
    public int getY(){
    	return this._y;
    }
    
    public int getSize(){
    	return this._size;
    }
    
    public Color getColor(){
    	return this._currentcolor;
    }
}
