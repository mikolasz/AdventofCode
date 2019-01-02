import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class Day1_2
{
    public static void main (String args[]) throws java.io.IOException
    {
        Scanner s = new Scanner(new File("input.txt"));
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        Integer result = 0;
        Integer curr_num;
        Boolean has_found = false;
        
        resultList.add(0);
        
        while (s.hasNext()){
        	curr_num = Integer.parseInt(s.next());
        	result = resultList.get(resultList.size() - 1) + curr_num;
        		
        	if (resultList.contains(result)) {
        		System.out.println(result);
        		has_found = true;
        		break;
			} else {
				resultList.add(result);
			}
        	list.add(curr_num);
        }
        
        while (has_found != true ){
        	for (Integer item : list) {
        		curr_num = item;
        		result = resultList.get(resultList.size() - 1) + curr_num;
        		if (resultList.contains(result)) {
            		System.out.println(result);
            		has_found = true;
            		break;
    			} else {
    				resultList.add(result);
    			}
			}
        }
        System.out.println(list);
        s.close();
    }
}