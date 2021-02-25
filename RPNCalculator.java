import java.util.Scanner;
import java.util.Stack;

public class RPNCalculator {

	public static void main(String[] args) {
		Stack<Double> numberStack = new Stack<>();
		Scanner scanner = new Scanner(System.in);
		boolean running = true;

		while (running) {
			System.out.print("Enter operation(s) seperated by a space (use h or ? for help): ");
			// goes through each operation entered by the user and tries to execute it
			for (String operation : scanner.nextLine().split(" ")) {
				// checks if user inputed a number, and if so, it is added to the stack
				try {
					RPNFunctions.addToStack(numberStack, Double.parseDouble(operation));
					// if user did not input a number, checks to see if it is a defined function
				} catch (NumberFormatException e) {
					switch (operation) {
					case "+":
						RPNFunctions.addition(numberStack);
						break;
					case "*":
						RPNFunctions.multiply(numberStack);
						break;
					case "-":
						RPNFunctions.subtract(numberStack);
						break;
					case "/":
						RPNFunctions.divide(numberStack);
						break;
					case "%":
						RPNFunctions.modulous(numberStack);
						break;
					case "m":
						RPNFunctions.negate(numberStack);
						break;
					case "r":
						RPNFunctions.exchange(numberStack);
						break;
					case "d":
						RPNFunctions.duplicate(numberStack);
						break;
					case "p":
						RPNFunctions.printTop(numberStack);
						break;
					case "n":
						RPNFunctions.printRemoveTop(numberStack);
						break;
					case "f":
						RPNFunctions.printAll(numberStack);
						break;
					case "c":
						RPNFunctions.clear(numberStack);
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