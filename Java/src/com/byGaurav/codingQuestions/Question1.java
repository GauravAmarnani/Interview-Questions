/*
    Author @Gaurav Amarnani.
    Published @18 January, 2021, 6:50 PM.
    Question : Fibonacci Series
               A. Up to a particular number.
               B. For a particular number of times.
*/

package com.byGaurav.codingQuestions;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Question1 {
    public static void main(String... args) {
        Scanner scanner = new Scanner(in);
        out.println("Enter number for fibonacci series : ");
        Integer number = scanner.nextInt();
        out.println("Choose A for 'Up to a particular number.' & B for 'For a particular number of times.'");
        String choice = scanner.next();
        switch (choice) {
            case "A":
                uptoNumber(number);
                break;
            case "B":
                forNumberTimes(number);
                break;
            default:
                out.println("Imporper Input.");
                main();
        }
        scanner.close();
    }

    public static void uptoNumber(Integer end) {
        Integer first = 1, second = 1, temp = 0;
        out.print("Fibonacci series for " + end + " :\n" + first + " " + second);
        while (second < end) {
            temp = first;
            first = second;
            second = temp + first;
            if (second < end)
                out.print(" " + second);
        }
    }

    public static void forNumberTimes(Integer times) {
        Integer first = 1, second = 1, temp = 0;
        out.print("Fibonacci series for " + times + " number of times :\n" + first + " " + second);
        for (int i = 1; i < times - 1; i++) {
            temp = first;
            first = second;
            second = temp + first;
            out.print(" " + second);
        }
    }
}