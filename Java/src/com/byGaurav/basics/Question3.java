/*
    Author @Gaurav Amarnani.
    Published @17 January, 2021, 12:00 PM.
    Question 3 : Division of two numbers.
*/

package com.byGaurav.basics;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Question3 {
    public static void main(String... args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter number 1 : ");
            Integer number1 = scanner.nextInt();
            System.out.println("Enter number 2 : ");
            Integer number2 = scanner.nextInt();
            Integer total = number1 / number2;
            System.out.println("Total : " + total);
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Improper Input.");
            main();
        }
    }
}