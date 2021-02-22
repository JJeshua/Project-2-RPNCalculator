import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import java.util.Stack;

/* + add the top two items
 * * multiply the top two items
 * - subtract the top item from the next item
 * / integer divide the second item by the top item 
 * % find the integer remainder when dividing the second item by the top item 
 * m unary minus -- negate the top item
 * r exchange the top two items 
 * d duplicate top item on stack 
 * p print the top item 
 * n print and remove the top item 
 * f print all the contents of the stack (leaving it intact) 
 * c clear the stack 
 * q quit 
 * h (or ?) print a help message 
 */

public class RPNFunctions 
{
	private static double topItem;
	private static double secondItem;
	private static String[] options = new String[] 
			{"(any number) Enter any number to add to the stack",
			"(+) add the top two items",
			"(*) multiply the top two items",
			"(-) subtract the top item from the next item",
			"(/) integer divide the second item by the top item",
			"(%) find the integer remainder when dividing the second item by the top item",
			"(m) unary minus -- negate the top item",
			"(r) exchange the top two items",
			"(d) duplicate top item on the stack ",
			"(p) print the top item ",
			"(n) print and remove the top item ",
			"(f) print all the contents of the stack (leaving it intact) ",
			"(c) clear the stack ",
			"(q) quit ",
			"(h or ?) help "
			};
	
	
	public static void addToStack(Stack<Double> numbers, double number)
	{
		numbers.push(number);
	}
	
	// clears topItem and secondItem variable to handle bugs when the Stack size is <2
	public static void clearSelected()
	{
		topItem = 0.0;
		secondItem = 0.0;
	}
	
	public static void addition(Stack<Double> numbers)
	{
		clearSelected();
		try 
		{
			topItem = numbers.pop();
			secondItem = numbers.pop();
			numbers.push(secondItem + topItem);
		} catch (EmptyStackException e) {
			System.out.println("(ERROR) - Not Enough Items in Stack\n\n");
			if (topItem != 0.0) numbers.push(topItem);
		}
	}
	
	public static void multiply(Stack<Double> numbers)
	{
		clearSelected();
		try 
		{
			topItem = numbers.pop();
			secondItem = numbers.pop();
			numbers.push(secondItem * topItem);
		} catch (EmptyStackException e) {
			System.out.println("(ERROR) - Not Enough Items in Stack\n\n");
			if (topItem != 0.0) numbers.push(topItem);
		}
	}
	
	public static void subtract(Stack<Double> numbers)
	{
		clearSelected();
		try 
		{
			topItem = numbers.pop();
			secondItem = numbers.pop();
			numbers.push(topItem - secondItem);
		} catch (EmptyStackException e) {
			System.out.println("(ERROR) - Not Enough Items in Stack\n\n");
			if (topItem != 0.0) numbers.push(topItem);
		}
		
	}
	
	public static void divide(Stack<Double> numbers)
	{
		clearSelected();
		try 
		{
			topItem = numbers.pop();
			secondItem = numbers.pop();
			numbers.push(secondItem / topItem);
		} catch (EmptyStackException e) {
			System.out.println("(ERROR) - Not Enough Items in Stack\n\n");
			if (topItem != 0.0) numbers.push(topItem);
		}
		
	}
	
	public static void modulous(Stack<Double> numbers)
	{
		clearSelected();
		try 
		{
			topItem = numbers.pop();
			secondItem = numbers.pop();
			numbers.push(secondItem % topItem);
		} catch (EmptyStackException e) {
			System.out.println("(ERROR) - Not Enough Items in Stack\n\n");
			if (topItem != 0.0) numbers.push(topItem);
		}
		
	}
	
	public static void negate(Stack<Double> numbers) 
	{
		clearSelected();
		try 
		{
			topItem = numbers.pop();
			numbers.push(topItem * -1);
		} catch (EmptyStackException e) {
			System.out.println("(ERROR) - Not Enough Items in Stack\n\n");
		}
	}
	
	public static void exchange(Stack<Double> numbers) 
	{
		clearSelected();
		try 
		{
			topItem = numbers.pop();
			secondItem = numbers.pop();
			numbers.push(topItem);
			numbers.push(secondItem);
		} catch (EmptyStackException e) {
			System.out.println("(ERROR) - Not Enough Items in Stack\n\n");
			if (topItem != 0.0) numbers.push(topItem);
		}
	}
	
	public static void duplicate(Stack<Double> numbers) 
	{
		clearSelected();
		try 
		{
			topItem = numbers.lastElement();
			numbers.push(topItem);
		} catch (Exception e) {
			System.out.println("(ERROR) - Not Enough Items in Stack\n\n");
		}
		
	}
	
	public static void printTop(Stack<Double> numbers) 
	{
		clearSelected();
		try 
		{
			System.out.printf("\n%d\n", numbers.lastElement());
		} catch (NoSuchElementException e) {
			System.out.println("(ERROR) - Not Enough Items in Stack\n\n");
		}
		
	}
	
	public static void printRemoveTop(Stack<Double> numbers) 
	{
		clearSelected();
		try 
		{
			System.out.printf("\n%f\n", numbers.pop());
		} catch (EmptyStackException e) {
			System.out.println("(ERROR) - Not Enough Items in Stack\n\n");
		}
		
	}
	
	public static void printAll(Stack<Double> numbers) 
	{
		clearSelected();
		
		System.out.println("\n(TOP)");
		for (int i=numbers.size()-1; i>-1; i--)
		{
			System.out.println(numbers.elementAt(i));
		}
		System.out.println();
	}
	
	public static void clear(Stack<Double> numbers) 
	{
		numbers.clear();
	}
	
	public static void help()
	{
		System.out.println();
		for (String option : options)
		{
			System.out.println(option);
		}
		System.out.println();
	}
	
	public static int getStackSize(Stack<Double> numbers)
	{
		return numbers.size();
	}
}