
public class practice2 {

	public static void main(String[] args) {
		
		//int c[] = {2, 5, 8, 7, 4, 10, 11, 12,13};
		//int total = 0;
		//for (int i = 0; i < c.length; i++){	
			//total = total + c[i]; 
			int bucky [] = {3,4,5,6,7};
			
			int firstarry [][] = {{6,8,9,10}, {12,11,15,14},{89,78,23,24}}; 
			int secondarry [][] = {{7,11,12,10}, {18,19,15,14},{98,78,23,24}}; 
			System.out.println("This is the first array");
			display(firstarry);
		
			System.out.println("This is the second array");
			display(secondarry);
		  // total = total + c[i]; 
		
		//System.out.println(c[i]);
			//if (c[i] == 8){
	          //break; 
			//}
	//	}		
		
		//System.out.println(total);
	
		// for(int a : c){
			//System.out.println(a);
			//if(a == 5){
			//	break; 
			//}
		// total += a;
		 
		//}
	  // System.out.println(total);
			change(bucky);
			for(int xy: bucky){
				System.out.println(xy);
			}
	}
	
	public static void change(int x[]){
		for(int counter=0; counter<x.length; counter ++)
			x[counter]+= 5; 
		
	}
	
	public static void display(int x[][]){
		for(int row=0; row<x.length; row++){
			for(int column =0; column<x[row].length; column++){
				System.out.print(x[row][column] + "\t");
			}
			System.out.println();
		}
		
	}
}
