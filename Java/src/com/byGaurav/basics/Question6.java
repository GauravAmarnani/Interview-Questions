/*
    Author @Gaurav Amarnani.
    Published @18 January, 2021, 6:25 PM.
    Question 2 : Mathematical calculations on two numbers.
*/

package com.byGaurav.basics;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Question6 {
    public static void main(String... args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter number 1 : ");
            Integer number1 = scanner.nextInt();
            System.out.println("Enter number 2 : ");
            Integer number2 = scanner.nextInt();
            Integer total = number1 + number2;
            System.out.println("Addition : " + total);
            total = number1 - number2;
            System.out.println("Subtraction : " + total);
            total = number1 * number2;
            System.out.println("Multiplication : " + total);
            total = number1 / number2;
            System.out.println("Division : " + total);
            total = number1 % number2;
            System.out.println("Mod : " + total);
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Improper Input.");
            main();
        }
    }
}