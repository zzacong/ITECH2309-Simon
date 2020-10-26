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

    private static final ArrayList<Integer> SPEED = new ArrayList<Integer>(Arrays.asList(800, 1000, 1400));

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
        if (getRoundscore() > getHighscore()) {
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
        this.initialSpeed = SPEED.get(index);
    }

    public int getSpeed() {
        return this.speed;
    }

    public void speedUp() {
        this.speed -= 100;
    }

    public void resetSpeed() {
        this.speed = getInitialSpeed();
    }

    public int getInitialNumber() {
        return initialNumber;
    }

    public void setInitialNumber(int initialNumber) {
        this.initialNumber = initialNumber;
    }

    public Colour getRandomColour() {
        return Colour.getColour(Keys.getRandomKey());
    }

    public void addOneToGameSequence() {
        gameSequence.add(getRandomColour());
    }

    public void clearSequence() {
        gameSequence.clear();
    }

    public ArrayList<Colour> getSequence() {
        return this.gameSequence;
    }

    public Iterator<Colour> getNewSequenceIterator() {
        return getSequence().iterator();
    }

    public Iterator<Colour> getIter() {
        return this.iter;
    }

    public void resetIter() {
        this.iter = getNewSequenceIterator();
    }
}
