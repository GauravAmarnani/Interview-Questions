/*
    Author : @Gaurav Amarnani.
    Published @17 January, 2021, 12:10 PM.
    Question 4 : Write a Java program to print the result of the following operations.
                    Test Data:
                    a. -5 + 8 * 6
                    b. (55+9) % 9
                    c. 20 + -3*5 / 8
                    d. 5 + 15 / 3 * 2 - 8 % 3
*/

package com.byGaurav.basics;

import static java.lang.System.out;

public class Question4 {
    public static void main(String... args) {
        String equation = "a. -5 + 8 * 6";
        out.print(equation + " : ");
        out.println(-5 + 8 * 6);
        equation = "b. (55+9) % 9";
        out.print(equation + " : ");
        out.println((55 + 9) % 9);
        equation = "c. 20 + -3*5 / 8";
        out.print(equation + " : ");
        out.println(20 + -3 * 5 / 8);
        equation = "d. 5 + 15 / 3 * 2 - 8 % 3";
        out.print(equation + " : ");
        out.println(5 + 15 / 3 * 2 - 8 % 3);
    }
}