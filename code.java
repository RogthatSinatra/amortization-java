// amortization-java
//This is a Console Loan Amortization Schedule for java.
//includes use of switches ifs nested if and loops
import java.io.*; 
public class UsefulProgramme {

		 public static void main(String[] args)throws IOException { 
		  BufferedReader input = new BufferedReader(new InputStreamReader(System.in));


			        // Prompt the user for loan amount, number of years and annual interest rate

			        System.out.print("Loan Amount: ");
			        String Looan=input.readLine();
			          double loanAmount = Double.valueOf(Looan);

			        System.out.print("Number of Years: ");
			        String numyears=input.readLine();
			        int numYears = Integer.valueOf(numyears);

			        System.out.print("Annual Interest Rate (in %): ");
			        String annintrest=input.readLine();
			          double annualInterestRate = Double.valueOf(annintrest);
			        
			      if (annualInterestRate>1){
			    	  if (annualInterestRate<=25){
			            	System.out.println("This is a moderate Interest Rate");
			                }
			                else if (annualInterestRate>100 ){
		    				System.out.println("Your advised not to accept this loan has bigger Total pay");
		                    }
			    			else if (annualInterestRate>=26 && annualInterestRate>100 ){
			    				System.out.println("This is a Normal Interest Rate");
			                }
			    			else if (annualInterestRate<=15 && annualInterestRate>=6 ){
			    				System.out.println("This is a Normal Interest Rate");
			    			}
			    			else if(annualInterestRate<=5 && annualInterestRate<1){
			    				System.out.println("This is a low Interest Rate");
			    			}
			         else
			            	System.out.println("There is no Interest Charged");
			           
			      }
			    
                    switch(numYears){
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    	System.out.println("Short-term Loan ");
                    	break;
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    	System.out.println("Long-term Loan ");
                    	break;
                    case 10:
                    	System.out.println("Long-term Loan will be completed in a Decade");
                    	break;
                    	default:
                    		System.out.println("Long-term Loan will be completed in:"+numYears*12+" "+"months");
                    }
                    	  
                    	
                      System.out.println();  // Insert a new line

			        // Print the amortization schedule
			        
                     printAmortizationSchedule(loanAmount, annualInterestRate, numYears);
			 
			    }

			    /**
			     * Prints amortization schedule for all months.
			     */
			    public static void printAmortizationSchedule(double principal, double annualInterestRate,
			                                                 int numYears) {
			        double interestPaid, principalPaid, newBalance;
			        double monthlyInterestRate, monthlyPayment;
			        int month=1;
			        int numMonths = numYears * 12;
                    
			        // Output monthly payment and total payment
			        monthlyInterestRate = annualInterestRate / 12;
			        monthlyPayment      = monthlyPayment(principal, monthlyInterestRate, numYears);
			        System.out.format("Monthly Payment: %8.2f%n", monthlyPayment);
			       int totalpay=(int)(monthlyPayment * numYears * 12);
			        System.out.printf("Total Payment:  "+totalpay);
			     

			        // Print the table header
			        printTableHeader();

			        while ( month<= numMonths) {
			            // Compute amount paid and new balance for each payment period
			            interestPaid  = principal      * (monthlyInterestRate / 100);
			            principalPaid = monthlyPayment - interestPaid;
			            newBalance    = principal      - principalPaid;

			            // Output the data item
			            printScheduleItem(month, interestPaid, principalPaid, newBalance);

			            // Update the balance
			            principal = newBalance;
			            month++;
			        }
			    }
			 
			    static double monthlyPayment(double loanAmount, double monthlyInterestRate, int numberOfYears) {
			        monthlyInterestRate /= 100;  // e.g. 5% => 0.05
			        return loanAmount * monthlyInterestRate /
			                ( 1 - 1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12) );
			    }

			
			  // Prints a table data of the amortization schedule as a table row.
			   
			    private static void printScheduleItem(int month, double interestPaid,
			                                          double principalPaid, double newBalance) {
			        System.out.format("%8d%10.2f%10.2f%12.2f\n",
			            month, interestPaid, principalPaid, newBalance);
			    }

			   // Prints the table header for the amortization schedule.
			    
			    private static void printTableHeader() {
			        System.out.println("\nAmortization schedule");
			        for(int i = 0; i < 40; i++) {  // Draw a line
			            System.out.print("-");
			        }
			        System.out.format("\n%8s%10s%10s%12s\n",
			            "Payment#", "Interest", "Principal", "Balance");
			        System.out.format("%8s%10s%10s%12s\n\n",
			            "", "paid", "paid", "");   	
			    }
}		
	
