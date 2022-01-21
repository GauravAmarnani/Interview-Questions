package com.byGaurav.basicLevel;

import java.util.Scanner;
import static java.lang.System.*;

public class StockBuyAndSell {

    public static void main(String[] args) {
        int profit = 0;
        Scanner scanner = new Scanner(in);
        int totalDays = scanner.nextInt();
        int[] stockPrice = new int[totalDays];

        for(int i = 0; i < totalDays; i++)
            stockPrice[i] = scanner.nextInt();

        for(int i = 0; i < totalDays; i++) {
            if(!(i == totalDays-1)) {
                if (stockPrice[i] < stockPrice[i + 1])
                    profit += stockPrice[i + 1] - stockPrice[i];
                else
                    profit -= stockPrice[i] - stockPrice[i + 1];
            }
        }

        if(profit > 0)
            out.println("Profit made is: " + profit);
        else
            out.println("No Profit Made.");
    }
}