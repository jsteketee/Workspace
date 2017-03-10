package edu.skidmore.cs376b.example.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.hamcrest.CoreMatchers.startsWith;

import edu.skidmore.cs376b.example.StringManip;

public class StringManipTest
{
    /**
     * Exception detection rule
     */
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /**
     * StringManip instance for testing
     */
    private StringManip stringManip;

    @Before
    public void setup()
    {
        stringManip = new StringManip();
    }
    
    @Test
    public void ispalyndrome()
    {
    	assertEquals("Incorrect boolean value",false,stringManip.isPalendrome("racecara"));
    	assertEquals("Incorrect boolean value", true, stringManip.isPalendrome("racecar"));
    }
    
    @Test
    public void reversed()
    {
    	assertEquals("Incorrect reversal of original odd string", "racecar",stringManip.reversed("racecar"));
    	assertEquals("Incorrect reversal of original even string", "racecara",stringManip.reversed("aracecar"));
    	assertEquals("Incorrect reversal of empty string", "",stringManip.reversed(""));
    }
    
    @Test
    public void middleTestOdd()
    {
        assertEquals("Incorrect middle character", 'C', stringManip.middleChar("ABCDE"));
    }

    @Test
    public void middleTestEven()
    {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(startsWith("Can only obtain"));
        stringManip.middleChar("ABCD");
    }

    @Test
    public void everyOtherEven()
    {
    	assertEquals("Incorrect subset of characters", "BD", stringManip.everyOther("ABCD"));
    	assertEquals("Incorrect subset of characters", "ACE", stringManip.everyOther("ABCDE"));
    }


    public void everyOtherOdd()
    {
        assertEquals("Incorrect subset of characters", "ACE", stringManip.everyOther("ABCDE"));
    }
}
