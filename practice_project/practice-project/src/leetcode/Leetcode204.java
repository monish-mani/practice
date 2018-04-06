package leetcode;

public class Leetcode204 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countPrimes(4));
	}
	
	public static int countPrimes(int n) {
        int result=0;
        if(n == 0) return 0;
        
        for(int i=2;i<n;i++){
            if(isPrime(i)){
            	System.out.println(i+ " is prime!");result++;
            }
        }
        
        return result;
    }
    
    private static boolean isPrime(int num){
        int divisor=2;
        
        while(divisor <= num/2){
            if(num%divisor == 0) return false;
            divisor++;
        }
        return true;
    }
    
    
    /*
     * Better method below!
     */
    
    public int countPrimesBetter(int n) {
        //Original method taking too long. Its in github.
        //Following the boolean array method from dicussion.
        
        boolean[] primes = new boolean[n];
        int result=0;
        
        for(int i=2;i<n;i++){
            //Populate each multiple of i in the array as true
            if(primes[i]) continue;
            
            result++;
            for(int j=i;j<n;j=j+i){
                primes[j] = true;
            }
        }
        
        return result;
    }

}
