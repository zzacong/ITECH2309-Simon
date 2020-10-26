/**
 * 
 */
package simon.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import simon.models.Colour.Keys;

/**
 * @author Zac
 *
 */
public class GameModel {

    private ArrayList<Colour> gameSequence;

    private int roundscore;
    private int highscore;
    private Iterator<Colour> iter;

    public GameModel() {
        gameSequence = new ArrayList<Colour>();
    }

    public int getRoundscore() {
        return this.roundscore;
    }

    public void setRoundscore(int score) {
        this.roundscore = score;
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

    public int getRandInt() {
        Random r = new Random();
        return r.nextInt(4);
    }

    public Colour getRandomColour() {
        return Colour.getColour(Keys.getRandomKey());
    }

    public void addSequence(ArrayList<Colour> sequence, Colour color) {
        sequence.add(color);
    }

    public void addOneToGameSequence() {
        this.addSequence(getSequence(), getRandomColour());
    }

    public void clearSequences() {
        gameSequence.clear();
    }

    // public Colour getNextSequence() {
    // Iterator<Colour> iter = gameSequence.iterator();
    // return iter.hasNext() ? iter.next() : null;
    // }

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
