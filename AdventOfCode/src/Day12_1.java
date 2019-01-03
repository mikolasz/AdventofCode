import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day12_1 {
	public static void main(String[] args) {

		String init = ".......#####.##.#.##...#.#.###..#.#..#..#.....#..####.#.##.#######..#...##.#..#.#######...#.#.#..##..#.#.#...........................................................................................................................................................................................................................";
//		String init = "........#..#.#..##......###...###................";
		String next = init;
		Map<String,String> notes = new HashMap<String, String>()
		{
		    {
//		    	put("\\.\\.\\.##","#");
//		    	put("\\.\\.#\\.\\.","#");
//		    	put("\\.#\\.\\.\\.","#");
//		    	put("\\.#\\.#\\.","#");
//		    	put("\\.#\\.##","#");
//		    	put("\\.##\\.\\.","#");
//		    	put("\\.####","#");
//		    	put("#\\.#\\.#","#");
//		    	put("#\\.###","#");
//		    	put("##\\.#\\.","#");
//		    	put("##\\.##","#");
//		    	put("###\\.\\.","#");
//		    	put("###\\.#","#");
//		    	put("####\\.","#");
		    	
		    	put("#\\.\\.#\\.",".");
		    	put("##\\.\\.\\.","#");
		    	put("#\\.\\.\\.\\.",".");
		    	put("#\\.\\.\\.#","#");
		    	put("\\.\\.\\.#\\.",".");
		    	put("\\.#\\.\\.#","#");
		    	put("#\\.#\\.#",".");
		    	put("\\.\\.\\.\\.\\.",".");
		    	put("##\\.##","#");
		    	put("##\\.#\\.","#");
		    	put("###\\.\\.","#");
		    	put("#\\.##\\.",".");
		    	put("#\\.#\\.\\.","#");
		    	put("##\\.\\.#","#");
		    	put("\\.\\.#\\.#","#");
		    	put("\\.\\.#\\.\\.",".");
		    	put("\\.##\\.\\.",".");
		    	put("\\.\\.\\.##","#");
		    	put("\\.\\.\\.\\.#",".");
		    	put("#\\.###","#");
		    	put("#\\.\\.##","#");
		    	put("\\.\\.###","#");
		    	put("####\\.","#");
		    	put("\\.#\\.#\\.","#");
		    	put("\\.####",".");
		    	put("###\\.#","#");
		    	put("#####","#");
		    	put("\\.#\\.##",".");
		    	put("\\.##\\.#",".");
		    	put("\\.###\\.",".");
		    	put("\\.\\.##\\.",".");
		    	put("\\.#\\.\\.\\.","#");
		    }
		};
		int index = -1;
		
		System.out.println(init);
		for (int i = 0; i < 400; i++) {
			int count = 0;
//			String actual = ".................................................";
			String actual = ".....................................................................................................................................................................................................................................................................................................................................";
			char[] myNameChars = actual.toCharArray();
			for (Entry<String,String> entry : notes.entrySet()) {
				String regex = entry.getKey();
				Pattern p = Pattern.compile(regex);
				Matcher m = p.matcher(next);
				int j = 0;
			
				while (m.find(j)) {
					index = m.start();
					myNameChars[index+2] = entry.getValue().toCharArray()[0];
					j++;
					
				}
				
			}	   
			next = String.valueOf(myNameChars);
			for (int j = 0; j < myNameChars.length; j++) {
				if (String.valueOf((myNameChars[j])).equals("#")) {
					count = count + j - 6;
				}
			}
			System.out.print(i+1 + ": " + count + " ");
			System.out.println(next);
		}
		
//		System.out.println(count);
		
	}	
}
