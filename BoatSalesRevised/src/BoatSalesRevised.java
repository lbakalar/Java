/*
 * this program calculates boat costs
 */

import java.text.NumberFormat;
import java.util.Scanner;

public class BoatSalesRevised {
	
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
	static boolean invalid = false;
	static boolean invalidQty = true;
	static boolean invalidBoatCost = true; 
	static boolean invalidPrepCost = true; 
	

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
		
		do {
		//prompt for boat type
		System.out.print("Enter boat type: ");
		iBoatType = myScanner.next();	
		
		
		switch(iBoatType.toUpperCase()) {
			case "P":
				oBoatType = "Pontoon";
				cMarkupPercent = .25;
				invalid = true;
				break;
			case "B":
				oBoatType = "Bass";
				cMarkupPercent = .33;
				invalid = true;
				break;
			case "S":
				oBoatType = "Ski";
				cMarkupPercent = .425;
				invalid = true;
				break;
			case "C":
				oBoatType = "Canoe";
				cMarkupPercent = .2;
				invalid = true;
				break;
				
			default: 
				System.out.println("Boat Type must be P, B, S, or C. Default is set to S. ");
				oBoatType = "Ski";
				cMarkupPercent = .425;
				invalid = false;
				break;
		}
		
		}while(invalid == false);
			
		
		do {
		//prompt for accessory type
		System.out.print("Enter accessory type: ");
		iAccessType = myScanner.next();
		
		switch(iAccessType) {
			case "1":
				oAccessType = "Electronics";
				cAccessCost = 5415.3;
				invalid = true;
				break;
			case "2":
				oAccessType = "Ski Package";
				cAccessCost = 3980;
				invalid = true;
				break;
			case "3":
				oAccessType = "Fishing Package";
				cAccessCost = 345.45;
				invalid = true;
				break;
			default: 
				System.out.println("Accessory Type must be 1, 2, or 3. Please re-enter. ");
				oAccessType = "Electronics";
				cAccessCost = 5415.3;
				invalid = false; 
				break;
		}		
		}while (invalid == false);
		
		//prompt and validate quantity
		do {
			try {
				System.out.print("Enter quantity: ");
				iQty = myScanner.next();
				cQty = Double.parseDouble(iQty);
				if (cQty < 1 || cQty > 25) {
					System.out.println("Quantity must be 1-25. Please re-enter. ");
					invalidQty = true;					
 				}
				
				else {
					invalidQty = false;
				}
			}
			catch (Exception e) { 
			System.out.println("Quantity must a number. Please re-enter. ");
			cQty = 1;
			}
			
		}while (invalidQty == true);
	 
	
		
		//prompt and validate boat cost
		do {
			try {
				System.out.print("Enter boat cost:");
				iCost = myScanner.next();
				cCost = Double.parseDouble(iCost);
				if (cCost < 2500 || cCost > 150000) {
					System.out.println("Boat cost must be between 2,500.00 – 150,000.00. Please re-enter. ");
					invalidBoatCost = true; 
		 		}
				else { 
					invalidBoatCost = false; 
				}
			}
			catch (Exception e) { 
			System.out.println("Price must be a number. Please re-enter. ");
			//cCost = 0;
			}
					
		}while (invalidBoatCost == true);
		
		//prompt and validate prep cost
		do {
			try {
				System.out.print("Enter prep cost:");
				iPrepCost = myScanner.next();
				cPrepCost = Double.parseDouble(iPrepCost);
				if (cPrepCost < 100 || cPrepCost > 9999.99) {
					System.out.println("Prep cost must be between 100.00 – 9999.99. Please re-enter. ");
					invalidPrepCost = true;				}
				
				else {
					invalidPrepCost = false;
				}
			}
			catch (Exception e) { 
			System.out.println("Prep cost must be between 100.00 – 9999.99. Please re-enter. ");
			invalidPrepCost = true;
			}
							
		}while (invalidPrepCost == true);		
				
	}
	
	public static void calcs() {
		//calculate 
		
		//move iQty to cQty
		cQty = Double.parseDouble(iQty);
		
		//move iCost to cCost		
		cCost = Double.parseDouble(iCost); 
		
				
		
		cMarkup = cMarkupPercent * cCost;		 
		
		cSubtotal = cCost + cAccessCost + cPrepCost + cMarkup; 
		
		cTax = cSubtotal * .06;
		
		cTotal = cSubtotal + cTax; 
		
		cGtTotal = cGtTotal + cTotal; 
		
		cGtSalesCtr = cGtSalesCtr + 1; 
			
	}
		
	public static void output() {
		//display boat type
		System.out.printf("%-25s%15s%20s\n" , "Boat Type: " , " " , oBoatType);
		
		//display accessory type
		System.out.printf("%-25s%15s%20s\n" , "Accessory Type: ", " ", oAccessType);		
		
		//display quantity
		oQty = nf.format(cQty);
		System.out.printf("%-25s%15s%20s\n" , "Quantity is: ", " ", oQty);
		
		//display boat cost
		oCost = nf.format(cCost);
		System.out.printf("%-25s%15s%20s\n" , "Boat Cost is: ", " ", oCost);
		
		//format display accessory cost
		oAccessCost = nf.format(cAccessCost);
		System.out.printf("%-25s%15s%20s\n" , "Boat Type: ", " ", oAccessCost);
		
		//display prep cost
		oPrepCost  = nf.format(cPrepCost);
		System.out.printf("%-25s%15s%20s\n" , "Prep Cost is: ", " ", oPrepCost);
		
		//format and display markup amount
		oMarkup = nf.format(cMarkup);
		System.out.printf("%-25s%15s%20s\n" , "Your markup amount is: ", " ", oMarkup);
		
		//format and display subtotal
		oSubtotal = nf.format(cSubtotal);
		System.out.printf("%-25s%15s%20s\n" , "Your subtotal is: ", " ", oSubtotal);
		
		//format and display tax
		oTax = nf.format(cTax);
		System.out.printf("%-25s%15s%20s\n" , "Your tax is: ", " ", oTax);
		
		//format and display total
		oTotal = nf.format(cTotal);
		System.out.printf("%-25s%15s%20s\n" , "Your total is: ", " ", oTotal);
		
		
	 System.out.println("Do you want to continue? Y or N");
	 
	 Again = myScanner.next().toUpperCase().charAt(0); 
}
	 
	 public static void Gtoutput() {
		//format and display grand total sales ctr
		
		System.out.println("Your grand total sales counter is: " + cGtSalesCtr);
		 
		//format and display grand total sales
		oGtTotal = nf.format(cGtTotal);
		System.out.println("Your Grand Total is: " + oGtTotal);			
	 }
	}
	
