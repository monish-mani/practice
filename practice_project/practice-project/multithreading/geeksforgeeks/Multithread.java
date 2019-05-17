package geeksforgeeks;

public class Multithread {
	
	public static void main(String[] args) 
    { 
        int n = 8; // Number of threads 
        for (int i=0; i<8; i++) 
        { 
            Thread object = new Thread(new MultithreadingDemo1()); 
            object.start(); 
        } 
    } 

}
