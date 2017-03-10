package edu.skidmore.cs376b.example;

public class StringManip
{
    /**
     * Reverse a string
     * @param value
     *            The value to reverse
     * @return The reversed string
     */
    public String reversed(String value)
    {
        StringBuffer reversed = new StringBuffer();
        for (int posit = value.length() - 1; posit >= 0; --posit)
        {
            reversed.append(value.charAt(posit));
        }

        return reversed.toString();
    }

    /**
     * Obtain the middle character in a string. This can only be used with strings that have an odd number of characters in them.
     * @param value
     *            The string to be used
     * @return The middle character in the string
     * @throws IllegalStateException
     *             If the string has an even number of characters
     */
    public char middleChar(String value)
    {
        if (value.length() % 2 == 0)
        {
            throw new IllegalArgumentException("Can only obtain middle character for odd length strings");
        }

        return value.charAt(value.length() / 2);
    }

    /**
     * Checks whether the string is a palendrome.
     * @param value
     *            The value to check
     * @return True if the string contains a palendrome, false otherwise
     */
    public boolean isPalendrome(String value)
    {
        return value.equals(reversed(value));
    }

    /**
     * Extract every other character and return the result. For strings with an even number of characters the result will contain characters from index 1, 3, 5... For strings with an odd number of characters the result will contain characters from
     * index 0, 2, 4...
     * @param value
     *            The value to extract characters from
     * @return A string containing every other character from the original string
     */
    public String everyOther(String value)
    {
        StringBuffer skip = new StringBuffer();
        int start;

        if (value.length() % 2 == 0)
        {
            start = 1;
        }
        else
        {
            start = 0;
        }

        for (int posit = start; posit < value.length(); posit+=2)
        {
            skip.append(value.charAt(posit));
        }

        return skip.toString();
    }
}
