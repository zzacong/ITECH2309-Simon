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
public class ConfigWindowController implements Controller {

    private ConfigWindow view;
    private GameWindowController game;
    private String playerName;

    public ConfigWindowController(ConfigWindow view, GameWindowController game) {
        this.view = view;
        this.game = game;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void showFrame() {
        triggerError(false);
        view.getTxtName().setText(null);
        view.getFrame().setVisible(true);
    }

    public boolean validateInput() {
        return validateName();
    }

    public boolean validateName() {
        if (view.getTxtName().getText().isBlank()) {
            triggerError(true);
            return false;
        }
        triggerError(false);
        return true;
    }

    public void triggerError(boolean trigger) {
        if (trigger) {
            view.getTxtName().setBackground(new Color(255, 153, 153));
            view.getLblMessage().setVisible(true);
        } else {
            view.getTxtName().setBackground(Color.WHITE);
            view.getLblMessage().setVisible(false);
        }
    }

    public void addRow(int score) {
        Object[] row = { getPlayerName(), score };
        view.getTableLeadership().addRow(row);
    }

    @Override
    public void control() {
        controlConfirm();
        controlCancel();
    }

    public void controlConfirm() {
        view.getBtnConfirm().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateInput()) {
                    String name = view.getTxtName().getText();
                    int speed = (int) ((view.getCbxSpeed().getSelectedIndex() + 1) * 0.6 * 1000);
                    int number = (int) view.getCbxButtonNumber().getSelectedItem();
                    System.out.println(name);
                    System.out.println(speed);
                    System.out.println(number);

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

            @Override
            public void actionPerformed(ActionEvent e) {
                game.readyToPlay(false);
                view.getFrame().setVisible(false);
            }

        });
    }

}
