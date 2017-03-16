package Palindrome;

/*
 * Given a string, write a function to check if it is a permutation 
 * of a palindrome. A palindrome is a word or phrase that is the same 
 * forwards and backwards. A permutation is a rearrangement of letters. 
 * The palindrome does not need to be limited to just dictionary words. 
 */

import java.util.Arrays;

public class BruteForce {
	public static void main(String[] args) {
		System.out.println(palindrome("taco cat", "atco cta"));
	}
	
	//brute force solution is to sort the first and second string. Then check if they are equal
	//spaces would not matter
	public static boolean palindrome(String one, String two) {
		if(one.length() != two.length()) return false;
		
		//sort first string
		char[] c = one.toCharArray();
		Arrays.sort(c);
		one = new String(c);
		System.out.println(one);
		
		//sort second string
		char[] d = two.toCharArray();
		Arrays.sort(d);
		two = new String(d);
		System.out.println(two);
		
		return one.equals(two);
	}
}
