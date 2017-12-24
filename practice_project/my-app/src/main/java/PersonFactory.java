import com.monish.spring.test.Person;

public class PersonFactory {
	
	public Person createPerson(int id,String name){
		System.out.println("Creating person using person factory class:" + name);
		return new Person(id,name);
	}

}
