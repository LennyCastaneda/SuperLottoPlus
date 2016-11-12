import java.util.Scanner;


/* 
@author Lenny Castaneda - Assignment 6

*/

// Create a class called SuperLottoPlus.java
public class SuperLottoPlus {


	public static void main(String[] args)
	{
	
		Scanner userInput = new Scanner(System.in);
		
			
		// In the main method ask the user how many lotto tickets they want. 
		System.out.print("How many Super Lotto tickets do you want? \n");
		
		int lottoTickets = userInput.nextInt();

		// If the user enters N then, using a for loop, loop N number of times. [1 pt]
		for (int i = 0; i < lottoTickets; i++)
				{
					// In each loop iteration, call the printTicket() method, passing a call to the method
					// Since it is a void method and returns nothing, there is no need to assign it to a variable.
					printTicket(generateSuperLottoNumbers());
				}
	
		
		System.out.println("\n******This is the EXTRA CREDIT method with no duplicates within first five random numbers******\n");
		
		for (int i = 0; i < lottoTickets; i++)
		{
			// In each loop iteration, call the printTicket() method, passing a call to the method
			// Since it is a void method and returns nothing, there is no need to assign it to a variable.
			printTicket(generateSuperLottoNoDupes());
		}

		userInput.close();
	}

	
	/*
	 * generateSuperLottoNumbers() -  Method 
	 * 
	 */
	
	// Create a static method called generateSuperLottoNumbers() that returns an array of 6 random SuperLotto lottery numbers.
	// Must have correct method signature, and return the entire array of lotto numbers. [1 pt]
	public static int[] generateSuperLottoNumbers() 
	{
		// create an array that allocates only 6 integer slots.
		int[] ticketNumbers = new int[6];
		
		//generateSuperLottoNumbers() as an argument [1 pts]
		// Hint: numbers[i] = (int) (10 * Math.random()) + 1; // will assign your array element to a random number from 1 to 10
		// The first 5 numbers  must be from the range 1 to 47 [1 pt]
		//we want to run the iteration 5 times so we use for loop knowing how many iterations are needed.
		for (int i = 0; i < 5; i++) 
		{
			ticketNumbers[i] = (int) (47 * Math.random()) + 1;   // random method in the Math class will only give number between 0 and 1 not including 1 (0-.99) 	
																							// so we add plus 1 to avoid the error we have to account for 0 and 47.
		}
		
		// The 6th number (the MEGA) must be from 1 to 27. [1 pt]
		ticketNumbers[5] = (int) (27 * Math.random()) + 1;

		return ticketNumbers;
	}

		
	/*
	 * 
	 * printTicket() - Method
	 *
	 */
	
		// Create a static method called printTicket() that takes an integer array as an parameter
		// Must have correct method signatures [1 pt]
		// Since we are not returning anything in this method, we use "void" in the method definition statement.
		public static void printTicket(int[] listOfNumbers) 
		{
				// Display the data in the format: 47 22 25 4 13 (MEGA: 14) 
				System.out.println(listOfNumbers[0] + " "+ listOfNumbers[1] + " " +listOfNumbers[2] + " "+ 
						listOfNumbers[3] + " "+ listOfNumbers[4] + " (MEGA:  " + listOfNumbers[5] + ")" );	
		}

		
		/*
		 * 
		 * generateSuperLottoNoDupes() - Method
		 *
		 */
		
		
		// Extra Credit: Create another method called generateSuperLottoNoDupes() which does the same thing as generateSuperLottoNumbers(), 
		// Nothing is needed from the user so no parameters/arguments are needed from the user.
		public static int[] generateSuperLottoNoDupes()
		{
			// create an array that allocates only 6 integer slots.
			int[] ticketNumbers = new int[6];
			
			//generateSuperLottoNumbers() as an argument [1 pts]
			// Hint: numbers[i] = (int) (10 * Math.random()) + 1; // will assign your array element to a random number from 1 to 10
			// The first 5 numbers  must be from the range 1 to 47 [1 pt]
			//we want to run the iteration 5 times so we use for loop knowing how many iterations are needed.
			for (int i = 0; i < 5; i++) 
			{
				ticketNumbers[i] = (int) (47 * Math.random()) + 1;   // random method in the Math class will only give number between 0 and 1 not including 1 (0-.99) 	
																								// so we add plus 1 to avoid the error we have to account for 0 and 47.
				for (int j = 0; j < i; j++)												// After first iteration of number 0-47, check if the current ticketNumbers is a duplicate of the preceding iterations.
				{
					if (ticketNumbers[i] == ticketNumbers[j])  		
						i--;																	// If it is a duplicate then decrease the tickerNumber index by one and rerun the fo loop go generate a new random number.			
				}
			}
			
			// The 6th number (the MEGA) must be from 1 to 27. [1 pt]
			ticketNumbers[5] = (int) (27 * Math.random()) + 1;

			return ticketNumbers;
		}
}