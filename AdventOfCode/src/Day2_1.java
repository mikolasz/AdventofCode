import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Hashtable;
import java.util.Map;

public class Day2_1
{
    public static void main (String args[]) throws java.io.IOException
    {
        Scanner s = new Scanner(new File("input_2_1.txt"));
        ArrayList<String> list = new ArrayList<String>();
        Map<String, Integer> hashmap = new HashMap<String, Integer>(); 
        Boolean has_two = false;
        Boolean has_tree = false;
        Integer num_two = 0;
        Integer num_tree = 0;
      
        while (s.hasNext()){

        	list.add(s.next());

        }
        
        s.close();
        
        for ( String items : list) {
        	has_two = has_tree = false;
        	hashmap.clear();
        	char[] array = items.toCharArray();
        	for (char ch : array) {
        		String str = String.valueOf(ch);
        		if ( hashmap.get(str) == null ) {
        			hashmap.put(str, 1);
        		} else {
        			hashmap.put(str, hashmap.get(str) + 1);
        		}

        	}

        	for(Map.Entry<String, Integer> entry: hashmap.entrySet()){
        		if (entry.getValue() == 2 && has_two == false) {
        			num_two++;
        			has_two = true;
        			
				} 
        		if (entry.getValue() == 3 && has_tree == false) {
					num_tree++;
					has_tree = true;
				}
        	}

        }
        	

        System.out.println(num_two.toString() + " " + num_tree.toString());
        
    }
}