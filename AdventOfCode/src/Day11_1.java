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

public class Day11_1 {
	public static int calcPowerLevel(int x, int y,int gridserial) {
		return (( (x*x*y + 20*x*y + x*gridserial + 100*y + 10*gridserial)/100 ) % 10 ) - 5;
	}
	
	public static void main(String[] args) {
		int[][] matrix = new int[300][300];
		int[][] maxmatrix = new int[297][297];
		
		int input = 3214;
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\mikol\\eclipse-workspace\\AdventOfCode\\output.txt"));
			
			for (int i = 0; i < 300; i++) {
				for (int j = 0; j < 300; j++) {
					matrix[j][i] = calcPowerLevel(i, j, input);
					writer.write(matrix[j][i] + "\t"); 
				}
				writer.newLine();
			}
			
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
		
		System.out.println(calcPowerLevel(122,79,57));
		System.out.println(calcPowerLevel(217,196,39));
		System.out.println(calcPowerLevel(101,153,71));
		
		for (int i = 0; i < 300; i++) {
			for (int j = 0; j < 300; j++) {
				matrix[i][j] = calcPowerLevel(i, j, input);
//				System.out.println(i + "\t" + j + "\t" + matrix[i][j]);
			}
		}
		
		int max = -100000000;
		String maxcoord = "";
		
		for (int i = 0; i < 297; i++) {
			for (int j = 0; j < 297; j++) {
				maxmatrix[i][j] = matrix[i][j] + matrix[i][j+1] + matrix[i][j+2] +
								  matrix[i+1][j] + matrix[i+1][j+1] + matrix[i+1][j+2] +
								  matrix[i+2][j] + matrix[i+2][j+1] + matrix[i+2][j+2];
				if (maxmatrix[i][j] > max) {
					max = maxmatrix[i][j];
					maxcoord = String.valueOf(i) + ", " + String.valueOf(j);
				}
			}
		}
		
		System.out.println(maxcoord);
	}

	
}
