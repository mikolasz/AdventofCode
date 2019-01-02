import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Day6_1 {
	public static void main(String[] args) {

		File file = new File("input_day6_1.txt");
		
		Integer x_max = 0;
		Integer y_max = 0;
		
		Integer[][] matrix= new Integer[1000][1000];
		Integer[][] Points = new Integer[50][2];

		ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> intcor = new ArrayList<Integer>();
		Integer intCoord[] = new Integer[2];
		HashMap<String, Integer> hashmap = new HashMap<String, Integer>();

		try {
			Scanner sc = new Scanner(file);
			
			int iter = 0;
			
			while (sc.hasNextLine()) {
				
				String line = sc.nextLine();
				
				String[] coords = line.split(", ");

				intCoord[0] = Integer.parseInt(coords[0]);
				intCoord[1] = Integer.parseInt(coords[1]);
				
				Points[iter][0] = Integer.parseInt(coords[0]);
				Points[iter][1] = Integer.parseInt(coords[1]);

				if (Integer.valueOf(intCoord[0]) > x_max ) {
					x_max = Integer.valueOf(intCoord[0]);
				}
				if (Integer.valueOf(intCoord[1]) > y_max ) {
					y_max = Integer.valueOf(intCoord[0]);
				}
				hashmap.put(line, 0);
				
				iter++;
									
			}
			
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Integer> distance = new ArrayList<Integer>();
		int man_dis = 0;
		int min_man = 10000;
		String min_point = "";
		String point = "";
		Boolean common = false;
		for (int i = -200; i < 600; i++) {
			for (int j = -200; j < 600; j++) {
				min_man = 10000;
				common = false;
				int db = 0;
				
				point = i + ", " + j;
				if (hashmap.containsKey(point)) {
					min_point = point;
					db = 1;
				} else {
					
					for (int k = 0; k < Points.length; k++) {
						if ( Points[k][0] == i && Points[k][1] == j) {
							continue;
						}
						man_dis = Math.abs(Points[k][0] - i) +  Math.abs(Points[k][1] - j);
						
						
						if (min_man > man_dis) {
							db = 1;
							min_man = man_dis;
							min_point = Points[k][0].toString() + ", " + Points[k][1].toString();
						}else if (min_man == man_dis){
							db++;
						}
						
	//					if (distance.contains(man_dis)) {
	//						common = true;
	//						break;
	//					}
	//					distance.add(man_dis);
					}
				
				}
//				distance.clear();
				if (db == 1) {
					Integer value = hashmap.get(min_point);
					value++;
					hashmap.put(min_point, value);
				}
				
				
					
			}
			
		}
		
		
		
		
		for(Entry<String, Integer> entry : hashmap.entrySet()) {
		    	System.out.println(entry.getKey().toString() + " : "+ entry.getValue().toString());
		    	
		}
		
		for (int i = 0; i < Points.length; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print(Points[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println(hashmap.size());
		System.out.println("X max: " + x_max);
		System.out.println("Y max: " + y_max);

	}
}