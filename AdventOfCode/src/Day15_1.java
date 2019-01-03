import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Day15_1 { 
	
	public static final int FIELD_SIZE = 32;
	
	public static final char POINT = (char) 46;
	
	public static final char HASHTAG = (char) 35;
	
	public static char[][] copyArray(char[][] src) {
	    char[][] dst = new char[src.length][];
	    for (int i = 0; i < src.length; i++) {
	        dst[i] = Arrays.copyOf(src[i], src[i].length);
	    }
	    return dst;
	}
	
	public static int calcManhattan(int x1, int y1, int x2, int y2) {
		return ( Math.abs(x1 - x2) + Math.abs(y1 - y2) );
	}
	
	public static void main(String[] args) throws IOException, InterruptedException { 		
		
//		Scanner userInput = new Scanner(System.in);
		Scanner s = new Scanner(new File("input_day15.txt"));
		char[][] field = new char[FIELD_SIZE][FIELD_SIZE];
		char[][] copy = new char[FIELD_SIZE][FIELD_SIZE];
		int i = 0;
		
		while (s.hasNextLine()){
			field[i] = Arrays.copyOf(s.nextLine().toCharArray(), FIELD_SIZE);
			i++;
		}
		
		s.close();
		
		ArrayList<Player> players = new ArrayList<Player>();		
		
		for (int j = 0; j < FIELD_SIZE; j++) {
			for (int k = 0; k < FIELD_SIZE; k++) {
				if (field[j][k] != POINT && field[j][k] != HASHTAG ) {
					players.add(new Player(j, k, field[j][k]));
				} 
			}
		}
		
		Collections.sort(players);
		
		char opponens = ' ';
		char actPlayer = ' ';
		int minDistance = Integer.MAX_VALUE;
		int actDistance = 0;
		int chosenX = 0;
		int chosenY = 0;
		boolean isChosen = false;
		int playnum = 0;
		
		copy = copyArray(field);
		
		// one round 
			for (Player player : players) {
				System.out.println(playnum++);
				actPlayer = player.getType();
				
				
				if ( actPlayer == 'E') {
					opponens = 'G';
				} else {
					opponens = 'E';
				}
					
				for (Player other : players) {
					if (other.getType() == opponens) {
						if (copy[other.getPosX()-1][other.getPosY()] == '.') {
							copy[other.getPosX()-1][other.getPosY()] = '?';
						}
						if (copy[other.getPosX()][other.getPosY()+1] == '.') {
							copy[other.getPosX()][other.getPosY()+1] = '?';
						}
						if (copy[other.getPosX()][other.getPosY()-1] == '.') {
							copy[other.getPosX()][other.getPosY()-1] = '?';
						}
						if (copy[other.getPosX()+1][other.getPosY()] == '.') {
							copy[other.getPosX()+1][other.getPosY()] = '?';
						}
					}
				}
				
				minDistance = Integer.MAX_VALUE;
				for (int j = 1; j < FIELD_SIZE-1; j++) {
					for (int k = 1; k < FIELD_SIZE-1; k++) {
						if (copy[j][k] == '?') {
							actDistance = calcManhattan(player.getPosX(), player.getPosY(), j, k);
							if(minDistance > actDistance) {
								minDistance = actDistance;
							}
							if ( copy[j-1][k] == '.' ||
								 copy[j][k+1] == '.' ||
								 copy[j+1][k] == '.' ||
								 copy[j][k-1] == '.' ) {
								copy[j][k] = '@';
							} else {
								copy[j][k] = '.';
							}
						}
					}
				}
				
				isChosen = false;
				chosenX = 0;
				chosenY = 0;
				
				for (int j = 0; j < copy.length; j++) {
					for (int k = 0; k < copy.length; k++) {
						if (copy[j][k] == '@' ) {
							if ( calcManhattan(player.getPosX(), player.getPosY(), j, k) == minDistance && !isChosen) {
								copy[j][k] = '+';
								chosenX = j;
								chosenY = k;
								isChosen = true;
							} else {
								copy[j][k] = '.';
							}
						}
					}
				}
				
				//TODO: Ha az út nem is pontosan a minDistance-1 akkor is a legrövidebb úton induljon el. 
				
				if (copy[player.getPosX()-1][player.getPosY()] == '.' && ( calcManhattan(player.getPosX()-1,player.getPosY(), chosenX, chosenY) == minDistance -1 ) ) {
					
					copy[player.getPosX()-1][player.getPosY()] = actPlayer;
					copy[player.getPosX()][player.getPosY()] = '.';
					player.setPosX(player.getPosX()-1);
					player.setPosY(player.getPosY());
					
				} else if (copy[player.getPosX()][player.getPosY()-1] == '.' && ( calcManhattan(player.getPosX(),player.getPosY()-1, chosenX, chosenY) == minDistance -1 ) ) {
					
					copy[player.getPosX()][player.getPosY()-1] = actPlayer;
					copy[player.getPosX()][player.getPosY()] = '.';
					player.setPosX(player.getPosX());
					player.setPosY(player.getPosY()-1);
					
				} else if (copy[player.getPosX()][player.getPosY()+1] == '.' && ( calcManhattan(player.getPosX(),player.getPosY()+1, chosenX, chosenY) == minDistance -1 ) ) {
					
					copy[player.getPosX()][player.getPosY()+1] = actPlayer;
					copy[player.getPosX()][player.getPosY()] = '.';
					player.setPosX(player.getPosX());
					player.setPosY(player.getPosY()+1);
					
				} else if (copy[player.getPosX()+1][player.getPosY()] == '.' && ( calcManhattan(player.getPosX()+1,player.getPosY(), chosenX, chosenY) == minDistance -1 ) ) {
					
					copy[player.getPosX()+1][player.getPosY()] = actPlayer;
					copy[player.getPosX()][player.getPosY()] = '.';
					player.setPosX(player.getPosX()+1);
					player.setPosY(player.getPosY());
					
				}
				
				for (int j = 0; j < FIELD_SIZE; j++) {
					for (int k = 0; k < FIELD_SIZE; k++) {
						if (copy[j][k] == '+') {
							copy[j][k] = '.';
						}
					}
				}
				
				for (int j = 0; j < FIELD_SIZE; j++) {
					for (int k = 0; k < FIELD_SIZE; k++) {
						System.out.print(copy[j][k]);
					}
					System.out.println();
				}
//				System.out.println();
				
				field = copyArray(copy);
				
//				String input = userInput.nextLine();
				
			}
			
			Collections.sort(players);
			
//		for (int j = 0; j < FIELD_SIZE; j++) {
//			for (int k = 0; k < FIELD_SIZE; k++) {
//				System.out.print(field[j][k]);
//			}
//			System.out.println();
//		}
//		
//		System.out.println();
////		System.out.println("Copy:");
//		for (int j = 0; j < FIELD_SIZE; j++) {
//			for (int k = 0; k < FIELD_SIZE; k++) {
//				System.out.print(copy[j][k]);
//			}
//			System.out.println();
//		}
		
//		System.out.println("Player size: " + players.size());
//		for (Player player : players) {
//			System.out.println(player);
//		}
		
	}
}
