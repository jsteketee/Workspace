package edu.skidmore.cs376b.example.test;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.awt.Font;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import edu.skidmore.cs376b.junitdemo.semanticworkbench.FontData;

/**
 * Unit tests for the FontData class
 * @author jack
 */
public class FontDataTest 
{
	/**
     * Exception detection rule
     */
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    private FontData font;
    
    private Color pcolor=new Color(3,4,3); 
    private Font pfont = new Font("abc",3,4);

	@Before
	public void setup()
	{
		font = new FontData(pfont, pcolor);
	}
	
	@Test
	public void getColor()
	{
		assertEquals("Returned color did not match",pcolor,font.getColor());
	}
	
	@Test
	public void getFont()
	{
		assertEquals("Returned font did not match",pfont,font.getFont());
	}
	
	
	
	
	
}
