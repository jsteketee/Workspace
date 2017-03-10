package edu.skidmore.cs376b.example.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.skidmore.cs376b.junitdemo.sequencehunt.Formatter;

public class FormatterTest 
{
	
	Formatter formatter;
	
	@Before
	public void setup()
	{
		formatter= Formatter.getInstance();
	}
	
	@Test
	public void formatTimerTest()
	{
		assertEquals("Incorrect date string" ,"18:52:23", formatter.formatTimer(33434333434343434L));
		
	}
	
	
	
	
	
	

}
