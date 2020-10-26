/**
 * 
 */
package simon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.Timer;

import simon.models.Colour;

import simon.views.Button;

/**
 * @author Zac
 *
 */
public class PlaySequenceListener implements ActionListener {

    private Timer timer = new Timer(1000, this);
    private GameWindowController controller;
    private Iterator<Colour> iter;
    private Button button;
    private boolean on;

    public PlaySequenceListener(GameWindowController controller) {
        this.controller = controller;
    }

    public void resetListener() {
        this.iter = controller.getApp().getNewSequenceIterator();
        timer.setDelay(controller.getSpeed());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (on) {
            on = false;
            timer.setDelay(200);
            if (iter.hasNext()) { // safe check
                highlightButton(iter.next());
            } else {
                System.out.println("stop");
                controller.setBusy(false);
                timer.stop();
            }
        } else {
            on = true;
            timer.setDelay(controller.getSpeed());
            unhighlightButton();
        }
    }

    public void start() {
        timer.start();
    }

    private void highlightButton(Colour c) {
        for (Button btn : controller.getColourButtons()) {
            if (c.equals(btn.getColour())) {
                System.out.println(".");
                btn.setBackground(btn.getBackgroundColour());
                button = btn;
            }
        }
    }

    private void unhighlightButton() {
        if (button != null) {
            button.setBackground(null);
        }
    }

}
