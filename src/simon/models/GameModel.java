/**
 * 
 */
package simon.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import simon.models.Colour.Keys;

/**
 * @author Zac
 *
 */
public class GameModel {

    private static final ArrayList<Integer> SPEED = new ArrayList<Integer>(Arrays.asList(700, 1000, 1400));
    private static final int FASTEST_SPEED = 300;

    private ArrayList<Colour> gameSequence;
    private Iterator<Colour> iter;
    private int roundscore;
    private int highscore;
    private int counter;
    private int speed;
    private int initialNumber;
    private int initialSpeed;

    public GameModel() {
        gameSequence = new ArrayList<Colour>();
    }

    public int getRoundscore() {
        return this.roundscore;
    }

    public void setRoundscore(int score) {
        this.roundscore = score;
    }

    public void incrementRoundScore() {
        this.roundscore++;
    }

    public int getHighscore() {
        return this.highscore;
    }

    public void setHighscore(int score) {
        this.highscore = score;
    }

    public void updateHighScore() {
        if (getRoundscore() > getHighscore()) { // only update highscore when the roundscore is larger
            setHighscore(getRoundscore());
        }
    }

    public int getCounter() {
        return this.counter;
    }

    public void setCounter(int i) {
        this.counter = i;
    }

    public void incrementCounter() {
        this.counter++;
    }

    public int getInitialSpeed() {
        return this.initialSpeed;
    }

    public void setInitialSpeed(int index) {
        try {
            this.initialSpeed = SPEED.get(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bound. Setting default speed...");
            this.initialSpeed = SPEED.get(1); // default to normal speed
        }
    }

    public int getSpeed() {
        return this.speed;
    }

    public void speedUp() {
        if (getSpeed() > FASTEST_SPEED) {
            this.speed -= 100;
        } else {
            this.speed = FASTEST_SPEED;
        }
    }

    public void resetSpeed() {
        this.speed = getInitialSpeed();
    }

    public int getInitialNumber() {
        return initialNumber;
    }

    public void setInitialNumber(int initialNumber) {
        if (initialNumber >= 1 && initialNumber <= 5) {
            this.initialNumber = initialNumber;
        } else {
            System.out.println("Initial number of buttons is out of valid range (1-5).");
            this.initialNumber = 1; // set to default initial sequence number
        }
    }

    public Colour getRandomColour() {
        return Colour.getColour(Keys.getRandomKey());
    }

    public void addSequence(ArrayList<Colour> sequence, Colour colour) {
        sequence.add(colour);
    }

    public void addOneToGameSequence() {
        addSequence(getSequence(), getRandomColour());
    }

    public void clearSequence() {
        gameSequence.clear();
    }

    public ArrayList<Colour> getSequence() {
        return this.gameSequence;
    }

    public Iterator<Colour> getIter() {
        return this.iter;
    }

    public Iterator<Colour> getNewSequenceIterator() {
        return getSequence().iterator();
    }

    public void resetIter() {
        this.iter = getNewSequenceIterator();
    }

}
