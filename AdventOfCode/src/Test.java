import java.util.Scanner;
import java.util.TreeMap;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
//import java.util.Hashtable;
import java.util.Map;

public class Test
{
    public static void main (String args[]) throws java.io.IOException
    {
        Scanner s = new Scanner(new File("input_day7.txt"));
        TreeMap<String,ArrayList<String>> list = new TreeMap<String,ArrayList<String>>();
//        TreeMap<String,Integer> Nodes = new TreeMap<String,Integer>();
//        ArrayList<String> dependencies = new ArrayList<String>();
        ArrayList<String> Nodes = new ArrayList<String>();
        ArrayList<String> Available = new ArrayList<String>();
        
//        ArrayList<String> newlyAvailable = new ArrayList<String>();
        ArrayList<String> Deleted = new ArrayList<String>();

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
        
//        for (int i = 65; i < 91; i++) {
//			Nodes.add( Character.toString((char) i));
//		}
       // Nodes = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"];
        
        Collections.sort(Nodes);
        
        for (int i = 0; i < Nodes.size(); i++) {
        	String node = Nodes.get(i);
			if(!list.containsKey(node)) {
				Available.add(node);
			}
		}
        
        Collections.sort(Available);
        
        
        
        for (int i = 0; i < Available.size(); i++) {
        	if (!Deleted.contains(Available.get(i))) {
				
			
        	Deleted.add(Available.get(i));
        	
        	ArrayList<String> newlyAvailable = new ArrayList<String>();
        	for(HashMap.Entry<String, ArrayList<String>> entry : list.entrySet()) {
        		if (entry.getValue().contains(Available.get(i)) && Available.containsAll(entry.getValue()) ) {
//					if (Available.containsAll(entry.getValue())) {
						newlyAvailable.add(entry.getKey());
//					}
				}
        	}
        	Available.addAll(newlyAvailable);
        	Collections.sort(Available);
        	if (newlyAvailable.size() != 0) {
				i = -1;
			}
        	}
        	
		}
        
        
//        int i = 0;
//        while (Deleted.size() != Nodes.size()) {
//        	
//        	
//        	
//        	
//        	if (i == 0) {
//        		Deleted.add(Available.get(i));
//			} else {
//				for (int j = 0; j < Available.size(); j++) {
//					if(!Deleted.contains(Available.get(j))) {
//						Deleted.add(Available.get(j));
//						break;
//					}
//				}
//			}
//        	
//        	ArrayList<String> newlyAvailable = new ArrayList<String>();
//        	
//        	for(HashMap.Entry<String, ArrayList<String>> entry : list.entrySet()) {
//        		if (Available.containsAll(entry.getValue()) && !Available.contains(entry.getKey())) {
//        			
//        		//if (entry.getValue().containsAll(Available)) {
////        			for (String denpends : entry.getValue()) {
////        				if (!Available.contains(denpends) && !Deleted.contains(denpends) ) {
//        			newlyAvailable.add(entry.getKey());
////						}
////        			}
//        			
//        			
//				}
//        	}
//        	Available.addAll(newlyAvailable);
//        	Collections.sort(Available);
//        	i++;
//		}
        
        for (String string : Deleted) {
        	System.out.print(string);
		}
        
    }
}