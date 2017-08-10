import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
//create canvas class
public class Canvas extends JPanel{
	private final ArrayList<Template> _points;
	
	private Color _currentColor;
	public int _currentSize;
	
	public Canvas(){
		_points = new ArrayList<>();
		_currentColor = Color.BLACK;
		_currentSize = Template.SMALL_SIZE;
		
		//add points of type template to arrary list
		MouseAdapter adapter = new MouseAdapter(){
			    @Override
		    public void mouseDragged(MouseEvent e){
				Template point = new Template(e.getX(), e.getY(),
						_currentSize,_currentColor);
				_points.add(point);
				repaint();
			}
		};
		addMouseListener(adapter);
		addMouseMotionListener(adapter);		
	}
	
	//draw the points
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for (Template point : _points) {
			g.setColor(point.getColor());
			g.fillOval(point.getX(), point.getY(), point.getSize(), point.getSize());
		}
	}
	public void setColor(Color color) {
		_currentColor = color;
	}
	
	public void setSize(int size) {
		_currentSize = size;
	}
	
	public void clear(){
		_points.clear();
		repaint();
	}
}
