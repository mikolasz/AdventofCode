import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Day11_2 {
	public static int calcPowerLevel(int x, int y,int gridserial) {
		return (( (x*x*y + 20*x*y + x*gridserial + 100*y + 10*gridserial)/100 ) % 10 ) - 5;
	}
	
	public static void main(String[] args) {
		int[][] matrix = new int[301][301];
		
		int input = 3214;
		int bx = 0,
			by = 0,
			bs = 0,
			best = Integer.MIN_VALUE;
		
		
		for(int y = 1; y <= 300; y++) {
	        for(int x = 1; x <= 300; x++) {
	            int id = x + 10;
	            matrix[y][x] = calcPowerLevel(x, y, input) + matrix[y - 1][x] + matrix[y][x - 1] - matrix[y - 1][x - 1];
	        }
	    }

		
		for(int s = 1; s <= 300; s++) {
	        for(int y = s; y <= 300; y++) {
	            for(int x = s; x <= 300; x++) {
	                int total = matrix[y][x] - matrix[y - s][x] - matrix[y][x - s] + matrix[y - s][x - s];
	                if(total > best) {
	                    best = total;
	                    bx = x;
	                    by = y; 
	                    bs = s;
	                }
	            }
	        }
	    }
		
		int[] result = new int[3];
		result[0] = bx - bs + 1;
		result[1] = by - bs + 1;
		result[2] = bs;
		
		System.out.println( result[0] + "," + result[1] + "," + result[2]);
	}

	
}
