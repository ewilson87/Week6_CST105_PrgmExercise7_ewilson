/**
 * Program: Palindromic Prime Number 
 * Project - PrgmExercise7 
 * File: PrgmExercise7.java
 * Summary: Loops through first 100,000 integers and prints all palindromic prime numbers
 * Author: Evan W Wilson 
 * Date: November 12, 2017
 **/
package prgmexercise7;

//import ArrayList
import java.util.ArrayList;

public class PrgmExercise7 {

    static int i = 1;
    static String string;

    public static void main(String[] args) {
        ArrayList<String> primePalindromic = new ArrayList<>();

        //runs each int between 1 and 100000 to isPrime and isPalindrome, if both are true adds value to ArrayList
        for (i = 1; i <= 100000; i++) {
            if (isPrime(i) == true && isPalindrome(i) == true) {
                //stores value as a string
                string = Integer.toString(i);
                primePalindromic.add(string);
            }
        }
        System.out.println("Palindromic Primes between 1 and 100,000");
        System.out.println("----------------------------------------");

        //count method to print primePalindromic arrayList with a blank line every 5 values
        int count = 0;
        for (i = 0; i < primePalindromic.size() - 1; i++) {
            System.out.printf("%7s", primePalindromic.get(i));
            count++;
            if (count % 5 == 0) {
                System.out.println();
            }
        }
    }

    //Method to check if number is prime
    public static boolean isPrime(int integer) {
        //prime number has to be larger than 2
        if (integer < 2) {
            return false;
        }
        //returns true for 2 because 2 is an exception to the integer % 2 == 0 argument below
        if (integer == 2) {
            return true;
        }
        //any even number cannot be prime
        if (integer % 2 == 0) {
            return false;
        }
        //compares odd numbers
        for (int i = 3; i * i <= integer; i += 2) {
            if (integer % i == 0) {
                return false;
            }
        }
        return true;
    }

    //Method to check if palindrome
    public static boolean isPalindrome(int integer) {
        //converts int to string to compare charAt values
        String toString = Integer.toString(integer);
        if (toString.length() == 1) {
            return true;
        }
        if (toString.length() == 2) {
            return toString.charAt(0) == toString.charAt(1);
        }
        if (toString.length() == 3) {
            return toString.charAt(0) == toString.charAt(2);
        }
        if (toString.length() == 4) {
            if (toString.charAt(0) == toString.charAt(3) && toString.charAt(1) == toString.charAt(2)) {
                return true;
            }
        }
        if (toString.length() == 5) {
            if (toString.charAt(0) == toString.charAt(4) && toString.charAt(1) == toString.charAt(3)) {
                return true;
            }
        }
        //returns false if no other condition is met
        //also returns false if integer length is 6 digits or more since program is designed to stop at 100,000
        //additional if statements would have to be made if comparing a larger number
        return false;
    }
}
