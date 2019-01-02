import java.util.Scanner;
import java.util.TreeMap;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
//import java.util.Hashtable;
import java.util.Map;

public class Day9_1
{
    public static void main (String args[]) throws java.io.IOException
    {
        Scanner s = new Scanner(new File("input_day9.txt"));
      
        ArrayList<Integer> marbels = new ArrayList<Integer>();
        String[] input = null;
        Integer numOfPlayer = 0;
        Integer lastMarbleWorth = 0;


        while (s.hasNextLine()){
        	input = s.nextLine().split(" ");
        	numOfPlayer = Integer.parseInt(input[0]);
        	lastMarbleWorth = Integer.parseInt(input[1]);
        }
        
        
        s.close();
        
        int index = 0;
        
        Double[] players = new Double[numOfPlayer];
        for (int i = 0; i < players.length; i++) {
        	players[i] = 0.0;
		}
        int actual = 0;
        
        for (int i = 0; i < lastMarbleWorth+1; i++) {
        	if(i < 2) {
        		marbels.add(i);
        		actual = i;
        	} else if( i % 23 == 0) {
        		if (actual-7 < 0) {
        			actual = marbels.size() + actual - 7;
				} else {
					actual = actual - 7;
				}
        		int point = i + marbels.get(actual);
        		index = (i - 1) % numOfPlayer;
        		players[index] += point;
        		marbels.remove(actual);
        	} else {
        		if(actual+2 > marbels.size()) {
        			
        			actual = actual + 2 - marbels.size();
        		}else {
        			actual+=2;
        		}
        		marbels.add(actual, i);
        			
        	}
        	System.out.println(i);
		}
        
        ArrayList<Double> points = new ArrayList<Double>();
        for (Double num : players) {
				points.add(num);     	
		}
        System.out.println();
        System.out.println("Number of Player: " + numOfPlayer);
        System.out.println("Last marble worth: " + lastMarbleWorth);
        System.out.println("High Score: " + Collections.max(points));

    }
}