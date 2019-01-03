import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Day13_2 { 
	
	public static void main(String[] args) throws FileNotFoundException { 		
		
		Scanner s = new Scanner(new File("input_day13.txt"));
		char[][] field = new char[150][150];
		int i = 0;
		
		while (s.hasNextLine()){
			field[i] = Arrays.copyOf(s.nextLine().toCharArray(), 150);
			i++;
		}
		
		s.close();
		
		ArrayList<Cart> carts = new ArrayList<Cart>();
		
		for (int j = 0; j < 150; j++) {
			for (int k = 0; k < 150; k++) {
				if (field[j][k] == '^' || 
					field[j][k] == '>' ||
					field[j][k] == 'v' ||
					field[j][k] == '<'
						) {
					carts.add(new Cart(j, k, field[j][k], "left", false, false));
					
				}
				System.out.print(field[j][k]);
			}
			System.out.println();
		}
		
		boolean crash = false;
		Cart removeOne = null;
		Cart removeTwo = null;
		
		while (carts.size() > 1) {
			
			for (Cart cart : carts) {
				switch (cart.getDirection()) {
				case '^':

					if(field[cart.getPosX()-1][cart.getPosY()] == '+') {
					  switch (cart.getNextTurn()) {
						case "left":
							cart.setDirection('<');
							cart.setNextTurn("straight");
							break;

						case "straight":
							cart.setNextTurn("right");
							break;
						
						case "right":
							cart.setDirection('>');
							cart.setNextTurn("left");
							break;
							
						default:
							break;
						}
						
					}
					if(field[cart.getPosX()-1][cart.getPosY()] == '/') {
						cart.setDirection('>');
					}
					if(field[cart.getPosX()-1][cart.getPosY()] == '\\') {
						cart.setDirection('<');
					}
					
					cart.setPosX(cart.getPosX()-1);
					
					for (Cart compare : carts) {
						if (compare != cart && !compare.isCrashed()) {
							if (compare.getPosX() == cart.getPosX() && compare.getPosY() == cart.getPosY()) {
								crash = true;
								removeOne = cart;
								removeTwo = compare;
								cart.setCrashed(true);
								compare.setCrashed(true);
							}
						}
					}
					
					break;
			
				case '>':

					if(field[cart.getPosX()][cart.getPosY()+1] == '+') {
						switch (cart.getNextTurn()) {
						case "left":
							cart.setDirection('^');
							cart.setNextTurn("straight");
							break;

						case "straight":
							cart.setNextTurn("right");
							break;
						
						case "right":
							cart.setDirection('v');
							cart.setNextTurn("left");
							break;
							
						default:
							break;
						}
						
					}
					if(field[cart.getPosX()][cart.getPosY()+1] == '/') {
						cart.setDirection('^');
					}
					if(field[cart.getPosX()][cart.getPosY()+1] == '\\') {
						cart.setDirection('v');
					}
					
					cart.setPosY(cart.getPosY()+1);
					
					for (Cart compare : carts) {
						if (compare != cart && !compare.isCrashed()) {
							if (compare.getPosX() == cart.getPosX() && compare.getPosY() == cart.getPosY()) {
								crash = true;
								removeOne = cart;
								removeTwo = compare;
								cart.setCrashed(true);
								compare.setCrashed(true);
							}
						}
					}
					
					break;
				
				case 'v':
					
					if(field[cart.getPosX()+1][cart.getPosY()] == '+') {
						switch (cart.getNextTurn()) {
						case "left":
							cart.setDirection('>');
							cart.setNextTurn("straight");
							break;

						case "straight":
							cart.setNextTurn("right");
							break;
						
						case "right":
							cart.setDirection('<');
							cart.setNextTurn("left");
							break;
							
						default:
							break;
						}
						
					}
					if(field[cart.getPosX()+1][cart.getPosY()] == '/') {
						cart.setDirection('<');
					}
					if(field[cart.getPosX()+1][cart.getPosY()] == '\\') {
						cart.setDirection('>');
					}
					
					cart.setPosX(cart.getPosX()+1);
					
					for (Cart compare : carts) {
						if (compare != cart && !compare.isCrashed()) {
							if (compare.getPosX() == cart.getPosX() && compare.getPosY() == cart.getPosY()) {
								crash = true;
								removeOne = cart;
								removeTwo = compare;
								cart.setCrashed(true);
								compare.setCrashed(true);
							}
						}
					}
					
					break;
				
				case '<':
					
					if(field[cart.getPosX()][cart.getPosY()-1] == '+') {
						switch (cart.getNextTurn()) {
						case "left":
							cart.setDirection('v');
							cart.setNextTurn("straight");
							break;

						case "straight":
							cart.setNextTurn("right");
							break;
						
						case "right":
							cart.setDirection('^');
							cart.setNextTurn("left");
							break;
							
						default:
							break;
						}
						
					}
					if(field[cart.getPosX()][cart.getPosY()-1] == '/') {
						cart.setDirection('v');
					}
					if(field[cart.getPosX()][cart.getPosY()-1] == '\\') {
						cart.setDirection('^');
					}
					
					cart.setPosY(cart.getPosY()-1);
					
					for (Cart compare : carts) {
						if (compare != cart && !compare.isCrashed()) {
							if (compare.getPosX() == cart.getPosX() && compare.getPosY() == cart.getPosY()) {
								crash = true;
								removeOne = cart;
								removeTwo = compare;
								cart.setCrashed(true);
								compare.setCrashed(true);
							}
						}
					}
					
					break;
				
				default:
					break;
				}
			}
			carts.remove(removeOne);
			carts.remove(removeTwo);
			Collections.sort(carts);
			
		}
		
		
		System.out.println();
		
		for (Cart cart : carts) {
			System.out.println(cart.getPosX() + "," + cart.getPosY() + ": " + cart.getDirection());
		}
		
		Collections.sort(carts);
		
		System.out.println();
		
		for (Cart cart : carts) {
			System.out.println(cart.getPosX() + "," + cart.getPosY() + ": " + cart.getDirection());
		}
		
	}
}
