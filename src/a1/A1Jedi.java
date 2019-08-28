package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		Item[] sales = new Item[scan.nextInt()];
		int[] buyers = new int[sales.length];
		for (int i = 0; i < sales.length; i++) {
			sales[i] = new Item(scan.next(), scan.nextDouble());
		}
		Customer[] customers = new Customer[scan.nextInt()];
		for (int i = 0; i < customers.length; i++) {
			customers[i] = new Customer(scan.next(), scan.next());
			customers[i].List(scan.nextInt());
			for (int n = 0; n < customers[i].list.length; n++) {
				int quantity = scan.nextInt();
				int pHolder = customers[i].shop(n, quantity, scan.next(), sales);
				sales[pHolder].quantity += quantity;
			}
		}
		for (int n = 0 ; n<customers.length; n++){
			 for (int i = 0; i < buyers.length; i++){
			buyers[i]+=customers[n].onList(sales[i]);
		}
		}
		scan.close();

		for (int i = 0; i < sales.length; i++) {
			System.out.println(sales[i].sale(buyers[i]));
		}
	}
}
