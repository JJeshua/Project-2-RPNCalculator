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
	public static Stack<Double> numbers = new Stack<>();
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
	
	
	public static void addToStack(double number)
	{
		numbers.push(number);
	}
	
	public static void clearSelected()
	{
		topItem = 0.0;
		secondItem = 0.0;
	}
	
	public static void addition()
	{
		clearSelected();
		try {
			topItem = numbers.pop();
			secondItem = numbers.pop();
			numbers.push(secondItem + topItem);
		} catch (EmptyStackException e) {
			System.out.println("(ERROR) - Not Enough Items in Stack\n\n");
			if (topItem != 0.0) numbers.push(topItem);
		}
	}
	
	public static void multiply()
	{
		clearSelected();
		try {
			topItem = numbers.pop();
			secondItem = numbers.pop();
			numbers.push(secondItem * topItem);
		} catch (EmptyStackException e) {
			System.out.println("(ERROR) - Not Enough Items in Stack\n\n");
			if (topItem != 0.0) numbers.push(topItem);
		}
	}
	
	public static void subtract()
	{
		clearSelected();
		try {
			topItem = numbers.pop();
			secondItem = numbers.pop();
			numbers.push(topItem - secondItem);
		} catch (EmptyStackException e) {
			System.out.println("(ERROR) - Not Enough Items in Stack\n\n");
			if (topItem != 0.0) numbers.push(topItem);
		}
		
	}
	
	public static void divide()
	{
		clearSelected();
		try {
			topItem = numbers.pop();
			secondItem = numbers.pop();
			numbers.push(secondItem / topItem);
		} catch (EmptyStackException e) {
			System.out.println("(ERROR) - Not Enough Items in Stack\n\n");
			if (topItem != 0.0) numbers.push(topItem);
		}
		
	}
	
	public static void modulous()
	{
		clearSelected();
		try {
			topItem = numbers.pop();
			secondItem = numbers.pop();
			numbers.push(secondItem % topItem);
		} catch (EmptyStackException e) {
			System.out.println("(ERROR) - Not Enough Items in Stack\n\n");
			if (topItem != 0.0) numbers.push(topItem);
		}
		
	}
	
	public static void negate() 
	{
		clearSelected();
		try {
			topItem = numbers.pop();
			numbers.push(topItem * -1);
		} catch (EmptyStackException e) {
			System.out.println("(ERROR) - Not Enough Items in Stack\n\n");
		}
	}
	
	public static void exchange() 
	{
		clearSelected();
		try {
			topItem = numbers.pop();
			secondItem = numbers.pop();
			numbers.push(topItem);
			numbers.push(secondItem);
		} catch (EmptyStackException e) {
			System.out.println("(ERROR) - Not Enough Items in Stack\n\n");
			if (topItem != 0.0) numbers.push(topItem);
		}
	}
	
	public static void duplicate() 
	{
		clearSelected();
		try {
			topItem = numbers.lastElement();
			numbers.push(topItem);
		} catch (Exception e) {
			System.out.println("(ERROR) - Not Enough Items in Stack\n\n");
		}
		
	}
	
	public static void printTop() 
	{
		clearSelected();
		try {
			System.out.println();
			System.out.println(numbers.lastElement());
			System.out.println();
		} catch (NoSuchElementException e) {
			System.out.println("(ERROR) - Not Enough Items in Stack\n\n");
		}
		
	}
	
	public static void printRemoveTop() 
	{
		clearSelected();
		try {
			System.out.println();
			System.out.println(numbers.pop());
			System.out.println();
		} catch (EmptyStackException e) {
			System.out.println("(ERROR) - Not Enough Items in Stack\n\n");
		}
		
	}
	
	public static void printAll() 
	{
		clearSelected();
		
		System.out.println();
		System.out.println("(TOP)");
		for (int i=numbers.size()-1; i>-1; i--)
		{
			System.out.println(numbers.elementAt(i));
		}
		System.out.println();
	}
	
	public static void clear() 
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
	
	public static int getStackSize()
	{
		return numbers.size();
	}
}