
public class Practice3 {

	public static void main(String[] args) {
	
		int c[] = { 2, 5, 8, 7, 4, 10, 11, 12, 13 };
		int total = 0;

		for (int z : c)
			total += z;
		System.out.println(total);
		
		char[] helloArray = { 'h', 'e', 'l', 'l', 'o', '.' };
		String helloString = new String(helloArray);
		System.out.println(helloString);
		
		String palindrome = "Dot saw I was Tod";
		int len = palindrome.length();
		System.out.println(len);	
		guessName("Johnson");
		
		
		
		
	}
	
	public static void guessName(String name){
		
		switch(name){
		
		case "Ben":
			System.out.println("This is not my name");
			break;
			
		case "James":
			System.out.println("This is not my name");
			break;
			
		case "Mark":
			System.out.println("This is not my name");
			break;
			
		case "Johnson":
			System.out.println("Congratulations! you have guess my name right! cheers");
			break;
			default:
				System.out.println("That is way out of range");
			
	}
		

}
	}



