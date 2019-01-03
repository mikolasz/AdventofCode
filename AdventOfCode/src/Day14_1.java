import java.util.ArrayList;
import java.io.*;

public class Day14_1 {
	public static void main(String[] args) throws IOException {
		
		File file = new File("output3.txt");
		FileWriter fw = new FileWriter(file);
		PrintWriter pw = new PrintWriter(fw);

		ArrayList<Integer> list = new ArrayList<Integer>();
		
		list.add(3);
		list.add(7);
		
		int firstActual = 0;
		int secondActual = 1;
		int sum = 0;
		
		for (Integer integer : list) {
			System.out.print(integer + " ");
		}
		System.out.println();
		
		int input = 21000000; //939601;
		
		while(list.size() != ( input + 10 ) ) {
			sum = list.get(firstActual) + list.get(secondActual);
			if (sum > 9) {
				list.add(1);
				list.add(sum % 10);
			}else {
				list.add(sum);
			}
			
			firstActual = (firstActual + 1 + list.get(firstActual) ) % list.size();
			secondActual = (secondActual + 1 + list.get(secondActual) ) % list.size();
			
		}
		
		for (int i = 0; i < list.size(); i++) {	//int i = list.size()-10
//			System.out.print(list.get(i));
			pw.print(list.get(i));
		}
		
		pw.close();
	}	
}
