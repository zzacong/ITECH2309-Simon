/**
 * 
 */
package simon.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Zac
 *
 */
public class GameWindow {

    private JFrame frmGameWindow;
    private JTextField txtCurrentScore;
    private JTextField txtHighScore;

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
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmGameWindow = new JFrame();
        frmGameWindow.setTitle("Game Window");
        frmGameWindow.setResizable(false);
        frmGameWindow.setBounds(100, 100, 450, 300);
        frmGameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        GridBagLayout gbl_mainPanel = new GridBagLayout();
        gbl_mainPanel.rowWeights = new double[]{0.0, 0.0, 0.0};
        gbl_mainPanel.columnWeights = new double[]{1.0};
        JPanel mainPanel = new JPanel(gbl_mainPanel);
        frmGameWindow.getContentPane().add(mainPanel, BorderLayout.CENTER);

        JPanel titlePanel = new JPanel();
        GridBagConstraints gbc_titlePanel = new GridBagConstraints();
        gbc_titlePanel.fill = GridBagConstraints.BOTH;
        gbc_titlePanel.gridx = 0;
        gbc_titlePanel.gridy = 0;
        gbc_titlePanel.insets = new Insets(10, 0, 20, 0);
        mainPanel.add(titlePanel, gbc_titlePanel);
        
        JLabel lblTitle = new JLabel("Simon Game");
        lblTitle.setFont(new Font("Lucida Grande", Font.BOLD, 20));
        GridBagConstraints gbc_lblTitle = new GridBagConstraints();
        gbc_lblTitle.gridx = 0;
        gbc_lblTitle.gridy = 0;
        titlePanel.add(BorderLayout.CENTER, lblTitle);
        
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc_buttonPanel = new GridBagConstraints();
        gbc_buttonPanel.fill = GridBagConstraints.BOTH;
        gbc_buttonPanel.gridx = 0;
        gbc_buttonPanel.gridy = 1;
        mainPanel.add(buttonPanel, gbc_buttonPanel);
        
        JButton btnGreen = new JButton("GREEN");
        btnGreen.setOpaque(true);
        btnGreen.setBackground(Color.GREEN);
        GridBagConstraints gbc_btnGreen = new GridBagConstraints();
        gbc_btnGreen.ipadx = 10;
        gbc_btnGreen.ipady = 10;
        gbc_btnGreen.insets = new Insets(10, 10, 10, 10);
        gbc_btnGreen.gridx = 0;
        gbc_btnGreen.gridy = 0;
        buttonPanel.add(btnGreen, gbc_btnGreen);
        
        JButton btnRed = new JButton("RED");
        btnRed.setOpaque(true);
        btnRed.setBackground(Color.RED);
        GridBagConstraints gbc_btnRed = new GridBagConstraints();
        gbc_btnRed.ipady = 10;
        gbc_btnRed.ipadx = 20;
        gbc_btnRed.insets = new Insets(10, 10, 10, 10);
        gbc_btnRed.gridx = 1;
        gbc_btnRed.gridy = 0;
        buttonPanel.add(btnRed, gbc_btnRed);
        
        JButton btnYellow = new JButton("YELLOW");
        btnYellow.setOpaque(true);
        btnYellow.setBackground(Color.YELLOW);
        GridBagConstraints gbc_btnYellow = new GridBagConstraints();
        gbc_btnYellow.ipady = 10;
        gbc_btnYellow.ipadx = 4;
        gbc_btnYellow.insets = new Insets(10, 10, 10, 10);
        gbc_btnYellow.gridx = 0;
        gbc_btnYellow.gridy = 1;
        buttonPanel.add(btnYellow, gbc_btnYellow);
        
        JButton btnBlue = new JButton("BLUE");
        btnBlue.setOpaque(true);
        btnBlue.setBackground(Color.BLUE);
        GridBagConstraints gbc_btnBlue = new GridBagConstraints();
        gbc_btnBlue.ipady = 10;
        gbc_btnBlue.ipadx = 20;
        gbc_btnBlue.insets = new Insets(10, 10, 10, 10);
        gbc_btnBlue.fill = GridBagConstraints.NONE;
        gbc_btnBlue.gridx = 1;
        gbc_btnBlue.gridy = 1;
        buttonPanel.add(btnBlue, gbc_btnBlue);
        
        JPanel scorePanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc_scorePanel = new GridBagConstraints();
        gbc_scorePanel.insets = new Insets(0, 0, 20, 0);
        gbc_scorePanel.ipady = 20;
        gbc_scorePanel.fill = GridBagConstraints.BOTH;
        gbc_scorePanel.gridx = 0;
        gbc_scorePanel.gridy = 2;
        mainPanel.add(scorePanel, gbc_scorePanel);
        
        JLabel lblCurrentScore = new JLabel("Score: ");
        lblCurrentScore.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        GridBagConstraints gbc_lblCurrentScore = new GridBagConstraints();
        gbc_lblCurrentScore.anchor = GridBagConstraints.LINE_START;
        gbc_lblCurrentScore.insets = new Insets(0, 0, 10, 0);
        gbc_lblCurrentScore.gridx = 0;
        gbc_lblCurrentScore.gridy = 0;
        scorePanel.add(lblCurrentScore, gbc_lblCurrentScore);
        
        JLabel lblHighScore = new JLabel("High Score: ");
        lblHighScore.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        GridBagConstraints gbc_lblHighScore = new GridBagConstraints();
        gbc_lblHighScore.anchor = GridBagConstraints.LINE_START;
        gbc_lblHighScore.insets = new Insets(0, 0, 5, 20);
        gbc_lblHighScore.gridx = 0;
        gbc_lblHighScore.gridy = 1;
        scorePanel.add(lblHighScore, gbc_lblHighScore);
        
        txtCurrentScore = new JTextField();
        txtCurrentScore.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
        txtCurrentScore.setEditable(false);
        GridBagConstraints gbc_txtCurrentScore = new GridBagConstraints();
        gbc_txtCurrentScore.insets = new Insets(0, 0, 10, 0);
        gbc_txtCurrentScore.gridx = 1;
        gbc_txtCurrentScore.gridy = 0;
        scorePanel.add(txtCurrentScore, gbc_txtCurrentScore);
        txtCurrentScore.setColumns(10);
        
        txtHighScore = new JTextField();
        txtHighScore.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
        txtHighScore.setEditable(false);
        GridBagConstraints gbc_txtHighScore = new GridBagConstraints();
        gbc_txtHighScore.gridx = 1;
        gbc_txtHighScore.gridy = 1;
        scorePanel.add(txtHighScore, gbc_txtHighScore);
        txtHighScore.setColumns(10);
        
        frmGameWindow.setVisible(true);
    }

}
