import java.util.Scanner;
import java.util.TreeMap;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;



public class Day8_1
{
	
	public static Integer recursion (Scanner s) {
		Integer newnum1 = Integer.parseInt(s.next());
		Integer newnum2 = Integer.parseInt(s.next());
		Integer sum = 0;
		if (newnum1 > 0) {
			for (int i = 0; i < newnum1; i++) {
				sum += recursion(s);
			}
			
		}
		if(newnum2 > 0){
			for (int j = 0; j < newnum2; j++) {
				sum += Integer.parseInt(s.next());
			}
		}
		
		return sum;
	}
	
    public static void main (String args[]) throws java.io.IOException
    {
        Scanner s = new Scanner(new File("input_day8.txt"));
        	
        	Integer result = 0;

        	
        	result = recursion(s);
        	
        	System.out.print(result);
        	        
        
        s.close();
 
    }
}