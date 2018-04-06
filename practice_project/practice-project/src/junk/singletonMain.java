package junk;

public class singletonMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AgodaBenefitConfig abc = new AgodaBenefitConfig();
		System.out.println(abc.toString());
		AgodaBenefitConfig instance = abc.getInstance();
		System.out.println(instance.toString());
	}

}
