import java.util.ArrayList;

public class Day14_2 {
	public static final int WORD_LENGTH = 6;
	public static void main(String[] args) {

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
		
		String goal = "939601"
				+ "";
		String lastsix = "";
		
		while( !lastsix.equals(goal) ) {
			sum = list.get(firstActual) + list.get(secondActual);
			if (sum > 9) {
				list.add(1);
				list.add(sum % 10);
			}else {
				list.add(sum);
			}
			
			if(list.size() > WORD_LENGTH) {
				lastsix = "";
				for (int i = list.size()-WORD_LENGTH; i < list.size(); i++) {
					lastsix += list.get(i).toString();
				}
			}
			firstActual = (firstActual + 1 + list.get(firstActual) ) % list.size();
			secondActual = (secondActual + 1 + list.get(secondActual) ) % list.size();
			
//			if (list.size() % 1000000 == 0) {
//				System.out.println(list.size());
//			}
			
		}
		System.out.println(list.size()-WORD_LENGTH);
	}	
}
