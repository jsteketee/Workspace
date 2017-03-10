package edu.skidmore.cs376b.example;

import org.apache.log4j.Logger;

/**
 * This class generates some number of elements in the Fibonacci sequence. The
 * number of elements may be provided on the command line. If the number
 * provided is outside the range of 1-100 or is not supplied, then the first 10
 * elements are output.
 * @author readda
 */
public class FibonacciSequenceGenerator
{
    /**
     * The logger for the class
     */
    private static Logger LOG = Logger.getLogger(FibonacciSequenceGenerator.class);

    /**
     * Returns a specific Fibonacci value at the supplied location in the
     * sequence. element numbering begins at 0. This method uses a recursive approach.
     * @param sequencePosition
     *            The position in the sequence to return
     * @return The Fibonacci value at the supplied position in the sequence
     * @throws IllegalArgumentException
     *             If the requested position is negative
     */
    public int fibonacciRecursive(int sequencePosition)
    {
        int fib;

        LOG.debug("Recursive call for position: " + sequencePosition);

        if (sequencePosition < 0)
        {
            throw new IllegalArgumentException("Can only generate values for positions 0 and higher");
        }

        if (sequencePosition == 0)
        {
            fib = 0;
        }
        else if (sequencePosition == 1)
        {
            fib = 1;
        }
        else
        {
            fib = fibonacciRecursive(sequencePosition - 1) + fibonacciRecursive(sequencePosition - 2);
        }

        LOG.debug("Recursive call for position: " + sequencePosition + " returning value " + fib);

        return fib;
    }

    /**
     * Returns a specific Fibonacci value at the supplied location in the
     * sequence. element numbering begins at 0. This method uses an iterative approach.
     * @param sequencePosition
     *            The position in the sequence to return
     * @return The Fibonacci value at the supplied position in the sequence
     * @throws IllegalArgumentException
     *             If the requested position is negative
     */
    public int fibonacciIterative(int sequencePosition)
    {
        int fib;
        
        if (sequencePosition < 0)
        {
            throw new IllegalArgumentException("Can only generate values for positions 0 and higher");
        }

        if (sequencePosition == 0)
        {
            fib = 0;
        }
        else
        {
            int value1 = 0;
            int value2 = 1;

            for (int position = 2; position < sequencePosition; ++position)
            {
            	int temp = value1;
            	value1 = value2;
            	value2 = value2 +temp;
            }

            fib = value1 + value2;
        }

        LOG.debug("Recursive call for position: " + sequencePosition + " returning value " + fib);

        return fib;
    }
}
