import java.util.Stack;

public class RPNFunctions {
	private static double topItem;
	private static double secondItem;
	private static String[] options = new String[] { "(any number) Enter any number to add to the stack",
			"(+) add the top two items", "(*) multiply the top two items",
			"(-) subtract the top item from the next item", "(/) integer divide the second item by the top item",
			"(%) find the integer remainder when dividing the second item by the top item",
			"(m) unary minus -- negate the top item", "(r) exchange the top two items",
			"(d) duplicate top item on the stack ", "(p) print the top item ", "(n) print and remove the top item ",
			"(f) print all the contents of the stack (leaving it intact) ", "(c) clear the stack ", "(q) quit ",
			"(h or ?) help " };

	public static void addToStack(Stack<Double> numbers, double number) {
		numbers.push(number);
	}
	
	public static void addition(Stack<Double> numbers) {
		if (numbers.size() >= 2) {
			topItem = numbers.pop();
			secondItem = numbers.pop();
			numbers.push(topItem + secondItem);
		} else {
			System.out.println("(ERROR) - Not Enough Items in Stack\n\n");
		}
	}

	public static void multiply(Stack<Double> numbers) {
		if (numbers.size() >= 2) {
			topItem = numbers.pop();
			secondItem = numbers.pop();
			numbers.push(topItem * secondItem);
		} else {
			System.out.println("(ERROR) - Not Enough Items in Stack\n\n");
		}
	}

	public static void subtract(Stack<Double> numbers) {
		if (numbers.size() >= 2) {
			topItem = numbers.pop();
			secondItem = numbers.pop();
			numbers.push(topItem - secondItem);
		} else {
			System.out.println("(ERROR) - Not Enough Items in Stack\n\n");
		}
	}

	public static void divide(Stack<Double> numbers) {
		if (numbers.size() >= 2) {
			topItem = numbers.pop();
			secondItem = numbers.pop();
			numbers.push(secondItem / topItem);
		} else {
			System.out.println("(ERROR) - Not Enough Items in Stack\n\n");
		}
	}

	public static void modulous(Stack<Double> numbers) {
		if (numbers.size() >= 2) {
			topItem = numbers.pop();
			secondItem = numbers.pop();
			numbers.push(secondItem % topItem);
		} else {
			System.out.println("(ERROR) - Not Enough Items in Stack\n\n");
		}
	}

	public static void negate(Stack<Double> numbers) {
		if (numbers.size() >= 1) {
			topItem = numbers.pop();
			numbers.push(topItem * -1);
		} else {
			System.out.println("(ERROR) - Not Enough Items in Stack\n\n");
		}
	}

	public static void exchange(Stack<Double> numbers) {
		if (numbers.size() >= 2) {
			topItem = numbers.pop();
			secondItem = numbers.pop();
			numbers.push(topItem);
			numbers.push(secondItem);
		} else {
			System.out.println("(ERROR) - Not Enough Items in Stack\n\n");
		}
	}

	public static void duplicate(Stack<Double> numbers) {
		if (numbers.size() >= 1) {
			topItem = numbers.lastElement();
			numbers.push(topItem);
		} else {
			System.out.println("(ERROR) - Not Enough Items in Stack\n\n");
		}
	}

	public static void printTop(Stack<Double> numbers) {
		if (numbers.size() >= 1) {
			System.out.printf("\n(Top)%d\n", numbers.lastElement());
		} else {
			System.out.println("(ERROR) - Not Enough Items in Stack\n\n");
		}
	}

	public static void printRemoveTop(Stack<Double> numbers) {
		if (numbers.size() >= 1) {
			System.out.printf("\n%f\n\n", numbers.pop());
		} else {
			System.out.println("(ERROR) - Not Enough Items in Stack\n\n");
		}
	}

	public static void printAll(Stack<Double> numbers) {
		if (numbers.size() >= 1) {
			System.out.println("\n(TOP)");
			for (int i = numbers.size() - 1; i > -1; i--) {
				System.out.println(numbers.elementAt(i));
			}
			System.out.println();
		} else {
			System.out.println("(ERROR) - Not Enough Items in Stack\n\n");
		}		
	}

	public static void clear(Stack<Double> numbers) {
		numbers.clear();
		System.out.println("Cleared Stack");
		System.out.println();
	}

	public static void help() {
		System.out.println();
		for (String option : options) {
			System.out.println(option);
		}
		System.out.println();
	}
}