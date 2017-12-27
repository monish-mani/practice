package junk;

public class PetsMain {
	
	public static void main(String[] args){
		Animal animal = new Dog(12,100,"Caesar","Caesar's trick");
		
		
		Dog d = (Dog)animal;
		
		d.introduce();
		d.getName();
		d.getTrick();
		
		
		Pet p = d;
		p.playWithOwner();
		
		
	}

}
