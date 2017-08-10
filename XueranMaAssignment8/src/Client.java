
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

import java.util.Scanner;



import javax.swing.SwingUtilities;
//model is from professor
public class Client{
	private static final int PORT = 1338;


	private final ArrayList<Integer> _intQueue;
	private final int password1 = 123; 
	private final int password2 = 345;
	private final ArrayList<Integer> _print;
	
	public Client() {
		
		_intQueue = new ArrayList<>();
		_print = new ArrayList<>();
		boolean quit = false;
		Scanner scanner = new Scanner(System.in);
		while (!quit){
			System.out.println("Enter a number, blank line to quit:");
			String number = scanner.nextLine();
			if (!number.equals("")){
				//try to change the string to number
				//credit: learn from https://www.mkyong.com/java/java-convert-string-to-int/
				int result = Integer.parseInt(number);
				//obfuscating the integer
				int obfresult = result^password1;
				_print.add(result);
			    _intQueue.add(obfresult);
			
			}else{
				System.out.println("client sent: "+_print.toString()+"\n");
				quit = true;
			}
			
		}
	    
		
				
	}
	
	public void handleNetwork() {
		
		Socket socket = null;
		ObjectOutputStream outputStream = null;
		ObjectInputStream inputStream = null;		
		try {
			InetAddress address = InetAddress.getLocalHost();
			socket = new Socket(address, PORT);
			
			
			
			// Always flush an object output stream preemptively (see docs).
			outputStream = new ObjectOutputStream(socket.getOutputStream());
			outputStream.flush();
			
			inputStream = new ObjectInputStream(socket.getInputStream());
			
			
			outputStream.writeObject(_intQueue);
			outputStream.flush();
				
			// Wait for a response.  Note that the response 
			// final so that it can be accessed inside 
			// the anonymous class below.
		    ArrayList<Integer> primeList = new ArrayList<>();
			Object response = inputStream.readObject();
			primeList = (ArrayList<Integer>) response;
			ArrayList<Integer> printList = new ArrayList<Integer>();
			for (int i=0;i<primeList.size();i++){
				printList.add(primeList.get(i)^password2);
				//primeList.remove(0);
			}
			
			// Append the response to the text area on
			// the UI thread.
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					System.out.println("client received: " + printList.toString() + "\n");
				}					
			});
		
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// Close resources in finally block so that they
			// get closed even if we hit an exception above.
			try {
				if (socket != null) {
					socket.close();
				}
				if (outputStream != null) {
					outputStream.close();
				}
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		
	}
	public static void main(String[] args) {
	    Client client = new Client();
		client.handleNetwork();
	}
}
