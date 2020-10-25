/**
 * 
 */
package simon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Timer;

import simon.models.Colour;
import simon.models.GameModel;
import simon.models.Colour.COLOUR;
import simon.views.Button;
import simon.views.GameWindow;

/**
 * @author Zac
 *
 */
public class GameWindowController {

    private GameModel app;
    private GameWindow view;
    private IGameState currentState = new GameLockedState();
    Timer backgroundTimer;
    // private Iterator<COLOUR> iter;
    PlaySequenceListener sequencePlayer;
    private boolean busy = true;
    private int counter;
    private int speed = 1000;

    public GameWindowController(GameModel app, GameWindow view) {
        this.setApp(app);
        this.setView(view);
        this.sequencePlayer = new PlaySequenceListener(this);
    }

    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    public GameWindow getView() {
        return view;
    }

    public void setView(GameWindow view) {
        this.view = view;
    }

    public GameModel getApp() {
        return app;
    }

    public void setApp(GameModel app) {
        this.app = app;
    }

    public int getCounter() {
        return this.counter;
    }

    public void setCounter(int i) {
        this.counter = i;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void speedUp() {
        this.speed -= 100;
    }

    public void resetSpeed() {
        this.speed = 1000;
    }

    public ArrayList<Button> getColourButtons() {
        return this.view.getColourButtons();
    }

    // public Iterator<COLOUR> getNewIter() {
    // return app.getNewSequenceIterator();
    // }

    // public Iterator<COLOUR> getIter() {
    // return this.iter;
    // }

    // public void resetIter() {
    // this.iter = getNewIter();
    // }

    public void checkState() {
        this.currentState.play(this);
    }

    public void setState(IGameState state) {
        this.currentState = state;
    }

    public void control() {
        controlStart();
        controlExit();
        controlButton();
        controlState();
    }

    public void operate() {
        setBusy(true);
        newRound();
    }

    public void newRound() {
        setCounter(0);
        resetSpeed();
        app.setRoundscore(0);
        updateScore();
        app.clearSequences();
        app.addOneToGameSequence();
        playSequence();
        app.resetIter();
    }

    public void nextLevel() {
        setCounter(0);
        app.setRoundscore(app.getRoundscore() + 1);
        updateScore();
        app.addOneToGameSequence();
        speedUp();
        playSequence();
        app.resetIter();
    }

    public void playSequence() {
        setBusy(true);
        sequencePlayer.resetListener();
        sequencePlayer.start();
    }

    public void respond(COLOUR colour) {
        setCounter(getCounter() + 1);
        System.out.println("respond " + getCounter());
        boolean match = false;
        if (app.getIter().hasNext()) { // safe check
            match = Colour.compareColour(app.getIter().next(), colour);
            if (match) {
                if (!app.getIter().hasNext()) {
                    System.out.println("next level");
                    nextLevel();
                }
            } else {
                System.out.println("not match");
                closeRound();
            }
        }
    }

    public void closeRound() {
        setBusy(true);
        app.setHighscore(app.getRoundscore());
        updateScore();
        view.setMessage("You lose. Play again?");
        view.getBtnStart().setText("Play again");
        view.getBtnStart().setEnabled(true);
    }

    public void updateScore() {
        view.setRoundScore(Integer.toString(app.getRoundscore()));
        view.setHighScore(Integer.toString(app.getHighscore()));
    }

    public void controlButton() {
        for (Button button : view.getColourButtons()) {
            button.addActionListener(new ColorButtonListener(this, button));
        }
    }

    public void controlStart() {
        view.getBtnStart().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                view.setMessage("Playing...");
                view.getBtnStart().setText("Play");
                view.getBtnStart().setEnabled(false);
                operate();
            }

        });
    }

    public void controlExit() {
        view.getBtnExit().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                backgroundTimer.stop();
                view.getFrame().dispose();
            }

        });
    }

    public void controlState() {
        ActionListener taskPerformer = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                checkState();
            }

        };
        backgroundTimer = new Timer(100, taskPerformer);
        backgroundTimer.start();
    }

}
