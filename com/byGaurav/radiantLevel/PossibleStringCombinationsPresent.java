/*
-------------------------------------------------
|		1		|		2		|		3		|
|				|	   abc		|	   def		|
|-----------------------------------------------|
|		4		|		5		|		6		|
| 	   ghi		|	   jkl		|	   mno		|
|-----------------------------------------------|
|		7		|		8		|		9		|
|	  pqrs		|	   tuv		|	  wxyz		|
-------------------------------------------------
				|		0		|
				|	  			|
				-----------------
1 (800) 356 9377 -> 1 (800) flowers
Sample Input :
phoneNumber = "3662277", listOfWords = ["foo", "bar", "baz", "foobar", "emo", "cap", "joke"]
Sample Output:
listOfWordsPresent = ["bar", "emo", "foo", "foobar", "cap"]
Q. Find out the list of words that occur in the phoneNumber String in continuous order.
 */

package com.byGaurav.radiantLevel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.*;

public class PossibleStringCombinationsPresent {

    private String phoneNumber;
    private final Map<String, Integer> alphabetNumericalCombinations = new HashMap<>();
    private List<String> listOfWords = new ArrayList<>();
    private final Scanner MY_SCANNER = new Scanner(in);

    public static void main(String...args) {
        PossibleStringCombinationsPresent pSCP = new PossibleStringCombinationsPresent();
        pSCP.takeInput();
        pSCP.populateAlphabetNumericalCombinations();
        ArrayList<String> listOfWordsPresent = pSCP.checkForPossibleCombinations();
        out.println("List of words present is " + listOfWordsPresent);
        pSCP.MY_SCANNER.close();
    }

    public void takeInput() {
        out.println("Enter the Phone Number: ");
        phoneNumber = MY_SCANNER.nextLine();
        out.println("Enter the List of Words: Example: [dog cat car mice]");
        String tempListOfWords = MY_SCANNER.nextLine();
        listOfWords = Arrays.asList(tempListOfWords.toLowerCase().split(" "));
    }

    public void populateAlphabetNumericalCombinations() {
        List<Integer> listOfMatchingNumbers = Arrays.asList(2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9);
        for (int i = 0; i < listOfMatchingNumbers.size(); i++)
            alphabetNumericalCombinations.put(String.valueOf((char) (97 + i)), listOfMatchingNumbers.get(i));
    }

    public ArrayList<String> checkForPossibleCombinations() {
        ArrayList<String> finalList = new ArrayList<>();
        for (String eachWord: listOfWords)
            if(phoneNumber.contains(convertAlphabetToNumber(eachWord)))
                finalList.add(eachWord);
        return finalList;
    }

    public String convertAlphabetToNumber(String input) {
        StringBuilder temp = new StringBuilder("");
        for(int i = 0; i < input.length(); i++)
            temp.append(alphabetNumericalCombinations.get("" + input.charAt(i)));
        return temp.toString();
    }
}
