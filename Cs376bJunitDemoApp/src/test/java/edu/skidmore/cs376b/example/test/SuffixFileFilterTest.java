package edu.skidmore.cs376b.example.test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.skidmore.cs376b.junitdemo.basicquery.SuffixFileFilter;

/**
 * Unit tests for the FibonacciSequenceGenerator
 * @author jack
 */
public class SuffixFileFilterTest 
{
	/**
     * Exception detection rule
     */
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * An instance of the FileFilter for testing
     */
    private SuffixFileFilter filter;
    
    private String description= "a description";
    private String[] list = new String[]{"Abc","dEf","ghI"}; 
    private String[] list2 = new String[]{".Abc","dEf","ghI"}; 
    /**
     * Some instances of Files for method testing
     */
    private File file1=new File("filename.def");
    private File file2=new File("filename.ded");
   
    @Before
    public void setup()
    {
    	filter= new SuffixFileFilter(description,list);
    }
    
    @Test
    public void makeWithPrimarySuffixMatches()
    {
    	assertEquals("Incorrect file path",file1.getAbsolutePath(),filter.makeWithPrimarySuffix(file1).getAbsolutePath());
    }
    
    @Test
    public void makeWithPrimarySuffixNoMatch()
    {
    	assertEquals("Incorrect file path",file2.getAbsolutePath()+".abc",filter.makeWithPrimarySuffix(file2).getAbsolutePath());
    }
    
    @Test
    public void makeWithPrimarySuffixStartsWithDot()
    {
    	SuffixFileFilter filter2 = new SuffixFileFilter(description,list2);
    	assertEquals("Incorrect file path",file2.getAbsolutePath()+".abc",filter2.makeWithPrimarySuffix(file2).getAbsolutePath());
    }
    
    @Test
    public void acceptDir()
    {
    	File file3=new File("test");
    	file3.mkdir();
    	assertEquals("file should be directory",true,filter.accept(file3));
    }
    
    @Test 
    public void getDescription()
    {
    	assertEquals("incorrect description",description,filter.getDescription());
    }
}
