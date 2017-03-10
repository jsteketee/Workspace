package edu.skidmore.cs376b.example.test;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.Random;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.skidmore.cs376b.junitdemo.sequencehunt.SequenceHuntGameModel;

/**
 * Unit tests for the SequenceHunt
 * @author jack
 */
public class SequenceHuntTest 
{
	/**
     * Exception detection rule
     */
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /**
     * An instance of sequencehunt for testing
     */
	SequenceHuntGameModel curGame;
	SequenceHuntGameModel otherGame;
	
	/**
	 * Some params for testing
	 */
	int sequenceLength = 6;
	Random rand = new Random();
	
	@Before
	public void setup()
	{
		curGame = new SequenceHuntGameModel(sequenceLength);
	}
	
	@Test 
	public void maxSeqLeng()
	{
		otherGame=new SequenceHuntGameModel(10000);
		assertEquals("wrong seq length",4,otherGame.getSequenceLength());
	}
	@Test
	public void isWinner()
	{
		curGame.signalGameRestored();
		curGame.setWinner(true);
		assertEquals("Wrong boolean value",true,curGame.isWinner());
	}
	
	@Test
	public void isLoser()
	{
		assertEquals("Wrong boolean value",false,curGame.isLoser());
	}
	
	@Test
	public void getTryColorCodes()
	{
		for(int i=1;i<10;i++)
		{
			curGame.getTryColorCode(rand.nextInt(5), rand.nextInt(5));
		}
	}
	@Test
	public void getMaxTrys()
	{
		assertEquals("wrong number of max trys",10,curGame.getMaxTrys());
	}
	
	@Test
	public void getTryProgress()
	{
		assertEquals("wrong number of trys",0,curGame.getTryProgress());
	}
	
	@Test
	public void getAnswerValue()
	{
		curGame.getAnswerValue();
	}
	@Test
	public void getElapstedTime()
	{
		curGame.signalGameEnd();
		curGame.signalGamePaused();
		curGame.updateElapsedTime();
		curGame.signalGameRestored();
		assertEquals("wrong amount of time",0L,curGame.getElapsedTime());
	}
	
	@Test
	public void addGuess()
	{
		assertEquals("wrong boolean value",true,curGame.addGuess(1));
	}
	
	@Test
	public void removeLastGuessEmpty()
	{
		assertEquals("wrong boolean value", false, curGame.removeLastGuess());
	}
	@Test
	public void removeLastGuessNonEmpty()
	{
		curGame.addGuess(1);
		assertEquals("wrong boolean value", true, curGame.removeLastGuess());
	}
	
	@Test
	public void submitGuess()
	{
		//submit empty guess list
		assertEquals("wrong boolean value",false,curGame.submitGuess());
		for(int i=0;i<curGame.getSequenceLength();i++)
			curGame.addGuess(3);
		assertEquals("wrong boolean value",true, curGame.removeLastGuess());
		curGame.addGuess(3);
		//submit full guess list
		assertEquals("wrong boolean val",true,curGame.submitGuess());
		
	}

	@Test
	public void getClueColorCode()
	{
		Color c=Color.GRAY; 
		assertEquals("Wrong Color", c, curGame.getClueColorCode(0, 0));
	}
	
	@Test
	public void getTryClueColorCode()
	{
		Color c=Color.GRAY; 
		assertEquals("Wrong Color", c, curGame.getTryColorCode(0, 0));
	}
	
}
