import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {	
		
		
		ArrayList<Contact> contacts = new ArrayList<>();
		//credit: https://piazza.com/class/isz0f3qcm4d753?cid=78 from a student
		try{
			URL url = new URL("http://www.cs.uoregon.edu/Classes/16F/cis212/assignments/phonebook.txt");
		    //https://docs.oracle.com/javase/tutorial/networking/urls/readingURL.html
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null){
				String[] inputarray = inputLine.split(" ",2);
				String part1 = inputarray[0];
				String part2 = inputarray[1];
				Contact contact = new Contact(inputarray[0],inputarray[1]);
				contacts.add(contact);
			}
			in.close();
		}catch(MalformedURLException e){
			System.out.println(e);
		}catch(IOException e){
			System.out.println(e);
		}
		MainFrame frame = new MainFrame(contacts);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
				
		frame.setVisible(true);
	}
}
