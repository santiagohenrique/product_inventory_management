package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		String sourceFileStr = "./src/products.csv";
		File sourceFile = new File(sourceFileStr);
		String sourceFolderStr = sourceFile.getParent();

		List<Product> listProducts = new ArrayList<>();

		try {
			System.out.print("Enter the number of products: ");
			int numberOfProducts = sc.nextInt();

			for (int i = 0; i < numberOfProducts; i++) {
				sc.nextLine();
				System.out.println("-Product #" + (i + 1) + "-");
				System.out.print("Name: ");
				String name = sc.nextLine();
				System.out.print("Price: ");
				Double price = sc.nextDouble();
				System.out.print("Quantity: ");
				Integer quantity = sc.nextInt();

				listProducts.add(new Product(name, price, quantity));
			}
		} catch (InputMismatchException e) {
			System.out.println("ERROR: invalid data");
		} finally {
			new File(sourceFolderStr + "\\out").mkdir();
			String targetFileStr = sourceFolderStr + "\\out\\summary.csv";
			File targetFile = new File(targetFileStr);
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(sourceFile))) {
				for (Product product : listProducts) {
					bw.write(product.toString());
					bw.newLine();
				}
			} catch (IOException e) {
				System.out.println("ERROR: " + e.getMessage());
			}

			try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFile))) {
				for (Product product : listProducts) {
					bw.write(product.getName() + ", " + String.format("%.2f", product.totalPrice()));
					bw.newLine();
				}
			} catch (IOException e) {
				System.out.println("ERROR: " + e.getMessage());
			}
			sc.close();
		}

	}
}
