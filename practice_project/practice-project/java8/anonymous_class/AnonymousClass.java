package anonymous_class;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class AnonymousClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Apple> inventory = new ArrayList<>();
		inventory.add(new Apple(1,200, "india"));
		inventory.add(new Apple(2,200 ,"germany"));
		inventory.add(new Apple(3,200,"france"));
		inventory.add(new Apple(4,24,"austria"));
		inventory.add(new Apple(5,1200,"usa"));
		inventory.add(new Apple(6,2000,"canada"));
		inventory.add(new Apple(7,299,"togo"));
		inventory.add(new Apple(8,300,"alaska"));
		
		List<String> input = new ArrayList<>();
		input.add(";lajsdf");
		input.add("");
		input.add("");
		input.add("monish");
		input.add("anand");
		input.add("amma");
		
		Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
		
		Integer a = new Integer(10);
		
		List<String> nonEmptyStrings = filter(input,nonEmptyStringPredicate);
		
		List<Apple> heavyApples = filterApples(inventory, new ApplePredicate() {
			public boolean test(Apple apple) {
				return apple.getWeight() > 150;
			}
		});
		
		//heavyApples.stream().forEach(a -> System.out.println(a.getId()));
		//nonEmptyStrings.stream().forEach(s -> System.out.println(s));
		
		
		//Sorting apples based on weight and then comparing by country if 2 apples have the same weight
		inventory.sort(Comparator.comparing(Apple::getWeight).thenComparing(Apple::getCountry));
		inventory.stream().forEach(apple -> System.out.println(apple.getId() + "-" + apple.getWeight() + "-" + apple.getCountry()));
		
		
		//System.out.println(a.getId() + "-" + a.getWeight() + "-" + a.getCountry());
	}
	
	public static List<Apple> filterApples(List<Apple> inventory,ApplePredicate p){
		List<Apple> result = inventory.stream().filter(a -> a.getWeight() > 150).collect(Collectors.toList());
		return result;
	}
	
	public static List<String> filter(List<String> input, Predicate<String> stringPredicate){
		List<String> result = new ArrayList<>();
		for(String s : input) {
			if(stringPredicate.test(s)) {
				result.add(s);
			}
		}
		
		return result;
	}

}
