/**
 * 
 */
package simon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Zac
 *
 */
public class GameEngine {
    // /**
    // * PSEUDOCODE
    // * counter
    // * array to store sequence
    // *
    // * loop through array to show sequence
    // *
    // * ask user input (another counter) or use a loop
    // * check sequence
    // * if true {next loop} else {break loop and set lose to true}
    // * if (no lose) {add one random to sequence} else {lose game and break}
    // */
    private Scanner userInput = new Scanner(System.in);
    private int score;
    private int highscore;

    public static void main(String[] args) {
        GameEngine engine = new GameEngine();
        engine.play();
    }

    public void play() {
        boolean running = true;
        while (running) {
            score = newRound();
            highscore = score > highscore ? score : highscore;
            System.out.println("Your highscore is " + highscore);
            System.out.println("Play again? (Y/N)");
            running = userInput.next().equalsIgnoreCase("y");
        }
        System.out.println("end game");
    }

    public int newRound() {
        int counter = 0;
        ArrayList<Integer> sequence = new ArrayList<Integer>();

        sequence.add(getRandInt());
        sequence.add(getRandInt());

        while (true) {
            System.out.println("round " + (++counter));
            sequence.add(getRandInt());

            Iterator<Integer> iter = sequence.iterator();

            Timer printer = new Timer();
            TimerTask task = new TimerTask() {
                public void run() {
                    if (iter.hasNext()) {
                        System.out.println(iter.next());
                    } else {
                        System.out.println("cancel");
                        printer.cancel();
                    }
                }
            };

            printer.schedule(task, 0, 1000);

            try {
                Thread.sleep(1000 * sequence.size() + 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            boolean wrong = false;
            for (Integer num : sequence) {
                System.out.print("Input: ");
                int input = userInput.nextInt();
                if (input != num) {
                    wrong = true;
                    break;
                }
            }
            System.out.println(wrong ? "you lose" : "next sequence");
            if (wrong)
                break;
        }
        System.out.println("Your score is " + (--counter));
        return counter;
    }

    public int getRandInt() {
        Random r = new Random();
        return r.nextInt(4) + 1;
    }

}

// Timer animator = new Timer();
// animator.schedule(new TimerTask() {
// public void run() {
// System.out.println("Hi");
// }
// }, 0, 1000);

// Timer timer = new Timer();
// TimerTask abort = new TimerTask() {
// public void run() {
// animator.cancel();
// timer.cancel();
// System.out.println("cancel");
// }
// };
// timer.schedule(abort, 5 * 1000);