package com.cloudview.lib;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class RandomPasswordGene {
	// Define default min and max password lengths.
    private static int DEFAULT_MIN_PASSWORD_LENGTH  = 8;
    private static int DEFAULT_MAX_PASSWORD_LENGTH  = 10;
    // Define supported password characters divided into groups.
    private static String PASSWORD_CHARS_LCASE  = "abcdefgijkmnopqrstwxyz";
    private static String PASSWORD_CHARS_UCASE  = "ABCDEFGHJKLMNPQRSTWXYZ";
    private static String PASSWORD_CHARS_NUMERIC= "23456789";
    private static String PASSWORD_CHARS_SPECIAL= "*$-+?_&=!%{}/";
    
    public static String Generate()
    {
        return Generate(DEFAULT_MIN_PASSWORD_LENGTH, DEFAULT_MAX_PASSWORD_LENGTH);
    }

    public static String Generate(int length)
    {
        return Generate(length, length);
    }
    
    public static String Generate(int   minLength,int   maxLength){
    	// Make sure that input parameters are valid.
        if (minLength <= 0 || maxLength <= 0 || minLength > maxLength)
            return null;
        // Create a local array containing supported password characters
        // grouped by types. You can remove character groups from this
        // array, but doing so will weaken the password strength.
        char[][] charGroups = new char[][] 
        {
            PASSWORD_CHARS_LCASE.toCharArray(),
            PASSWORD_CHARS_UCASE.toCharArray(),
            PASSWORD_CHARS_NUMERIC.toCharArray(),
            PASSWORD_CHARS_SPECIAL.toCharArray()
        };
        // Use this array to track the number of unused characters in each
        // character group.
        int[] charsLeftInGroup = new int[charGroups.length];
        // Initially, all characters in each group are not used.
        for (int i=0; i<charsLeftInGroup.length; i++)
            charsLeftInGroup[i] = charGroups[i].length;
        // Use this array to track (iterate through) unused character groups.
        int[] leftGroupsOrder = new int[charGroups.length];
        // Initially, all character groups are not used.
        for (int i=0; i<leftGroupsOrder.length; i++)
            leftGroupsOrder[i] = i;
     // Use a 4-byte array to fill it with random bytes and convert it then
        // to an integer value.
        byte[] randomBytes = new byte[4];
        SecureRandom rng;
		try {
			rng = SecureRandom.getInstance("SHA1PRNG");
			rng.nextBytes(randomBytes);
			int seed = BitConverter.toInt32(randomBytes, 0);
			// Now, this is real randomization.
	        Random  random  = new Random(seed);
	     // This array will hold password characters.
	        char[] password = null;
            
	        // Allocate appropriate memory for the password.
	        if (minLength < maxLength)
	            password = new char[random.nextInt(maxLength+1-minLength)+minLength];
	        else
	            password = new char[minLength];

	        // Index of the next character to be added to password.
	        int nextCharIdx;
	        
	        // Index of the next character group to be processed.
	        int nextGroupIdx;

	        // Index which will be used to track not processed character groups.
	        int nextLeftGroupsOrderIdx;
	        
	        // Index of the last non-processed character in a group.
	        int lastCharIdx;

	        // Index of the last non-processed group.
	        int lastLeftGroupsOrderIdx = leftGroupsOrder.length - 1;
	     // Generate password characters one at a time.
	        for (int i=0; i<password.length; i++)
	        {
	            // If only one character group remained unprocessed, process it;
	            // otherwise, pick a random character group from the unprocessed
	            // group list. To allow a special character to appear in the
	            // first position, increment the second parameter of the Next
	            // function call by one, i.e. lastLeftGroupsOrderIdx + 1.
	            if (lastLeftGroupsOrderIdx == 0)
	                nextLeftGroupsOrderIdx = 0;
	            else
	                nextLeftGroupsOrderIdx = random.nextInt(lastLeftGroupsOrderIdx);

	            // Get the actual index of the character group, from which we will
	            // pick the next character.
	            nextGroupIdx = leftGroupsOrder[nextLeftGroupsOrderIdx];

	            // Get the index of the last unprocessed characters in this group.
	            lastCharIdx = charsLeftInGroup[nextGroupIdx] - 1;
	            
	            // If only one unprocessed character is left, pick it; otherwise,
	            // get a random character from the unused character list.
	            if (lastCharIdx == 0)
	                nextCharIdx = 0;
	            else
	                nextCharIdx = random.nextInt(lastCharIdx+1);

	            // Add this character to the password.
	            password[i] = charGroups[nextGroupIdx][nextCharIdx];
	            
	            // If we processed the last character in this group, start over.
	            if (lastCharIdx == 0)
	                charsLeftInGroup[nextGroupIdx] = 
	                                          charGroups[nextGroupIdx].length;
	            // There are more unprocessed characters left.
	            else
	            {
	                // Swap processed character with the last unprocessed character
	                // so that we don't pick it until we process all characters in
	                // this group.
	                if (lastCharIdx != nextCharIdx)
	                {
	                    char temp = charGroups[nextGroupIdx][lastCharIdx];
	                    charGroups[nextGroupIdx][lastCharIdx] = 
	                                charGroups[nextGroupIdx][nextCharIdx];
	                    charGroups[nextGroupIdx][nextCharIdx] = temp;
	                }
	                // Decrement the number of unprocessed characters in
	                // this group.
	                charsLeftInGroup[nextGroupIdx]--;
	            }

	            // If we processed the last group, start all over.
	            if (lastLeftGroupsOrderIdx == 0)
	                lastLeftGroupsOrderIdx = leftGroupsOrder.length - 1;
	            // There are more unprocessed groups left.
	            else
	            {
	                // Swap processed group with the last unprocessed group
	                // so that we don't pick it until we process all groups.
	                if (lastLeftGroupsOrderIdx != nextLeftGroupsOrderIdx)
	                {
	                    int temp = leftGroupsOrder[lastLeftGroupsOrderIdx];
	                    leftGroupsOrder[lastLeftGroupsOrderIdx] = 
	                                leftGroupsOrder[nextLeftGroupsOrderIdx];
	                    leftGroupsOrder[nextLeftGroupsOrderIdx] = temp;
	                }
	                // Decrement the number of unprocessed groups.
	                lastLeftGroupsOrderIdx--;
	            }
	        }
	     // Convert password characters into a string and return the result.
	        return new String(password);
		} 
		catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
        
    }
}
