package program;

import toys.MagicEightBall;
import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * This is an entry point into our Eight Ball game.
 *
 * @author Addison Farley
 * @author Josh Archer
 * @version 1.0
 *
 * @
 */
public class Main
{
    /**
     * This starts our game and will ask the user for the following traits for their Eight Ball: the amount of sides,
     * the messages on each side, the starting index of the Eight Ball, and the amount of times they wish to
     * shake the Eight Ball. Once finished, the program will print out an array of each message shown as the ball
     * was shaken. If there are any exceptions thrown, the code below is meant to handle them without the
     * game terminating.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args)
    {
        //ask the user for 5 messages
        int messages;
        Console console = new Console();
        boolean finished = false;

        while(!finished)
        {
            try {
                messages = console.getInt("How many sides would you like?");

                String[] sides = new String[messages];

                for (int i = 0; i < sides.length; i++) {
                    sides[i] = console.getString("Enter a message");
                }

                //create the magic eight-ball and test it
                MagicEightBall eightBall = new MagicEightBall(sides, sides.length);

                int startIndex = console.getInt("Please choose a starting index");

                eightBall.setMessageIndex(startIndex);

                int shakes = console.getInt("Amount of shakes");

                console.println("Shaking ball " + shakes + " times\n" + Arrays.toString(eightBall.changeMessage(shakes)));

                finished = true;
            }
            catch (NoSuchElementException e)
            {
                console.println("The amount of sides may not be less than 1");
            }
            catch (IndexOutOfBoundsException e)
            {
                console.println("The number given is out of bounds for the sides of the 8-ball");
            }
            catch (IllegalArgumentException e)
            {
                console.println("You cannot shake the ball a negative amount of times");
            }
        }
    }
}