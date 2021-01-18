/*
    Author @Gaurav Amarnani.
    Published @18 January, 2021, 6:25 PM.
    Question 7 : Mathematical calculations on two numbers.
*/

package com.byGaurav.basics;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Question7 {
    public static void main(String... args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter number : ");
            Integer number = scanner.nextInt();
            for (int i = 1; i < 11; i++)
                System.out.println(number + " * " + i + " = " + (number * i));
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Improper Input.");
            main();
        }
    }
}