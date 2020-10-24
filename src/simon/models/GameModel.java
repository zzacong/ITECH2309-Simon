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

    private Scanner userInput = new Scanner(System.in);
    private int score;
    private int roundscore;
    private int highscore;

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

    public void play() {
        boolean running = true;
        while (running) {
            newRound();
            setHighscore(score > getHighscore() ? score : getHighscore());
            System.out.println("Your highscore is " + highscore);
            System.out.println("Play again? (Y/N)");
            running = userInput.next().equalsIgnoreCase("y");
        }
        System.out.println("end game");
    }

    public void newRound() {
        int counter = 0;
        clearSequences();

        addSequence(gameSequence, getRandomColour());
        addSequence(gameSequence, getRandomColour());

        boolean yes = true;
        while (true) {
            if (yes) {
                yes = false;

                System.out.println("round " + (++counter));
                addSequence(gameSequence, getRandomColour());

                Iterator<COLOUR> iter = gameSequence.iterator();

                // playSequenceListener = new PlaySequenceListener(iter);
                // playSequenceListener.start();
                System.out.println("started");
                // playSequence();

                // Timer printer = new Timer();
                // TimerTask task = new TimerTask() {
                // public void run() {
                // if (iter.hasNext()) {
                // System.out.println(iter.next());
                // } else {
                // System.out.println("cancel");
                // printer.cancel();
                // }
                // }
                // };

                // printer.schedule(task, 0, 1000);

                // try {
                // Thread.sleep(1000 * gameSequence.size() + 500);
                // } catch (InterruptedException e) {
                // e.printStackTrace();
                // }

                // boolean wrong = false;
                // for (Colour colour : gameSequence) {
                // Colour input = colour;
                // System.out.println("Input: " + input);
                // if (input != colour) {
                // wrong = true;
                // break;
                // }
                // }
                // System.out.println(wrong ? "you lose" : "next sequence");
                // if (wrong)
                // break;
            }
        }
        // setRoundscore(--counter);
        // System.out.println("Your score is " + getRoundscore());
    }

    public int getRandInt() {
        Random r = new Random();
        return r.nextInt(4) + 1;
    }

    public COLOUR getRandomColour() {
        Random r = new Random();
        return Colour.getColour(r.nextInt(4));
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

    public void playSequence() {
        Iterator<COLOUR> iter = gameSequence.iterator();
        // playSequenceListener = new PlaySequenceListener(iter);
    }

    public COLOUR getNextSequence() {
        Iterator<COLOUR> iter = gameSequence.iterator();
        return iter.hasNext() ? iter.next() : null;
    }

    public int getSequenceSize() {
        return this.gameSequence.size();
    }

    public ArrayList<COLOUR> getSequence() {
        return this.gameSequence;
    }
}
