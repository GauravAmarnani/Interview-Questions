/*
    Author @Gaurav Amarnani.
    Published @18 January, 2021, 6:50 PM.
    Question : Fibonacci Series.
*/

package com.byGaurav.codingQuestions;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Question1 {
    public static void main(String... args) {
        Scanner scanner = new Scanner(in);
        out.println("Enter number till which you want the fibonacci series : ");
        Integer end = scanner.nextInt();
        Integer first = 0, second = 1, temp = 0;
        out.print("Fibonacci series for " + end + " :\n" + first + " " + second);
        while (second < end) {
            temp = first;
            first = second;
            second = temp + first;
            if (second < end)
                out.print(" " + second);
        }
    }
}