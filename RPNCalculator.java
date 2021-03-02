package com.company;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;

public class RPNCalculator {

    public static void main(String[] args) {
        Stack<Double> numberStack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        final String notEnoughItemsMessage = "(ERROR) - Not Enough Items in Stack\n\n";
        boolean running = true;

        while (running) {
            System.out.print("Enter operation(s) seperated by a space (use h or ? for help): ");
            /* goes through each operation entered by the user and tries to execute it */
            for (String operation : scanner.nextLine().split(" ")) {
                /* checks if user inputted a number, and if so, it is added to the stack */
                try {
                    RPNFunctions.addToStack(numberStack, Double.parseDouble(operation));
                    /* if user did not input a number, checks to see if it is a defined function */
                } catch (NumberFormatException e) {
                    switch (operation) {
                        case "+":
                            try {
                                RPNFunctions.addition(numberStack);
                            } catch (NoSuchElementException exception) {
                                System.out.println(notEnoughItemsMessage);
                            }
                            break;
                        case "*":
                            try {
                                RPNFunctions.multiply(numberStack);
                            } catch (NoSuchElementException exception) {
                                System.out.println(notEnoughItemsMessage);
                        }
                            break;
                        case "-":
                            try{
                                RPNFunctions.subtract(numberStack);
                            } catch (NoSuchElementException exception) {
                                System.out.println(notEnoughItemsMessage);
                            }
                            break;
                        case "/":
                            try{
                                RPNFunctions.divide(numberStack);
                            } catch (NoSuchElementException exception) {
                                System.out.println(notEnoughItemsMessage);
                            }
                            break;
                        case "%":
                            try{
                                RPNFunctions.modulous(numberStack);
                            } catch (NoSuchElementException exception) {
                                System.out.println(notEnoughItemsMessage);
                            }
                            break;
                        case "m":
                            try{
                                RPNFunctions.negate(numberStack);
                            } catch (NoSuchElementException exception) {
                                System.out.println(notEnoughItemsMessage);
                            }
                            break;
                        case "r":
                            try{
                                RPNFunctions.exchange(numberStack);
                            } catch (NoSuchElementException exception) {
                                System.out.println(notEnoughItemsMessage);
                            }
                            break;
                        case "d":
                            try{
                                RPNFunctions.duplicate(numberStack);
                            } catch (NoSuchElementException exception) {
                                System.out.println(notEnoughItemsMessage);
                            }
                            break;
                        case "p":
                            try{
                                System.out.printf("(TOP)\n%f\n\n\n",RPNFunctions.getTop(numberStack));
                            } catch (NoSuchElementException exception) {
                                System.out.println(notEnoughItemsMessage);
                            }
                            break;
                        case "n":
                            try{
                                System.out.printf("(TOP)\n%f\n\n\n", RPNFunctions.getRemoveTop(numberStack));
                            } catch (NoSuchElementException exception) {
                                System.out.println(notEnoughItemsMessage);
                            }
                            break;
                        /* Prints all the numbers in numberStack to the console */
                        case "f":
                            System.out.println("(TOP)");
                            for (Double number : numberStack) {
                                System.out.println(number);
                            }
                            System.out.println("\n");
                            break;
                        case "c":
                            RPNFunctions.clear(numberStack);
                            System.out.println("Cleared Stack\n\n");
                            break;
                        case "q":
                            System.out.println("Quitting");
                            running = false;
                            scanner.close();
                            break;
                        case "h":
                            for (String option: RPNFunctions.getHelpOptions()) {
                                System.out.println(option);
                            }
                            break;
                        case "?":
                            for (String option: RPNFunctions.getHelpOptions()) {
                                System.out.println(option);
                            }
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
