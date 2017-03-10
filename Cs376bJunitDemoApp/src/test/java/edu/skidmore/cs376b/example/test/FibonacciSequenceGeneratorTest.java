package edu.skidmore.cs376b.example.test;

import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.skidmore.cs376b.example.FibonacciSequenceGenerator;

/**
 * Unit tests for the FibonacciSequenceGenerator
 * @author readda
 */
public class FibonacciSequenceGeneratorTest
{
    /**
     * Exception detection rule
     */
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /**
     * An instance of the generator for testing
     */
    private FibonacciSequenceGenerator fibonacciGenerator;

    @Before
    public void setup()
    {
        fibonacciGenerator = new FibonacciSequenceGenerator();
    }

    @Test
    public void fibonacciRecursive0()
    {
        assertEquals("Incorrect value for Fibonacci position 0", 0, fibonacciGenerator.fibonacciRecursive(0));
    }

    @Test
    public void fibonacciRecursive1()
    {
        assertEquals("Incorrect value for Fibonacci position 1", 1, fibonacciGenerator.fibonacciRecursive(1));
    }

    @Test
    public void fibonacciRecursive6()
    {
        assertEquals("Incorrect value for Fibonacci position 6", 8, fibonacciGenerator.fibonacciRecursive(6));
    }

    @Test
    public void fibonacciRecursiveNegative()
    {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(startsWith("Can only generate"));

        fibonacciGenerator.fibonacciRecursive(-2);
    }

    @Test
    public void fibonacciIterative0()
    {
        assertEquals("Incorrect value for Fibonacci position 0", 0, fibonacciGenerator.fibonacciIterative(0));
    }

    @Test
    public void fibonacciIterative1()
    {
        assertEquals("Incorrect value for Fibonacci position 1", 1, fibonacciGenerator.fibonacciIterative(1));
    }

    @Test
    public void fibonacciIterative6()
    {
        assertEquals("Incorrect value for Fibonacci position 6", 8, fibonacciGenerator.fibonacciIterative(6));
    }

    @Test
    public void fibonacciIterativeNegative()
    {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(startsWith("Can only generate"));

        fibonacciGenerator.fibonacciIterative(-2);
    }
}
