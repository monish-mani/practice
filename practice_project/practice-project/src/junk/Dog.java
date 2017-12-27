package junk;

public class Dog extends Animal implements Pet {
	
	private String name;
	private String trick;
	
	Dog(int height,int weight,String name,String trick){
		super(height,weight);
		this.name = name;
		this.trick = trick;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTrick() {
		return trick;
	}
	public void setTrick(String trick) {
		this.trick = trick;
	}
	
	public void introduce(){
		System.out.println("Hi my name is " + name);
	}
	@Override
	public void playWithOwner() {
		System.out.println(name + " is playing with its owner");
		
	}
	

}
