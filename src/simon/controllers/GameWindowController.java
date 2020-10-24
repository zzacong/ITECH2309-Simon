/**
 * 
 */
package simon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Iterator;

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
    private boolean busy;
    private boolean stillRunning;
    private Iterator<COLOUR> iter;
    private int counter;

    public GameWindowController(GameModel app, GameWindow view) {
        this.setApp(app);
        this.setView(view);
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

    public boolean getStillRunning() {
        return this.stillRunning;
    }

    public void setStillRunning(boolean b) {
        this.stillRunning = b;
    }

    public int getCounter() {
        return this.counter;
    }

    public void setCounter(int i) {
        this.counter = i;
    }

    public ArrayList<Button> getButtons() {
        return this.view.getColourButtons();
    }

    public Iterator<COLOUR> getNewIter() {
        return app.getSequence().iterator();
    }

    public Iterator<COLOUR> getIter() {
        return this.iter;
    }

    public void resetIter() {
        this.iter = getNewIter();
    }

    public void checkState() {
        this.currentState.play(this);
    }

    public void setState(IGameState state) {
        this.currentState = state;
    }

    public void control() {
        controlWindow();
        controlStart();
        controlExit();
        controlButton();
    }

    public void operate() {

        newRound();
        // setStillRunning(true);
        // while (getStillRunning()) {
        // boolean run = true;
        // boolean robot = true;
        // boolean player = false;
        // if (robot) {
        // robot = false;
        // playSequence();
        // }
        // if (player) {

        // }
        // if (!getStillRunning()) {
        // break;
        // }
        // }
    }

    public void newRound() {
        setCounter(0);
        app.setRoundscore(0);
        app.clearSequences();
        app.addOneToGameSequence();
        playSequence();
        resetIter();
    }

    public void nextLevel() {
        setCounter(0);
        app.setRoundscore(app.getRoundscore() + 1);
        updateScore();
        app.addOneToGameSequence();
        playSequence();
        resetIter();
    }

    public void playSequence() {
        PlaySequenceListener p = new PlaySequenceListener(this);
        p.start();
    }

    public void respond(COLOUR colour) {
        System.out.println("respond");
        boolean match = true;
        if (getCounter() < app.getSequenceSize()) {
            System.out.println("smaller");
            if (getIter().hasNext()) {
                System.out.println("has next");
                match = Colour.compareColour(getIter().next(), colour);
            }
            if (!match) {
                System.out.println("not match");
                closeRound();
            }
            setCounter(getCounter() + 1);
            if (getCounter() >= app.getSequenceSize()) {
                System.out.println("next level");
                nextLevel();
            }
        } else {
            System.out.println("larger");
            nextLevel();
        }
    }

    public void closeRound() {
        app.setHighscore(app.getRoundscore());
        updateScore();
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
                view.getBtnStart().setText("Start");
                view.getBtnStart().setEnabled(false);
                operate();
            }

        });
    }

    public void controlExit() {
        view.getBtnExit().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                view.getFrame().dispose();
            }

        });
    }

    public void controlWindow() {
        view.getFrame().addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void windowClosing(WindowEvent e) {
                // TODO Auto-generated method stub
                setStillRunning(false);
            }

            @Override
            public void windowClosed(WindowEvent e) {
                // TODO Auto-generated method stub
                setStillRunning(false);
            }

            @Override
            public void windowIconified(WindowEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void windowActivated(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                // TODO Auto-generated method stub
            }

        });
    }

}

// * show sequence
// * loop {
// * get user selection
// * check sequence
// * }