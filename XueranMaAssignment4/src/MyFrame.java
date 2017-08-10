
//open a UI windows
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JFrame{
	private final Canvas _canvas;
	
	public MyFrame(){
		//set canvas and title
		super("Painter");
		setLayout(new BorderLayout());
		
		_canvas = new Canvas();
		_canvas.setPreferredSize(new Dimension(400, 400));
        add(_canvas,BorderLayout.CENTER);
        
        //4 colors buttons
        JButton blackButton = new JButton("Black");
        blackButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_canvas.setColor(Color.BLACK);			
			}			
		});
        
        JButton redButton = new JButton("Red");
        redButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_canvas.setColor(Color.RED);			
			}			
		});
        
        JButton greenButton = new JButton("Green");
        greenButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_canvas.setColor(Color.GREEN);			
			}			
		});
        
        JButton blueButton = new JButton("Blue");
        blueButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_canvas.setColor(Color.BLUE);			
			}			
		});
        
        JPanel colorButtonPanel = new JPanel(new GridLayout(4,1));
        colorButtonPanel.add(blackButton);
        colorButtonPanel.add(redButton);
        colorButtonPanel.add(greenButton);
        colorButtonPanel.add(blueButton);
        add(colorButtonPanel, BorderLayout.LINE_START);
        
        //3 size buttons, 1 clear button
		JButton largeSizeButton = new JButton("Large(30)");
        largeSizeButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		_canvas.setSize(Template.LARGE_SIZE);
        	}
        });
        
        JButton mediumSizeButton = new JButton("Medium(20)");
        mediumSizeButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		_canvas.setSize(Template.MEDIUM_SIZE);
        	}
        });
        
        JButton smallSizeButton = new JButton("Small(10)");
        smallSizeButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		_canvas.setSize(Template.SMALL_SIZE);
        	}
        });
        
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener(){
        	@Override
        	public void actionPerformed(ActionEvent e){
        		_canvas.clear();
        	}
        });
        
        JPanel sizeButtonPanel = new JPanel(new GridLayout(4,1));
        sizeButtonPanel.add(largeSizeButton);
        sizeButtonPanel.add(mediumSizeButton);
        sizeButtonPanel.add(smallSizeButton);
        sizeButtonPanel.add(clearButton);
        add(sizeButtonPanel, BorderLayout.LINE_END);


	}
	
}
