package paypal;

public class Hackerrank2 {
	
	public static void main(String[] args){
		int[] input = {5,2,2};
		int[] input1 = {5,6,8,8,5};
		int[] input2 = {5,9,10};
		System.out.println(countMoves(input2));
		
	}

	
	
static long countMoves(int[] numbers) {

   
    int result=0;
    int min = Integer.MAX_VALUE;
    int sum=0;
    
    for(int i=0;i<numbers.length;i++){
        if(numbers[i] < min){
        	min = numbers[i];
        }
        sum+=numbers[i];
    }
    
    result = sum - (numbers.length * min);
    
    System.out.println("Sum " + sum + "Min " + min);
    
    return result;


}



}
