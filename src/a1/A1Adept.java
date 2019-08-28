package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		Item[] sales = new Item[scan.nextInt()];
	
		for(int i=0; i < sales.length; i++) {
			sales[i]= new Item(scan.next(), scan.nextDouble() );
		}
		Customer[] customers = new Customer[scan.nextInt()];
		for(int i =0; i< customers.length; i++) {
			customers[i]= new Customer(scan.next(),scan.next());
			customers[i].List(scan.nextInt());
			for( int n=0; n< customers[i].list.length; n++) {
				int quantity = scan.nextInt();
				customers[i].shop(n, quantity, scan.next(), sales );
					
			
			}
		}
		scan.close();
		int bigCusInd = 0;
		int smlCusInd = 0;
		double totalSale = 0;
		for(int i =0; i < customers.length; i++) {
			totalSale = customers[i].Total() + totalSale;
			if( i>0 && customers[i].Total()>customers[i-1].Total()) {
				bigCusInd = i;
			}
			if( i>0 && customers[i].Total()<customers[i-1].Total()) {
				smlCusInd = i;
			}
			
		}
		System.out.println("Biggest: "+customers[bigCusInd].Receipt(2));
		System.out.println("Biggest: "+customers[smlCusInd].Receipt(2));
		System.out.println("Average: "+String.format("%.2f", totalSale/customers.length));


		
	}
}
