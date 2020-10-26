/**
 * 
 */
package simon.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

/**
 * @author Zac
 *
 */
public class GameWindow {

    private JFrame frame;
    private JLabel lblMessage;
    private JTextField txtRoundScore;
    private JTextField txtHighScore;
    private Button btnGreen;
    private Button btnRed;
    private Button btnBlue;
    private Button btnYellow;
    private JButton btnPlay;
    private JButton btnExit;
    private JButton btnStart;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GameWindow window = new GameWindow();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public GameWindow() {
        initialize();
    }

    /**
     * Initialize the details of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setResizable(false);
        frame.setTitle("Game Window");
        frame.setBounds(100, 100, 450, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));
        this.fillWindow();
        frame.setVisible(true);
    }

    /**
     * Initialize content of frame.
     */
    public void fillWindow() {
        JPanel mainPanel = new JPanel(new GridBagLayout());
        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);

        JPanel titlePanel = new JPanel();
        GridBagConstraints gbc_titlePanel = new GridBagConstraints();
        gbc_titlePanel.fill = GridBagConstraints.BOTH;
        gbc_titlePanel.gridx = 0;
        gbc_titlePanel.gridy = 0;
        gbc_titlePanel.insets = new Insets(20, 0, 10, 0);
        mainPanel.add(titlePanel, gbc_titlePanel);

        JLabel lblTitle = new JLabel("Simon Game");
        lblTitle.setFont(new Font("Lucida Grande", Font.BOLD, 20));
        GridBagConstraints gbc_lblTitle = new GridBagConstraints();
        gbc_lblTitle.gridx = 0;
        gbc_lblTitle.gridy = 0;
        titlePanel.add(BorderLayout.CENTER, lblTitle);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc_buttonPanel = new GridBagConstraints();
        gbc_buttonPanel.insets = new Insets(10, 0, 10, 0);
        gbc_buttonPanel.ipady = 40;
        gbc_buttonPanel.weighty = 1.0;
        gbc_buttonPanel.fill = GridBagConstraints.BOTH;
        gbc_buttonPanel.gridx = 0;
        gbc_buttonPanel.gridy = 1;
        mainPanel.add(buttonPanel, gbc_buttonPanel);

        btnGreen = new GreenButton();
        btnGreen.setOpaque(true);
        GridBagConstraints gbc_btnGreen = new GridBagConstraints();
        gbc_btnGreen.insets = new Insets(10, 10, 10, 10);
        gbc_btnGreen.gridx = 0;
        gbc_btnGreen.gridy = 0;
        buttonPanel.add(btnGreen, gbc_btnGreen);

        btnRed = new RedButton();
        btnRed.setOpaque(true);
        GridBagConstraints gbc_btnRed = new GridBagConstraints();
        gbc_btnRed.insets = new Insets(10, 10, 10, 10);
        gbc_btnRed.gridx = 1;
        gbc_btnRed.gridy = 0;
        buttonPanel.add(btnRed, gbc_btnRed);

        btnYellow = new YellowButton();
        btnYellow.setOpaque(true);
        GridBagConstraints gbc_btnYellow = new GridBagConstraints();
        gbc_btnYellow.insets = new Insets(10, 10, 10, 10);
        gbc_btnYellow.gridx = 0;
        gbc_btnYellow.gridy = 1;
        buttonPanel.add(btnYellow, gbc_btnYellow);

        btnBlue = new BlueButton();
        btnBlue.setOpaque(true);
        GridBagConstraints gbc_btnBlue = new GridBagConstraints();
        gbc_btnBlue.insets = new Insets(10, 10, 10, 10);
        gbc_btnBlue.fill = GridBagConstraints.NONE;
        gbc_btnBlue.gridx = 1;
        gbc_btnBlue.gridy = 1;
        buttonPanel.add(btnBlue, gbc_btnBlue);

        JPanel scorePanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc_scorePanel = new GridBagConstraints();
        gbc_scorePanel.insets = new Insets(10, 0, 10, 0);
        gbc_scorePanel.fill = GridBagConstraints.BOTH;
        gbc_scorePanel.gridx = 0;
        gbc_scorePanel.gridy = 2;
        mainPanel.add(scorePanel, gbc_scorePanel);

