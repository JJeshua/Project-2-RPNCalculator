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
	public static double firstSelected;
	public static double secondSelected;
	public static String[] options = new String[] 
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
	
	public static void addition()
	{
		try {
			firstSelected = numbers.pop();
			secondSelected = numbers.pop();
			numbers.push(secondSelected + firstSelected);
		} catch (EmptyStackException e) {
			System.out.println("(ERROR) - Not Enough Items in Stack\n\n");
			if (firstSelected != 0.0) numbers.push(firstSelected);
		}
	}
	
	public static void multiply()
	{
		try {
			firstSelected = numbers.pop();
			secondSelected = numbers.pop();
			numbers.push(secondSelected * firstSelected);
		} catch (EmptyStackException e) {
			System.out.println("(ERROR) - Not Enough Items in Stack");
			if (firstSelected != 0.0) numbers.push(firstSelected);
		}
	}
	
	public static void subtract()
	{
		try {
			firstSelected = numbers.pop();
			secondSelected = numbers.pop();
			numbers.push(secondSelected - firstSelected);
		} catch (EmptyStackException e) {
			System.out.println("(ERROR) - Not Enough Items in Stack");
			if (firstSelected != 0.0) numbers.push(firstSelected);
		}
		
	}
	
	public static void divide()
	{
		try {
			firstSelected = numbers.pop();
			secondSelected = numbers.pop();
			numbers.push(secondSelected / firstSelected);
		} catch (EmptyStackException e) {
			System.out.println("(ERROR) - Not Enough Items in Stack");
			if (firstSelected != 0.0) numbers.push(firstSelected);
		}
		
	}
	
	public static void modulous()
	{
		try {
			firstSelected = numbers.pop();
			secondSelected = numbers.pop();
			numbers.push(secondSelected % firstSelected);
		} catch (EmptyStackException e) {
			System.out.println("(ERROR) - Not Enough Items in Stack");
			if (firstSelected != 0.0) numbers.push(firstSelected);
		}
		
	}
	
	public static void negate() 
	{
		try {
			firstSelected = numbers.pop();
			numbers.push(firstSelected * -1);
		} catch (EmptyStackException e) {
			System.out.println("(ERROR) - Not Enough Items in Stack");
		}
	}
	
	public static void exchange() 
	{
		try {
			firstSelected = numbers.pop();
			secondSelected = numbers.pop();
			numbers.push(firstSelected);
			numbers.push(secondSelected);
		} catch (EmptyStackException e) {
			System.out.println("(ERROR) - Not Enough Items in Stack");
			if (firstSelected != 0.0) numbers.push(firstSelected);
		}
	}
	
	public static void duplicate() 
	{
		try {
			firstSelected = numbers.lastElement();
			numbers.push(firstSelected);
		} catch (Exception e) {
			System.out.println("(ERROR) - Not Enough Items in Stack");
		}
		
	}
	
	public static void printTop() 
	{
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