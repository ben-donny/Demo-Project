import java.text.DateFormat;
import java.util.*;
import java.util.Calendar;
import java.util.Date;





public class Practice4 {

	public static void main(String[] args) {

	    Date date = new Date();
		String myString;
		myString = DateFormat.getDateInstance().format(date);
		System.out.println(myString );
		
		   Calendar rightNow = Calendar.getInstance();
		  System.out.println(rightNow.getTime());
		
		
		   List<String> ls =  new ArrayList<String>(); 
		   ls.add("Johnny");
		   ls.add("Nunya");
		   
		   Map <String, String> map = new HashMap<String, String>();
		   map.put("URL", "www.benito.com");
	}

}
