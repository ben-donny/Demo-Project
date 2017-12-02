
public class PersonExample {

	public static void main(String[] args) {
	
		Person p = new Person("Ben", "Ohis", "Idonije","53 Cleveland Road", "DonnyB");
        System.out.println(p.getFirstName()+ " " + p.getMiddleNames()+ " " + p.getLastName());
		p.name();
		//System.out.println(	p.getMiddleNames());
		//System.out.println(p.getLastName());
	int age =60;
	if(!(age<50)){
		System.out.println("You are still a young man");
	}else {
		System.out.println("You are getting old");
	}
		
		
  
	}

}
