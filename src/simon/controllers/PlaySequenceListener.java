/**
 * 
 */
package simon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.Timer;

import simon.models.Button;
import simon.models.Colour;

/**
 * @author Zac
 *
 */
public class PlaySequenceListener implements ActionListener {

    private Timer timer = new Timer(1000, this);
    private GameController controller;
    private Iterator<Colour> iter;
    private Button button;
    private boolean on;
    private int delay;

    public PlaySequenceListener(GameController controller) {
        this.controller = controller;
    }

    public void resetListener() {
        this.iter = controller.getApp().getNewSequenceIterator();
        this.on = true;
        this.delay = controller.getApp().getSpeed();
        this.timer.setDelay(delay);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (on) {
            on = false;
            timer.setDelay(200); // ensure there is a short indication between two same colour
            if (iter.hasNext()) { // safe check
                highlightButton(iter.next());
            } else {
                System.out.println("stop");
                controller.setBusy(false);
                timer.stop();
            }
        } else {
            on = true;
            timer.setDelay(delay);
            unhighlightButton();
        }
    }

    public void start() {
        timer.start();
    }

    private void highlightButton(Colour c) {
        for (Button btn : controller.getColourButtons()) {
            if (c.equals(btn.getColour())) { // loop through buttons to find the one with the right colour
                System.out.println(".");
                btn.getButton().setBackground(btn.getBackgroundColour());
                button = btn;
            }
        }
    }

    private void unhighlightButton() {
        if (button != null) { // safe check
            button.getButton().setBackground(null);
        }
    }

}
