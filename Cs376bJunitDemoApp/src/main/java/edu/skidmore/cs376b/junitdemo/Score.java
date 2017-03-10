package edu.skidmore.cs376b.junitdemo;

import org.apache.log4j.Logger;

/**
 * A score counting bean.
 * @author readda
 */
public class Score
{
    /**
     * The minimum score a player may have
     */
    private final static int MIN_SCORE = 0;

    /**
     * The minimum age allowed for a player
     */
    private final static int MIN_AGE = 13;

    /**
     * The logger instance
     */
    private final static Logger LOG = Logger.getLogger(Score.class);

    /**
     * The player's current score
     */
    private int currentScore;

    /**
     * The player's name
     */
    private String name;

    /**
     * The player's age
     */
    private int age;

    /**
     * Create the instance with a default name
     */
    public Score()
    {
        setName("Unknown Player");
    }

    /**
     * Create the instance with an assigned name
     * @param name
     *            The assigned name
     */
    public Score(String name)
    {
        setName(name);
    }

    /**
     * Create the instance with an assigned name and assigned initial score
     * @param name
     *            The assigned name
     * @param initialScore
     *            The initial score for the player
     */
    public Score(String name, int initialScore)
    {
        setName(name);
        setCurrentScore(initialScore);
    }

    /**
     * Gets the player's current score
     * @return The current score
     */
    public int getCurrentScore()
    {
        return currentScore;
    }

    /**
     * Set the current score for the player.
     * @param currentScore
     *            The current score
     * @throws IllegalStateException
     *             If the current score is outside the allowed range
     */
    public void setCurrentScore(int currentScore)
    {
        if (currentScore < MIN_SCORE)
        {
            throw new IllegalStateException(
            "The value " + currentScore + " is not allowed. The score must be " + MIN_SCORE + " or more");
        }
        this.currentScore = currentScore;
    }

    /**
     * Get the player's name
     * @return The name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Set the player's name
     * @param name
     *            The name
     * @throws IllegalArgumentException
     *             If the name is empty or null
     */
    public void setName(String name)
    {
        if (name == null || name.length() == 0)
        {
            throw new IllegalArgumentException("The name cannot be empty");
        }
        this.name = name;
    }

    /**
     * Get the player's age in years
     * @return The age
     */
    public int getAge()
    {
        return age;
    }

    /**
     * Set the player's age in years
     * @param age
     *            The age
     * @throws IllegalArgumentException
     *             If the player's age is outside the allowed range
     */
    public void setAge(int age)
    {
        if (age < MIN_AGE)
        {
            throw new IllegalArgumentException(
            "The value " + age + " is not allowed. The player's age must be at least " + MIN_AGE);
        }
        this.age=age;
    }
}