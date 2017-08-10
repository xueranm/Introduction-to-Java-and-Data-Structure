
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;
// model is from professor 
public class Server {
	private static final int PORT = 1338;
	private static final int password3 = 123;
	private static final int password4 = 345;
	
	
	public static void main(String[] args) {	
		ArrayList<Integer> _primeList = new ArrayList<>();
		ArrayList<Integer> intList = new ArrayList<>();
		System.out.println("running server!");
		
		ServerSocket serverSocket = null;
		Socket socket = null;
		ObjectOutputStream outputStream = null;
		ObjectInputStream inputStream = null;		
		try {
			serverSocket = new ServerSocket(PORT);
			
			System.out.println("server socket created");
			
			socket = serverSocket.accept();
			
			System.out.println("got socket: " + socket);
			
			// Always flush an object output stream preemptively (see docs).
			outputStream = new ObjectOutputStream(socket.getOutputStream());
			outputStream.flush();
			
			inputStream = new ObjectInputStream(socket.getInputStream());
			Object intObject = inputStream.readObject();
		    intList = (ArrayList<Integer>) intObject;
		   
			while (intList.size()>=1) {
				//deobfuscating
				int a = intList.get(0)^password3;
				
				intList.remove(0);
				if (isPrime(a)){
					
					_primeList.add(a^password4);
				}				
			}		
			outputStream.writeObject(_primeList);
			outputStream.flush();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// Close resources in finally block so that they
			// get closed even if we hit an exception above.
			try {
				if (serverSocket != null) {
					serverSocket.close();
				}
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
		
		System.out.println("server finished");
	}
    //credit: learn from http://stackoverflow.com/questions/20798391/java-isprime-function
	private static boolean isPrime(int n){
		if (n==1){
			return false;
		}
		for(int i=2;i<=n/2;i++){
			if (n%i==0){
				return false;
			}
		}
		return true;
		/*if (a<2){
			return false;
		}
		if (a==2){
			return true;
		}
		if (a%2==0){
			return false;
		}
		for (int i=3;i*i<=a;i+=2){
			if (a%i==0){
				return false;
			}
		}
		return true;*/
		
	}
}