        JLabel lblCurrentScore = new JLabel("Score: ");
        lblCurrentScore.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
        GridBagConstraints gbc_lblCurrentScore = new GridBagConstraints();
        gbc_lblCurrentScore.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblCurrentScore.anchor = GridBagConstraints.LINE_START;
        gbc_lblCurrentScore.insets = new Insets(0, 0, 5, 20);
        gbc_lblCurrentScore.gridx = 0;
        gbc_lblCurrentScore.gridy = 0;
        scorePanel.add(lblCurrentScore, gbc_lblCurrentScore);

        JLabel lblHighScore = new JLabel("High Score: ");
        lblHighScore.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
        GridBagConstraints gbc_lblHighScore = new GridBagConstraints();
        gbc_lblHighScore.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblHighScore.anchor = GridBagConstraints.LINE_START;
        gbc_lblHighScore.insets = new Insets(0, 0, 5, 20);
        gbc_lblHighScore.gridx = 0;
        gbc_lblHighScore.gridy = 1;
        scorePanel.add(lblHighScore, gbc_lblHighScore);

        txtRoundScore = new JTextField("0");
        txtRoundScore.setHorizontalAlignment(SwingConstants.RIGHT);
        txtRoundScore.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
        txtRoundScore.setEditable(false);
        GridBagConstraints gbc_txtCurrentScore = new GridBagConstraints();
        gbc_txtCurrentScore.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtCurrentScore.insets = new Insets(0, 0, 5, 0);
        gbc_txtCurrentScore.gridx = 1;
        gbc_txtCurrentScore.gridy = 0;
        scorePanel.add(txtRoundScore, gbc_txtCurrentScore);
        txtRoundScore.setColumns(10);

        txtHighScore = new JTextField("0");
        txtHighScore.setHorizontalAlignment(SwingConstants.RIGHT);
        txtHighScore.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
        txtHighScore.setEditable(false);
        GridBagConstraints gbc_txtHighScore = new GridBagConstraints();
        gbc_txtHighScore.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtHighScore.insets = new Insets(0, 0, 5, 0);
        gbc_txtHighScore.gridx = 1;
        gbc_txtHighScore.gridy = 1;
        scorePanel.add(txtHighScore, gbc_txtHighScore);
        txtHighScore.setColumns(10);

        lblMessage = new JLabel("Press Play to start the game!");
        lblMessage.setFont(new Font("Lucida Grande", Font.BOLD, 14));
        GridBagConstraints gbc_lblMessage = new GridBagConstraints();
        gbc_lblMessage.gridwidth = 2;
        gbc_lblMessage.insets = new Insets(20, 0, 0, 0);
        gbc_lblMessage.gridx = 0;
        gbc_lblMessage.gridy = 2;
        scorePanel.add(lblMessage, gbc_lblMessage);
        JPanel controlPanel = new JPanel();
        GridBagConstraints gbc_controlPanel = new GridBagConstraints();
        gbc_controlPanel.insets = new Insets(10, 0, 20, 0);
        gbc_controlPanel.gridx = 0;
        gbc_controlPanel.gridy = 3;
        mainPanel.add(controlPanel, gbc_controlPanel);
        FlowLayout fl_controlPanel = new FlowLayout(FlowLayout.CENTER, 20, 0);
        controlPanel.setLayout(fl_controlPanel);

        btnStart = new JButton("Start Game");
        controlPanel.add(btnStart);

        btnPlay = new JButton("Play");
        btnPlay.setEnabled(false);
        controlPanel.add(btnPlay);

        btnExit = new JButton("Exit");
        controlPanel.add(btnExit);

    }

    public Button getBtnGreen() {
        return this.btnGreen;
    }

    public Button getBtnRed() {
        return this.btnRed;
    }

    public Button getBtnBlue() {
        return this.btnBlue;
    }

    public Button getBtnYellow() {
        return this.btnYellow;
    }

    public JButton getBtnStart() {
        return this.btnStart;
    }

    public JButton getBtnPlay() {
        return this.btnPlay;
    }

    public JButton getBtnExit() {
        return this.btnExit;
    }

    public ArrayList<Button> getColourButtons() {
        return new ArrayList<Button>(Arrays.asList(getBtnGreen(), getBtnRed(), getBtnBlue(), getBtnYellow()));
    }

    public void setMessage(String msg) {
        this.lblMessage.setText(msg);
    }

    public void setHighScore(String score) {
        this.txtHighScore.setText(score);
    }

    public void setRoundScore(String score) {
        this.txtRoundScore.setText(score);
    }

    public JFrame getFrame() {
        return this.frame;
    }
}
