package Application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Entities.ImportedProduct;
import Entities.Product;
import Entities.UsedProduct;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		List<Product> list = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for(int i = 1; i<= n; i++) {
			
			System.out.println();
			System.out.println("Product #" + i + " data:");
			
			System.out.print("Common, used or imported (c/u/i)? ");
			char x = sc.next().charAt(0);
			
			while(x != 'c' && x != 'u' && x != 'i') {
				System.out.print("Oops, Invalid Option, type again (c/u/i):");
				x = sc.next().charAt(0);
			}
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			if(x == 'c') {
				list.add(new Product(name, price));
			}
			
			else if(x == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				LocalDate manufactureDate = LocalDate.parse(sc.next(), fmt1);
				list.add(new UsedProduct(name, price, manufactureDate));
			}
			
			else if(x == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));
			}
		}
		
		System.out.println();
		
		System.out.println("PRICE TAGS: ");
		
		for(Product prod : list) {
			System.out.println(prod.priceTag());
		}
		
		
		sc.close();
	}

}
