package com.company;

import java.util.NoSuchElementException;
import java.util.Stack;

public class RPNFunctions {
    private static double topItem;
    private static double secondItem;
    private static final String[] options = new String[]{"(any number) Enter any number to add to the stack",
            "(+) add the top two items", "(*) multiply the top two items",
            "(-) subtract the top item from the next item", "(/) integer divide the second item by the top item",
            "(%) find the integer remainder when dividing the second item by the top item",
            "(m) unary minus -- negate the top item", "(r) exchange the top two items",
            "(d) duplicate top item on the stack ", "(p) print the top item ", "(n) print and remove the top item ",
            "(f) print all the contents of the stack (leaving it intact) ", "(c) clear the stack ", "(q) quit ",
            "(h or ?) help "};

    public static void addToStack(Stack<Double> numbers, double number) {
        numbers.push(number);
    }

    public static void addition(Stack<Double> numbers) {
        if (numbers.size() < 2) {
            throw new NoSuchElementException();
        } else {
            topItem = numbers.pop();
            secondItem = numbers.pop();
            numbers.push(topItem + secondItem);
        }
    }

    public static void multiply(Stack<Double> numbers) {
        if (numbers.size() < 2) {
            throw new NoSuchElementException();
        } else {
            topItem = numbers.pop();
            secondItem = numbers.pop();
            numbers.push(topItem * secondItem);
        }
    }

    public static void subtract(Stack<Double> numbers) {
        if (numbers.size() < 2) {
            throw new NoSuchElementException();
        } else {
            topItem = numbers.pop();
            secondItem = numbers.pop();
            numbers.push(topItem - secondItem);
        }
    }

    public static void divide(Stack<Double> numbers) {
        if (numbers.size() < 2) {
            throw new NoSuchElementException();
        } else {
            topItem = numbers.pop();
            secondItem = numbers.pop();
            numbers.push(secondItem / topItem);
        }
    }

    public static void modulous(Stack<Double> numbers) {
        if (numbers.size() < 2) {
            throw new NoSuchElementException();
        } else {
            topItem = numbers.pop();
            secondItem = numbers.pop();
            numbers.push(secondItem % topItem);
        }
    }

    public static void negate(Stack<Double> numbers) {
        if (numbers.size() < 1) {
            throw new NoSuchElementException();
        } else {
            topItem = numbers.pop();
            numbers.push(topItem * -1);
        }
    }

    public static void exchange(Stack<Double> numbers) {
        if (numbers.size() < 2) {
            throw new NoSuchElementException();
        } else {
            topItem = numbers.pop();
            secondItem = numbers.pop();
            numbers.push(topItem);
            numbers.push(secondItem);
        }
    }

    public static void duplicate(Stack<Double> numbers) {
        if (numbers.size() < 1) {
            throw new NoSuchElementException();
        } else {
            topItem = numbers.lastElement();
            numbers.push(topItem);
        }
    }

    public static Double getTop(Stack<Double> numbers) {

        if (numbers.size() < 1) {
            throw new NoSuchElementException();
        } else {
            return numbers.peek();
        }
    }

    public static double getRemoveTop(Stack<Double> numbers) {

        if (numbers.size() < 1) {
            throw new NoSuchElementException();
        } else {
            return numbers.pop();
        }
    }

    public static void clear(Stack<Double> numbers) {
        numbers.clear();
    }

    public static String[] getHelpOptions() {
        return options;
    }
}