//Santiago Fleiderman
//CSc 2010, Principles of Computer Science
//Spring 2014
//Assignment 11; Grade Report
//Modify the grade report program below that is posted to Handle Exceptions
//demonstrating the use of the try and catch block
//04-25-2014

// Asks user to enter grade and returns a message.
//import jpb.*;

// You have to extend the Exception class to use it
@SuppressWarnings("serial")
public class GradeReport extends Exception {
	// To throw an exception you must use the following throws clause
	public static void main(String[] args) throws Exception {

		//Variables, the assinment said to use yes boolean continues works better
		boolean continues = true;
		String userInput = "";
		int tries = 1;
		int category = 0;
		// while continues is true
		while (continues) {                                        
			//Prompt the user to enter their grade
			SimpleIO.prompt("Enter your grade (0 - 100): ");
			userInput = SimpleIO.readLine();
			int grade = Integer.parseInt(userInput);

			// Try and catch block
			try
			{
				// Will continues if tries are more than 3
				while (tries < 3)
				{
					//if the input isn't an integer between 0 and 100,
					//prompt the user to re-enter
					if ((grade < 0) || (grade >100)) {
						System.out.println ("Error: You must enter an integer between 0 and 100");
						userInput = SimpleIO.readLine();
						grade = Integer.parseInt(userInput);
						// increment tries
						tries++;
					}
					// If given right number procceed with loop
					else {
						// set tries to greater than 3 to break out of loop
						tries = 4;
						grade = Integer.parseInt(userInput);
						//divide grade by 10
						category = grade / 10;
						//print out a message for scores.
						switch (category) {
						case 10: System.out.println ("Perfect Score!");
						break;
						case 9: System.out.println ("Well above Average. Excellent!");
						break;
						case 8: System.out.println ("Above Average, Nice Job!");
						break;
						case 7: System.out.println ("Average.");
						break;
						case 6: System.out.println ("Below Average. See Instructor.");
						break;
						default: System.out.println ("You are not comprehending i see.");
						break;
						}
						// Ask whether to continue
						throw new Exception("Would you like to continue? Yes or No?");
					}
				}
				//Ask user since tries used in greater than 3 if he would like to continue
				if (tries >= 3)
				{
					throw new Exception("Would you like to continue? Yes or No?");
				}                                             
			}
			// Here, you catch the thrown exception message and display
			catch (Exception e)         {
				// display message
				System.out.println(e.getMessage());
				// read answer to message continue yes or no
				userInput = SimpleIO.readLine();
				boolean isTrue = true;
				// loop through the yes no answer until they say no
				while (isTrue) {
					// if no then exit
					if (userInput.equalsIgnoreCase("no")) {
						System.out.println("Goodbye!");
						System.exit(-1);
					}
					// if yes set isTrue to false to exit loop
					// reset tries to 1 again
					else if (userInput.equalsIgnoreCase("yes")) {
						isTrue = false;
						tries = 1;
					}
					// if they don't spell out 'yes' or 'no' it will continue
					// inside the loop
					else {
						System.out.println("You must spell out the entire word 'Yes' or 'No'...");
						userInput = SimpleIO.readLine();
					}
				}                                                             
			}                                             
		}                             
	}
}