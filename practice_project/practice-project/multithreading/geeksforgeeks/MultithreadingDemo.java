package geeksforgeeks;

public class MultithreadingDemo extends Thread {
	
	public void run() {
		try {
			System.out.println("Thread " + Thread.currentThread().getId() + "is running");
		}catch(Exception e) {
			
		}
	}
	
	
	public static void main(String[] args) {
		int n=8;
		for(int i=0;i<n;i++) {
			MultithreadingDemo obj = new MultithreadingDemo();
			obj.start();
		}
	}

}
