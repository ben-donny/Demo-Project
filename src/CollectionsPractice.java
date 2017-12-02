import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;




public class CollectionsPractice {

	public static void main(String[] args) {
	
	/*ArrayList<String> ls = new ArrayList<String>();
		ls.add("Ben");
		ls.add("James");
		ls.add("Mark");
		ls.add("Alex"); 
		
		//System.out.println(ls);
		//System.out.println(ls.get(2));
		// System.out.println(ls.contains("Timothy")); 
       System.out.println(!(ls.isEmpty()));*/
		
		List<String>ls = new ArrayList<String>();
		ls.add("Mark");
		ls.add("Dave");
		ls.add("Kolo");
		ls.add("Bishop");
		ls.add("Onome");
		System.out.println(ls);
		System.out.println(ls.size());
		System.out.println(ls.get(2));
		System.out.println(!(ls.isEmpty()));
		
		
	Iterator<String> l = ls.iterator();
		
	     while(l.hasNext()){
			
			System.out.println(l.next());
			
			
		}
	
		
		
		
	}

}
