package a1;

import java.util.Scanner;
class Item{
	String name;
	double price;
	int quantity=0;
	Item(){
		
	}
	Item(String N, Double P){
		this.name = N;
		this.price = P;
	}
	Item( int Q, String N, Double P){
		this.name = N;
		this.price = P;
		this.quantity =Q;
	}
	String sale(int buyers){
		if(buyers== 0)
			return "No customers bought " + this.name;
		else
			return buyers + " customers bought " + this.quantity + " " + this.name;
	}
}

class Customer {
	String fName;
	String lName;

	Item[] list;
	Customer(){
		
	}
	
	Customer(String F, String L){
		this.fName= F;
		this.lName = L;
	}
	void List(int itemTot){
		this.list= new Item[itemTot];
	}
	double Total() {
		double total = 0;
		for(int i= 0; i< this.list.length; i++) {
			total = total + this.list[i].price * this.list[i].quantity;
		}
		return total; 
	}
	int shop(int itemNum, int itemQuant, String itemName, Item[] itemList ) {
		int boughtInd = 0;
		for(int i =0; i < itemList.length; i++) {
			if( itemName.contentEquals(itemList[i].name)) {
			 	this.list[itemNum]= new Item(itemQuant, itemName, itemList[i].price);
			 	boughtInd = i;
			}
		}
		return boughtInd;
	}
	String Receipt(int Case) {
		String receipt = "";
		switch (Case) {
		case 1:
			receipt = this.fName.charAt(0)+". " + this.lName + ": " + String.format("%.2f", this.Total());
		break;
		case 2:
			receipt = this.fName +" "+ this.lName+ " (" + String.format("%.2f", this.Total())+")";
		}
		return receipt;
	}
	
}  
public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int cusTot = scan.nextInt();
		Customer[] customers = new Customer[cusTot];
		for (int i = 0; i<cusTot; i++) {
			customers[i]= new Customer(scan.next(),scan.next());
			customers[i].List(scan.nextInt());
			for(int n= 0; n<customers[i].list.length; n++ ) {
				customers[i].list[n] = new Item(scan.nextInt(), scan.next(), scan.nextDouble());
				
			}
		}
		scan.close();
		for (int i = 0; i<cusTot; i++) {
		System.out.println (customers[i].Receipt(1));
		}
	}
}
