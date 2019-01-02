import java.util.Scanner;
import java.util.TreeMap;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Day7_2
{
    public static void main (String args[]) throws java.io.IOException
    {
        Scanner s = new Scanner(new File("input_day7.txt"));
        TreeMap<String,ArrayList<String>> list = new TreeMap<String,ArrayList<String>>();
        ArrayList<String> Nodes = new ArrayList<String>();
        ArrayList<String> Available = new ArrayList<String>();
        
        ArrayList<String> Finished = new ArrayList<String>();

        while (s.hasNextLine()){
        	String[] nodes = s.nextLine().split(" ");
        	ArrayList<String> dependencies = new ArrayList<String>();
        	dependencies.add(nodes[0]);
        	if (!Nodes.contains(nodes[0])) {
        		Nodes.add(nodes[0]);
			}
        	if (!Nodes.contains(nodes[1])) {
        		Nodes.add(nodes[1]);
			}

        	if (list.containsKey(nodes[1])) {
        		list.get(nodes[1]).add(nodes[0]);
        		Collections.sort(list.get(nodes[1]));
			} else {
				list.put(nodes[1], dependencies);
			}
        	
        	

        }
        
        s.close();
        
        Collections.sort(Nodes);
        
        for (int i = 0; i < Nodes.size(); i++) {
        	String node = Nodes.get(i);
			if(!list.containsKey(node)) {
				Available.add(node);
			}
		}
        
        Collections.sort(Available);
//        Finished.addAll(Available);
        
        String[][] Worker = new String[5][2];
//        Integer Worker1 = 0;
//        Integer Worker2 = 0;
//        Integer Worker3 = 0;
//        Integer Worker4 = 0;
//        Integer Worker5 = 0;
        Integer workload = 0;
        for (int i = 0; i < 5; i++) {
        	Worker[i][0] = "";
        	Worker[i][1] = "0";
		}
        
        
        int i = 0;
        int second = 0; 
        Boolean stepforward = true;
        int prevFinishSize = 0;
        
        ArrayList<String> Working = new ArrayList<String>();
//        for (int i = 0; i < Available.size(); i++) {
        while (Finished.size() != Nodes.size()) {
        	
        	
        	prevFinishSize = Finished.size();
        	stepforward = true;
        	
        	for (String string : Available) {
        		
        		for (int j = 0; j < 5; j++) {
					if ( Integer.parseInt(Worker[j][1]) == 0 ) {
						Worker[j][0] = string;
						workload = -4 + (int) string.charAt(0);
						Worker[j][1] = workload.toString();
						Working.add(string);
						stepforward = false;
						break;
					}else {
//						stepforward = true;
					}
				}
        	
        	}
        	if (Working.size() != 0) {
        		Available.removeAll(Working);
			}
        	
        	
        	for (int j = 0; j < 5; j++) {
        		if (!Worker[j][0].equals("")) {

	        		if ( Integer.parseInt(Worker[j][1]) != 0 ) {
	        			Integer newnum = Integer.parseInt(Worker[j][1]) - 1;
	        			Worker[j][1] = newnum.toString();
	        		}
	        		if ( Integer.parseInt(Worker[j][1]) == 0 ) {
	        			Finished.add(Worker[j][0]);
	        			Worker[j][0] = "";
	        		}
        		}
        	}
        	
        	if (prevFinishSize == Finished.size()) {
        		second++;
				continue;
			}
        	
        	second++;
        	
//        	if (!Finished.contains(Available.get(i))) {
//				
//			
//	        	Finished.add(Available.get(i));
	        	
	        	ArrayList<String> newlyAvailable = new ArrayList<String>();
	        	for(HashMap.Entry<String, ArrayList<String>> entry : list.entrySet()) {
	        		if (Finished.containsAll(entry.getValue()) && !Working.contains(entry.getKey()) ) { //entry.getValue().contains(Available.get(i)) &&
							newlyAvailable.add(entry.getKey());
					}
	        	}
	        	if (newlyAvailable.size() != 0) {
	        		Available.addAll(newlyAvailable);
				}
	        	
	        	if (Available.size() != 0) {
	        		Collections.sort(Available);
				}
	        	
//	        	if (newlyAvailable.size() != 0) {
//					i = 0;
//				}else {
//					i++;
//				}
	        	
//        	}else {
//        		i++;
//        	}
        	
		}
        
        
        for (String string : Finished) {
        	System.out.print(string);
		}
        
        System.out.print(second);
        
    }
}