package edu.skidmore.cs376b.example.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.skidmore.cs376b.junitdemo.semanticworkbench.SearchParameters;

/**
 * Unit Test for the SearchParameters class
 * @author jstekete
 *
 */
public class SearchParametersTest 
{
	/**
	 * Exception detection rule
	 */
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	private SearchParameters sParams;
	
	private String pattern="abc";
	private int pos=3;
	
	@Before
	public void setup()
	{
		sParams = new SearchParameters(pattern, pos);
	}
	
	@Test
	public void getPattern()
	{
		assertEquals("incorrect pattern",pattern,sParams.getPattern());
	}
	
	@Test
	public void getPosition()
	{
		assertEquals("incorrect pos",pos,sParams.getPosition());
	}
	
	@Test
	public void isLastSearchWrapped()
	{
		sParams.setLastSearchWrapped(true);
		assertEquals("last search is wrapped",true,sParams.isLastSearchWrapped());
	}
	
	@Test
	public void setLastMatchLineNumber()
	{
		sParams.setLastMatchLineNumber(10);
		assertEquals("incorrect last match line number",10,sParams.getLastMatchLineNumber());
	}	
	
}
