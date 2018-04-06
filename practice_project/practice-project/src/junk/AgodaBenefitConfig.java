package junk;

public class AgodaBenefitConfig {

	public static AgodaBenefitConfig abc_instance = null;
	
	
	public AgodaBenefitConfig getInstance(){
		if(abc_instance == null){
			abc_instance = new AgodaBenefitConfig();
		}
		return abc_instance;
	}
}
