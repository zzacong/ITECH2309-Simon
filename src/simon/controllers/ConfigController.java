/**
 * 
 */
package simon.controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import simon.views.ConfigWindow;

/**
 * @author Zac
 *
 */
public class ConfigController implements Controller {

    private ConfigWindow view;
    private GameController game;
    private String playerName;

    public ConfigController(ConfigWindow view, GameController game) {
        this.view = view;
        this.game = game;
    }

    @Override
    public void control() {
        controlConfirm();
        controlCancel();
    }

    public void controlConfirm() {
        view.getBtnConfirm().addActionListener(new ActionListener() {
            // Validate input
            // Read config settings
            // Set config settings
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateInput()) {
                    String name = view.getTxtName().getText();
                    int speed = view.getCbxSpeed().getSelectedIndex();
                    int number = (int) view.getCbxButtonNumber().getSelectedItem();

                    setPlayerName(name);
                    game.getApp().setInitialSpeed(speed);
                    game.getApp().setInitialNumber(number);
                    game.readyToPlay(true);

                    view.getFrame().setVisible(false);
                }
            }

        });
    }

    public void controlCancel() {
        view.getBtnCancel().addActionListener(new ActionListener() {
            // Enable the play Button on GameWindow and close this window
            @Override
            public void actionPerformed(ActionEvent e) {
                game.readyToPlay(false);
                view.getFrame().setVisible(false);
            }

        });
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    // Show the confuguration window and set the fields back to initial state
    public void showFrame() {
        triggerError(false);
        view.getTxtName().setText(null);
        view.getFrame().setVisible(true);
    }

    // Easily extensible is more validation need to be done
    public boolean validateInput() {
        return validateName();
    }

    // Check if player has entered name
    public boolean validateName() {
        if (view.getTxtName().getText().isEmpty()) {
            triggerError(true);
            return false;
        }
        triggerError(false);
        return true;
    }

    // Control display of error message
    public void triggerError(boolean trigger) {
        if (trigger) {
            view.getTxtName().setBackground(new Color(255, 153, 153));
            view.getLblMessage().setVisible(true);
        } else {
            view.getTxtName().setBackground(Color.WHITE);
            view.getLblMessage().setVisible(false);
        }
    }

    // Add a row to the highscore board
    public void addRow(int score) {
        Object[] row = { getPlayerName(), score };
        view.getTableLeadership().addRow(row);
    }

    // Dispose the configuration window
    public void dispose() {
        view.getFrame().dispose();
    }

}
