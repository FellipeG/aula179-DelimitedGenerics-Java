package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Product;
import model.services.CalculationService;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		try {
			List<Product> list = new ArrayList<>();
			System.out.println("Enter the path of the file:");
			String path = sc.nextLine();
			try(BufferedReader bf = new BufferedReader(new FileReader(path))){
				String line = bf.readLine();
				while (line != null) {
					String[] vect = line.split(",");
					list.add(new Product(vect[0], Double.parseDouble(vect[1])));
					line = bf.readLine();
				}
				
				
			}
			catch(IOException e) {
				System.out.println("Error: " + e.getMessage());
			}
			
			Product max = CalculationService.max(list);
			
			System.out.println();
			System.out.println("Most expensive:");
			System.out.println(max);
		}
		catch(IllegalStateException e) {
			System.out.println("Illegal State Exception Error: " + e.getMessage());
		}
		finally {
			sc.close();
		}
	}

}
