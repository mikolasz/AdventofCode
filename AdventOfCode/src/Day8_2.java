import java.util.Scanner;
import java.util.TreeMap;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;



public class Day8_2
{
	
	public static Integer recursion (Scanner s) {
		Integer numOfChild = Integer.parseInt(s.next());
		Integer numOfMetadata = Integer.parseInt(s.next());
		ArrayList<Integer> nodevalues = new ArrayList<Integer>(); 
		Integer sum = 0;
		Integer metadatavalue = 0;
		Integer nodevalue = 0;
		if (numOfChild > 0) {
			for (int i = 0; i < numOfChild; i++) {
				nodevalue = recursion(s);
				nodevalues.add(nodevalue);
				//sum+= nodevalue;
			}
			
		}
		if(numOfMetadata > 0){
			if (numOfChild == 0) {
				for (int j = 0; j < numOfMetadata; j++) {
					sum+=Integer.parseInt(s.next());
				}
			} else {
				for (int j = 0; j < numOfMetadata; j++) {
					metadatavalue = Integer.parseInt(s.next());
					try {
						sum+=nodevalues.get(metadatavalue-1);
					}catch (IndexOutOfBoundsException e) {
//						sum+=0;// TODO: handle exception
					}
					
					
				}
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