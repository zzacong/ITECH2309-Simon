/**
 * 
 */
package simon.models;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
// import java.util.Timer;
// import java.util.TimerTask;

import javax.swing.Timer;

import simon.controllers.PlaySequenceListener;
import simon.models.Colour.COLOUR;

/**
 * @author Zac
 *
 */
public class GameModel {

    private ArrayList<COLOUR> gameSequence;

    private int roundscore;
    private int highscore;
    private Iterator<COLOUR> iter;

    public GameModel() {
        gameSequence = new ArrayList<COLOUR>();
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

    public int getRandInt() {
        Random r = new Random();
        return r.nextInt(4);
    }

    public COLOUR getRandomColour() {
        return Colour.getColour(getRandInt());
    }

    public void addSequence(ArrayList<COLOUR> sequence, COLOUR color) {
        sequence.add(color);
    }

    public void addOneToGameSequence() {
        this.addSequence(getSequence(), getRandomColour());
    }

    public void clearSequences() {
        gameSequence.clear();
    }

    // public COLOUR getNextSequence() {
    // Iterator<COLOUR> iter = gameSequence.iterator();
    // return iter.hasNext() ? iter.next() : null;
    // }

    public ArrayList<COLOUR> getSequence() {
        return this.gameSequence;
    }

    public Iterator<COLOUR> getNewSequenceIterator() {
        return getSequence().iterator();
    }

    public Iterator<COLOUR> getIter() {
        return this.iter;
    }

    public void resetIter() {
        this.iter = getNewSequenceIterator();
    }
}
