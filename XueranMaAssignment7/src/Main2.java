import java.security.SecureRandom;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Main {
	private static boolean _produce=true;
	public static void main(String[] args){
		LinkedBlockingQueue<String> buffer = new LinkedBlockingQueue<String>(100001);
		
		ExecutorService executor = Executors.newCachedThreadPool();
		executor.submit(new Producer(buffer));
		executor.submit(new Consumer(buffer, "Consumer 1"));
		executor.submit(new Consumer(buffer, "Consumer 2"));
		executor.shutdown();
	}
	//producer class
	private static class Producer implements Runnable{
		private UUID uid;
		private LinkedBlockingQueue<String> _buffer;
		
		//constructor
		public Producer(LinkedBlockingQueue<String> buffer){
			this._buffer = buffer;
		}
		@Override
		public void run(){
			//add 2000000 strings to the queue
			for (int i=1;i<=2000;i++){
				try{
				    uid = UUID.randomUUID();
				    // debug System.out.println(uid);
				    String u = uid.toString();
				    _buffer.put(u);
				    if (i%1000==0){
				    	System.out.println("Produced: "+i);
				    }
				}catch(InterruptedException e){
					Thread.currentThread().interrupt();
					e.printStackTrace();
				}
			}
			_produce = false;
			System.out.println("done producing! 2000000 produced");
		}

	}
	//consumer class
	private static class Consumer implements Runnable{
	    private LinkedBlockingQueue<String> _buffer;
	    private String maxStr; 
	    private static final SecureRandom generator = new SecureRandom();
	    private String _name;
	    
	    //constructor
	    public Consumer(LinkedBlockingQueue<String> buffer,String name){
	    	this._buffer = buffer;
	    	this._name = name;
	    }
	    @Override
	    public void run(){
	    	int n = 1;
	    	try{
	    		
	    		maxStr = _buffer.poll(1, TimeUnit.SECONDS);
	    		
	    	    
	    	    while (_produce||!_buffer.isEmpty()){
	    		
	    		    String next = _buffer.poll(1,TimeUnit.SECONDS);
	    		    //System.out.println("next"+next);
	    		    if (maxStr!=null && next != null){
	    		    	if (next.compareToIgnoreCase(maxStr)>0){
	    			    maxStr = next;
	    			    n++;
	    		    	}
	    		    }else if(maxStr == null && next! =null){
	    		    	maxStr= next;
	    		    }

	    			Thread.sleep(generator.nextInt(10));
	    			if (n%1000==0){
	    				System.out.println(_name +" Consumed: "+n);
	    			}
	    	    }
	    	}catch(InterruptedException e){
	    			Thread.currentThread().interrupt();
					e.printStackTrace();
	    		
	    	}
	    	System.out.println(_name +" done consuming! "+n+" consumed");
	    	System.out.println("max String: "+ maxStr);
	    }
	}



}
