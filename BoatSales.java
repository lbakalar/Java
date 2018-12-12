import java.text.NumberFormat;
import java.util.Scanner;

public class BoatSales {
	
	//declare variables
	static String iBoatType;
	static String iAccessType;
	static String iQty;
	static double cQty; 
	static String oQty; 
	static String iCost;
	static double cCost;
	static String oCost; 
	static String iPrepCost;
	static double cPrepCost; 
	static String oPrepCost; 
	static String oBoatType;
	static String oAccessType;
	static String oMarkup;
	static String oSubtotal; 
	static String oTax;
	static String oTotal;
	static String oAccessCost;
	static double cMarkupPercent;
	static double cAccessCost;
	static double cMarkup;
	static double cSubtotal;
	static double cTax;
	static double cTotal;	
	static double cGtTotal;
	static String oGtTotal;
	static double cGtSalesCtr; 
	static String oGtSalesCtr;
	static char Again = 'Y'; 
	static Scanner myScanner; //input device
	static NumberFormat nf; //used to format currency
	

	public static void main(String[] args) {
		
		//call init()
		init();
		
		while (Again == 'Y') {
		
		//call input
		input();
			
		//call calcs()
		calcs();
		
		//call output
		output();
		
		}
		
		if (Again == 'N') { 
			Gtoutput();
	}

	}
	
	public static void init() {
		//set scanner to the console
		myScanner = new Scanner(System.in);
		//change delimiter from blank space to enter key
		//allow spaces in strings
		myScanner.useDelimiter(System.getProperty("line.separator"));
						
		//set formatter to use us currency format
		nf = NumberFormat.getCurrencyInstance(java.util.Locale.US);
		
	}
	
	public static void input() {		
						
		//prompt for boat type
		System.out.print("Enter boat type: ");
		iBoatType = myScanner.next();			
		
		switch(iBoatType.toUpperCase()) {
			case "P":
				oBoatType = "Pontoon";
				cMarkupPercent = .25;
				break;
			case "B":
				oBoatType = "Bass";
				cMarkupPercent = .33;
				break;
			case "S":
				oBoatType = "Ski";
				cMarkupPercent = .425;
				break;
			case "C":
				oBoatType = "Canoe";
				cMarkupPercent = .2;
				break;
				
			default: 
				System.out.println("Boat Type must be P, B, S, or C. Default is set to S. ");
				oBoatType = "Ski";
				cMarkupPercent = .425;
				break;
		}
		
				
	
				
		//prompt for accessory type
		System.out.print("Enter accessory type: ");
		iAccessType = myScanner.next();
		
		switch(iAccessType) {
			case "1":
				oAccessType = "Electronics";
				cAccessCost = 5415.3;
				break;
			case "2":
				oAccessType = "Ski Package";
				cAccessCost = 3980;
				break;
			case "3":
				oAccessType = "Fishing Package";
				cAccessCost = 345.45;
				break;
			default: 
				System.out.println("Accessory Type must be 1, 2, or 3. Default is set to 1. ");
				oAccessType = "Electronics";
				cAccessCost = 5415.3;
				break;
		}		
		
		
			
		try {
			
		//prompt for quantity
		System.out.print("Enter quantity: ");
		iQty = myScanner.next();
		cQty = Double.parseDouble(iQty);
		
		if (cQty < 1 || cQty > 25) {
		System.out.println("Quantity must be 1-25. Default is set to 1. ");
		cQty = 1;
		}
		}
		
		catch (Exception e) { 
		System.out.println("Quantity must a number. Default is set to 1. ");
		cQty = 1;
		}
	 
		
		try {
		//prompt for boat cost
		System.out.print("Enter boat cost: ");
		iCost = myScanner.next();
		cCost = Double.parseDouble(iCost);
		
	
		if (cCost < 2500 || cCost > 150000) {
		System.out.println("Boat cost must be between 2,500.00 – 150,000.00. Default is set to 25,000. ");
		cCost = 2500; }
		}
		catch (Exception e) {
		System.out.println("Price must be a number. Default is set to 0. ");
		cCost = 0;
		}
		
		try {
		//prompt for prep cost
		System.out.print("Enter Prep cost: ");
		iPrepCost = myScanner.next();
		cPrepCost = Double.parseDouble(iPrepCost);
		
		if (cPrepCost < 100 || cPrepCost > 9999.99) {
		System.out.println("Prep cost must be between 100.00 – 9999.99. Default is set to 5,000.");
		cPrepCost = 5000;
		}
		}
		
		catch (Exception e) {
		System.out.println("Price must be a number. Default is set to 0. ");
		cCost = 0;
			
		}
		
}
	
	public static void calcs() {
		//calculate 
		
		//move iQty to cQty
		cQty = Double.parseDouble(iQty);
		
		//move iCost to cCost		
		cCost = Double.parseDouble(iCost); 
		
		//move iPrepCost to cPrepCost
		cPrepCost = Double.parseDouble(iPrepCost);		
		
		cMarkup = cMarkupPercent * cCost;		 
		
		cSubtotal = cCost + cAccessCost + cPrepCost + cMarkup; 
		
		cTax = cSubtotal * .06;
		
		cTotal = cSubtotal + cTax; 
		
		cGtTotal = cGtTotal + cTotal; 
			
	}
		
	public static void output() {
		//display boat type
		System.out.println("Boat Type: " + oBoatType);
		
		//display accessory type
		System.out.println("Accessory Type: " + oAccessType);		
		
		//display quantity
		oQty = nf.format(cQty);
		System.out.println("Quantity is: " + oQty);
		
		//display boat cost
		oCost = nf.format(cCost);
		System.out.println("Boat Cost is: " + oCost);
		
		//format display accessory cost
		oAccessCost = nf.format(cAccessCost);
		System.out.println("Boat Type: " + oAccessCost);
		
		//display prep cost
		oPrepCost  = nf.format(cPrepCost);
		System.out.println("Prep Cost is: " + oPrepCost);
		
		//format and display markup amount
		oMarkup = nf.format(cMarkup);
		System.out.println("Your markup amount is: " + oMarkup);
		
		//format and display subtotal
		oSubtotal = nf.format(cSubtotal);
		System.out.println("Your subtotal is: " + oSubtotal);
		
		//format and display tax
		oTax = nf.format(cTax);
		System.out.println("Your tax is: " + oTax);
		
		//format and display total
		oTotal = nf.format(cTotal);
		System.out.println("Your total is: " + oTotal);
		
		
	 System.out.println("Do you want to continue? Y or N");
	 
	 Again = myScanner.next().toUpperCase().charAt(0); 
}
	 
	 public static void Gtoutput() {
		 //format and display grand total sales ctr
		 oGtSalesCtr = nf.format(cGtSalesCtr);
		System.out.println("Your grand total sales counter is: " + oGtSalesCtr);
		 
		 //format and display grand total sales
		oGtTotal = nf.format(cGtTotal);
		System.out.println("Your Grand Total is: " + oGtTotal);			
	 }
	}
	
