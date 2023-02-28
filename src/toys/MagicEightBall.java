package toys;

import java.util.NoSuchElementException;
import java.util.Random;

/**
 * @author Addison Farley
 * @author Josh Archer
 * @version 1.0
 *
 * This class instantiates the Eight Ball for our game and offers a variety of commands to use.
 */
public class MagicEightBall
{
    private static final Random RANDOM = new Random();

    private String[] sides;
    private int messageIndex;

    /**
     * The Eight Ball constructor will throw specific errors to make sure our game can run as intended.
     *
     * @param sides A string array that has a message for each side of our Eight Ball
     * @param messageIndex The starting index for what message will be currently displayed
     */
    public MagicEightBall(String[] sides, int messageIndex)
    {
        if(sides.length < 1)
        {
            throw new NoSuchElementException("The amount of sides may not be less than 1");
        }
        else if (messageIndex < sides.length && messageIndex > sides.length)
        {
            throw new IndexOutOfBoundsException("The number given is out of bounds for the sides of the 8-ball");
        }

        this.sides = sides;
        this.messageIndex = messageIndex;
    }

    /**
     * Allows the Eight Ball to randomly change its shown message once
     * @return the new message currently shown
     */
    public String changeMessage()
    {
        //pick a random message index
        messageIndex = RANDOM.nextInt(sides.length);

        //return the message
        return sides[messageIndex];
    }

    /**
     * Allows the Eight Ball to change messages a set amount of times
     * @param times an integer telling the Eight Ball how many times to change messages
     * @return returns an array of each message shown after shaking
     */
    public String[] changeMessage(int times)
    {
        if(times < 0)
        {
            throw new IllegalArgumentException("A negative number cannot be used");
        }
        String[] results = new String[times];
        for (int i = 0; i < results.length; i++)
        {
            results[i] = changeMessage();
        }
        return results;
    }

    /**
     * Getter for sides
     * @return returns sides
     */
    public String[] getSides()
    {
        return sides;
    }

    /**
     * Setter for sides
     * @param sides this is an array of each message for the Eight Ball's sides
     */
    public void setSides(String[] sides)
    {
        if(sides.length == 0)
        {
            throw new NoSuchElementException("The amount of sides may not be less than 1");
        }
        this.sides = sides;
    }

    /**
     * Getter for the message index
     * @return returns messageIndex
     */
    public int getMessageIndex()
    {
        return messageIndex;
    }

    /**
     * Setter for message index
     * @param messageIndex an integer to determine which side will be showing on the Eight Ball
     */
    public void setMessageIndex(int messageIndex)
    {
        if (messageIndex < 0 || messageIndex > sides.length)
        {
            throw new IndexOutOfBoundsException("The number given is out of bounds for the sides of the 8-ball");
        }
        this.messageIndex = messageIndex;
    }

    /**
     * A to string method for the Eight Ball class
     * @return returns a string showing the Eight Ball and it's current showing side
     */
    public String toString()
    {
        String message = sides[messageIndex];
        return "Magic Eight Ball - " + message;
    }
}
