
public class Person {
	
	   private String firstName;
	   private String middleNames;
	   private String lastName;
	   private String address;
	   private String username;
	   
	   public Person(String firstName, String middleNames, String lastName,String address, String username) {
		this.firstName = firstName;
		this.middleNames = middleNames;
		this.lastName = lastName;
		this.address = address;
		this.username = "";
		//this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleNames() {
		return middleNames;
	}

	public String getLastName() {
		return lastName;
	}
	
	public void name(){
		System.out.println("My first name is: " + getFirstName() + 
				" My Middle name is: " + getMiddleNames() + 
				" My Last Name is: " + getLastName());
	}
	

}
