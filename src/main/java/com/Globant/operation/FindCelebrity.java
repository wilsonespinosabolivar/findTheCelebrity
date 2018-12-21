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
     * Finds the celebrity in {@param peoples} where 
     * peoples[i][j] is 1 when person i knows person j. 
     * <p/> 
     * Algorithm: 
     * - If A knows B, then A can’t be celebrity. Discard A, but B may be celebrity. 
     * - If A does not know B, then B can’t be celebrity. Discard B, but A may be celebrity. 
     * - Repeat above two steps till we left with only one person. 
     * Find celebrity within remaining persons by performing the below operations: 
     * - Push all the celebrities into a stack. 
     * - Pop off top two persons from the stack, discard one person based on return status of HaveAcquaintance(A, B). 
     * - Push the remained person onto stack. 
     * - Repeat step 2 and 3 until only one person remains in the stack. 
     * - Check the remained person in stack does not have acquaintance with anyone else. 
     *  
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
