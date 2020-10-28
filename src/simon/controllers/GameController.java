/**
 * 
 */
package simon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.Timer;

import simon.models.BlueButton;
import simon.models.Button;
import simon.models.Colour;
import simon.models.GameModel;
import simon.models.GreenButton;
import simon.models.RedButton;
import simon.models.YellowButton;
import simon.views.ConfigWindow;
import simon.views.GameWindow;

/**
 * @author Zac
 *
 */
public class GameController implements Controller {

    private GameModel app;
    private GameWindow view;
    private ConfigWindow configWindow = new ConfigWindow();
    private ConfigController config = new ConfigController(configWindow, this);
    private IGameState currentState = new GameBusyState();
    private Timer backgroundTimer;
    private PlaySequenceListener sequencePlayer;
    private ArrayList<Button> colourButtons = new ArrayList<Button>();
    private boolean busy = true;

    public GameController(GameModel app, GameWindow view) {
        this.setApp(app);
        this.setView(view);
        this.sequencePlayer = new PlaySequenceListener(this);
        config.control();
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

    public ArrayList<Button> getColourButtons() {
        return this.colourButtons;
    }

    public void checkState() {
        this.currentState.play(this);
    }

    public void setState(IGameState state) {
        this.currentState = state;
    }

    public void newRound() {
        app.setCounter(0);
        app.resetSpeed();
        app.setRoundscore(0);
        updateScoreBoard();
        app.clearSequence();
        for (int i = 0; i < app.getInitialNumber(); i++) {
            app.addOneToGameSequence();
        }
        playSequence();
        app.resetIter();
    }

    public void nextLevel() {
        app.setCounter(0);
        app.incrementRoundScore();
        updateScoreBoard();
        app.addOneToGameSequence();
        app.speedUp();
        playSequence();
        app.resetIter();
    }

    public void playSequence() {
        setBusy(true);
        sequencePlayer.resetListener();
        sequencePlayer.start();
    }

    public void respond(Colour colour) {
        app.incrementCounter();
        System.out.println("respond " + app.getCounter());
        boolean match = false;
        if (app.getIter().hasNext()) { // safe check
            match = colour.equals(app.getIter().next());
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
        if (app.getInitialNumber() > 0 && app.getRoundscore() > 0) {
            app.setRoundscore(app.getRoundscore() + app.getInitialNumber() - 1);
        }
        app.updateHighScore();
        updateScoreBoard();
        config.addRow(app.getRoundscore());
        view.setMessage("You lose. Play again?");
        view.getBtnStart().setText("Play again");
        readyToPlay(false);
    }

    public void updateScoreBoard() {
        view.setRoundScore(Integer.toString(app.getRoundscore()));
        view.setHighScore(Integer.toString(app.getHighscore()));
    }

    public void readyToPlay(boolean ready) {
        view.getBtnStart().setEnabled(!ready);
        view.getBtnPlay().setEnabled(ready);
    }

    @Override
    public void control() {
        controlStart();
        controlExit();
        controlPlay();
        controlButton();
        controlState();
    }

    public void controlButton() {
        int i = 0;
        for (JButton btn : view.getColourButtons()) {
            Button button = null;
            switch (i) {
                case 0:
                    button = new GreenButton(btn);
                    break;
                case 1:
                    button = new RedButton(btn);
                    break;
                case 2:
                    button = new YellowButton(btn);
                    break;
                case 3:
                    button = new BlueButton(btn);
                    break;
            }
            getColourButtons().add(button);
            btn.addActionListener(new ColorButtonListener(this, button));
            i++;
        }
    }

    public void controlStart() {
        view.getBtnStart().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                view.getBtnStart().setEnabled(false);
                config.showFrame();
            }

        });
    }

    public void controlPlay() {
        view.getBtnPlay().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                view.setMessage("Playing...");
                view.getBtnPlay().setEnabled(false);
                newRound();
            }

        });
    }

    public void controlExit() {
        view.getBtnExit().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                backgroundTimer.stop();
                view.getFrame().dispose();
                config.dispose();
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
