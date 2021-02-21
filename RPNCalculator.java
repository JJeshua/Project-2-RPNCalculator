import java.util.Scanner;

public class RPNCalculator 
{

	public static void main(String[] args) 
	{
		boolean running = true;
		Scanner scanner = new Scanner(System.in);
		String[] inputArr;
		
		while (running) 
		{
			System.out.print("Enter operation(s) seperated by a space (use h or ? for help): ");
			inputArr = scanner.nextLine().split(" ");
				
			// goes through each operation entered by the user and tries to execute it
			for (String operation : inputArr)
			{
				// checks if user inputed a number, and if so, adds it the stack inside the RPNFunctions class
				try 
				{
					double num = Double.parseDouble(operation);
					RPNFunctions.addToStack(num);
				// if user did not input a number, checks to see if it is a defined function
				} catch (NumberFormatException e) 
				{
					switch (operation) 
					{
					case "+":
						RPNFunctions.addition();
						break;
					case "*":
						RPNFunctions.multiply();
						break;
					case "-":
						RPNFunctions.subtract();
						break;
					case "/":
						RPNFunctions.divide();
						break;
					case "%":
						RPNFunctions.modulous();
						break;
					case "m":
						RPNFunctions.negate();
						break;
					case "r":
						RPNFunctions.exchange();
						break;
					case "d":
						RPNFunctions.duplicate();
						break;
					case "p":
						RPNFunctions.printTop();
						break;
					case "n":
						RPNFunctions.printRemoveTop();
						break;
					case "f":
						RPNFunctions.printAll();
						break;
					case "c":
						RPNFunctions.clear();
						break;
					case "q":
						System.out.println("Quitting");
						running = false;
						scanner.close();
						break;
					case "h":
						RPNFunctions.help();
						break;
					case "?":
						RPNFunctions.help();
						break;
					default:
						System.out.println("Invalid Operation\n");
						break;
					}
				}
			}
		}
	}
}