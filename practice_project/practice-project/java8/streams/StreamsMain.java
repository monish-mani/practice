package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamsMain {

	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));
		
		
		
		
		
		/**
		 * 1. Find all transactions in the year 2011 and sort them by value (small to high). 
		 * 2. What are all the unique cities where the traders work?
			3. Find all traders from Cambridge and sort them by name.
			4. Return a string of all traders’ names sorted alphabetically.
			5. Are any traders based in Milan?
			6. Print all transactions’ values from the traders living in Cambridge. 7. What’s the highest value of all the transactions?
			8. Find the transaction with the smallest value.
		 */
		
		//Answers:
		//1
		List<Transaction> result1 = transactions.stream()
												.filter(t -> t.getYear() == 2011)
												.sorted(Comparator.comparing(Transaction::getValue))
												.collect(Collectors.toList());
		
		result1.stream().forEach(t -> System.out.println(t.getYear() + "-" + t.getValue()));
		
		
		//2
		List<String> result2 = transactions.stream()
											.map(Transaction::getTrader)
											.map(Trader::getCity)
											.distinct()
											.collect(Collectors.toList());
		
		result2.stream().forEach(t -> System.out.println(t));
		
		//3
		List<Trader> result3 = transactions.stream()
											.map(Transaction::getTrader)
											.filter(t -> t.getCity().equals("Cambridge"))
											.sorted(Comparator.comparing(Trader::getName))
											.collect(Collectors.toList());
		
		result3.stream().forEach(t -> System.out.println(t.getName()));
		
		
		//4
		String result4 = transactions.stream()
											.map(Transaction::getTrader)
											.map(Trader::getName)
											.distinct()
											.sorted()
											.reduce("",(t1,t2) -> t1+t2+" ");
		
		System.out.println(result4);
		
		//5
		boolean tradersInMilan = transactions.stream()
												.map(Transaction::getTrader)
												.map(Trader::getCity)
												.anyMatch(t -> t.equals("Milan"));
		
		System.out.println(tradersInMilan);
		
		//6
		transactions.stream()
					.filter(t -> t.getTrader().getCity().equals("Cambridge"))
					.map(t -> t.getValue())
					.forEach(v -> System.out.println(v));
		
		//7
		Optional<Integer> max = transactions.stream().map(Transaction::getValue).reduce(Integer::max);
		System.out.println(max.get());
		
		
		//8
		Optional<Integer> min = transactions.stream().map(Transaction::getValue).reduce(Integer::min);
		System.out.println(min.get());
		
	}

}
