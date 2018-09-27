package anonymous_class;

public class Apple {
	
	private int id;
	private int weight;
	private String country;
	
	
	public Apple(int id,int weight) {
		this.id = id;
		this.weight = weight;
	}
	
	public Apple(int id,int weight,String country) {
		this.id = id;
		this.weight = weight;
		this.country = country;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
	

}
