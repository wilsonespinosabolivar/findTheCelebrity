package com.Globant.operation;

import java.util.Stack;

public class FindCelebrity {
	/**
     * Check if the person "A" knows the "B" who is at his side at the table 
     * 
     * @param guests 
     * @param a 
     * @param b 
     * @return 
     */ 
    public static boolean theyKnowEachOther(int[][] guests, int a, int b) { 
        return guests[a][b] == 1; 
    } 
 
    /**
     * Finds the celebrity in {@param guests} where 
     * peoples[i][j] is 1 when person i knows person j.   
     * @param peoples 
     * @return 
     */ 
    public int findCelebrity(int[][] guests) { 
 
        Stack<Integer> possibleCelebrities = new Stack<Integer>(); 
 
    	/**
         * Find out if is a celebrity
         */
        for (int i = 0; i < guests.length; i++) { 
            for (int j = 0; j < guests[0].length; j++) { 
                if (theyKnowEachOther(guests, i, j)) { 
                    possibleCelebrities.push(j); 
                } 
            } 
        } 
 
        int personA = -1;
        int personB; 
        while (!possibleCelebrities.isEmpty()) { 
        	personA = possibleCelebrities.pop(); 
 
            // we have found the celebrity 
            if (possibleCelebrities.isEmpty()) break; 
 
            personB = possibleCelebrities.pop(); 
            if (theyKnowEachOther(guests, personA, personB)) { 
                possibleCelebrities.push(personB); 
            } else { 
                possibleCelebrities.push(personA); 
            } 
        } 
 
        return personA; 
    } 

}
