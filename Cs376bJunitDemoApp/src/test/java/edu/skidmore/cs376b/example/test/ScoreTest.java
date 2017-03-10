package edu.skidmore.cs376b.example.test;

import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.skidmore.cs376b.junitdemo.Score;

/**
 * Unit tests for the Score Class
 * @author jack
 */
public class ScoreTest 
{
	/**
     * Exception detection rule
     */
    @Rule
    public ExpectedException thrown = ExpectedException.none();
	
    /**
     * Some instances of the score class for testing.
     */
    private Score score1;
    private Score score2;
    private Score score3;
    
    private String name1="Unkown Player";
    private String name2="Thomas";
    private String name3="Ben";
    
    private int curScore3=150;
    private int age3=15;
   
    @Before
    public void setup()
    {
    	score1=new Score();
    	score2=new Score(name2);		
    	score3=new Score(name3,curScore3);
    	score3.setAge(age3);
    }
    
    @Test
    public void getName()
    {
    	assertEquals("incorrect name",name2,score2.getName());
    }
    
    @Test
    public void getAge()
    {
    	assertEquals("incorrect age",age3,score3.getAge());
    }
    
    @Test
    public void getCurrentScore()
    {
    	assertEquals("incorrect score",curScore3,score3.getCurrentScore());
    }
    
    @Test
    public void setCurrentScoreNeg()
    {
    	thrown.expect(IllegalStateException.class);
        thrown.expectMessage(startsWith("The value"));
        score3.setCurrentScore(-14);
    }
    
    @Test
    public void setNameBlank()
    {
    	thrown.expect(IllegalArgumentException.class);
    	thrown.expectMessage(startsWith("The name"));
    	score3.setName("");
    }

    @Test
    public void setNameNull()
    {
    	thrown.expect(IllegalArgumentException.class);
    	thrown.expectMessage(startsWith("The name"));
    	score3.setName(null);
    }
    
    @Test
    public void setAgeMin()
    {
    	thrown.expect(IllegalArgumentException.class);
    	thrown.expectMessage(startsWith("The value"));
    	score3.setAge(10);
    }
    
    
    

}
