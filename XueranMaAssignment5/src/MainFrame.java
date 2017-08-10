import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MainFrame extends JFrame{
    private ArrayList<Contact> _contactsCopy;
    
    //credit: https://www.cs.uoregon.edu/Classes/16F/cis212/examples/11-2a.java   from professor's example
    private static double elapsedTimeMs(long startTimeNs) {
		return (System.nanoTime() - startTimeNs)/1000000.0;
	}
    
    public MainFrame(ArrayList<Contact> contacts){
    	super("Assignment5");
    	setContactList(contacts);
    	setLayout(new BorderLayout());
    	
    	//set the lable for selection button
    	JLabel _label1 = new JLabel("");
    	//selectionSort button
    	JButton selectionButton = new JButton("Selection Sort");
    	ArrayList<Contact> forSorting = this._contactsCopy;//?????
    	selectionButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				long startTimeNs = System.nanoTime();
				ArrayList<Contact> result = SelectionSort.selectionSort(forSorting);
				//for (Contact i: result){
				//    System.out.println(i.getName());
				//}
				double elapsedTimeMs = elapsedTimeMs(startTimeNs);
				if (Check.Check(result)){
					_label1.setText(String.valueOf(elapsedTimeMs));
				}else{
					_label1.setText("Error");
				}	
			}			
		});
    	
    	//set the label for merge sort button
    	JLabel _label2 = new JLabel("");
    	
    	//mergeSort button
    	JButton mergeButton = new JButton("Merge Sort");
    	ArrayList<Contact> forSorting1 = this._contactsCopy;//??
    	mergeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				long startTimeNs1 = System.nanoTime();
				
				List<Contact> result1 = MergeSort.MergeSort(forSorting1);
				for (Contact i:result1){
					System.out.println(i.getName());
				}
				
				double elapsedTimeMs1 = elapsedTimeMs(startTimeNs1);
				if (Check.Check(result1)){
					_label2.setText(String.valueOf(elapsedTimeMs1));
				}else{
					_label2.setText("Error");
				}	
			}			
		});
    	
    	 JPanel sortButtonPanel = new JPanel(new GridLayout(2,2));
    	 sortButtonPanel.add(selectionButton);
    	 sortButtonPanel.add(_label1);
    	 sortButtonPanel.add(mergeButton);
    	 sortButtonPanel.add(_label2);
    	 add(sortButtonPanel, BorderLayout.LINE_START);
    	
    	
    	
    }
    
    public void setContactList(ArrayList<Contact> contacts){
    	this._contactsCopy = contacts;
    }
    
    
    
}
