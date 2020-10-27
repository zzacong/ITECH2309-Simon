package simon.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ConfigWindow {

    private JFrame frame;
    private TableLeadership tableLeadership;
    private JTextField txtName;
    private JComboBox<String> cbxSpeed;
    private JComboBox<Integer> cbxButtonNumber;
    private JLabel lblMessage;
    private JButton btnCancel;
    private JButton btnConfirm;

    /**
     * Create the application.
     */
    public ConfigWindow() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Configuration Window");
        frame.setBounds(100, 100, 450, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));
        this.fillWindow();
    }

    public void fillWindow() {
        GridBagLayout gbl_mainPanel = new GridBagLayout();
        gbl_mainPanel.rowWeights = new double[] { 0.0, 0.0, 0.0 };
        gbl_mainPanel.columnWeights = new double[] { 1.0 };
        JPanel mainPanel = new JPanel(gbl_mainPanel);
        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);

        GridBagLayout gbl_leadershipPanel = new GridBagLayout();
        gbl_leadershipPanel.rowWeights = new double[] { 0.0, 1.0 };
        gbl_leadershipPanel.columnWeights = new double[] { 1.0 };
        JPanel leadershipPanel = new JPanel(gbl_leadershipPanel);
        GridBagConstraints gbc_leadershipPanel = new GridBagConstraints();
        gbc_leadershipPanel.weighty = 1.0;
        gbc_leadershipPanel.insets = new Insets(20, 0, 10, 0);
        gbc_leadershipPanel.fill = GridBagConstraints.BOTH;
        gbc_leadershipPanel.gridx = 0;
        gbc_leadershipPanel.gridy = 0;
        mainPanel.add(leadershipPanel, gbc_leadershipPanel);

        JLabel lblLeadership = new JLabel("Leadership Board");
        lblLeadership.setFont(new Font("Lucida Grande", Font.BOLD, 20));
        lblLeadership.setHorizontalAlignment(SwingConstants.CENTER);
        GridBagConstraints gbc_lblLeadership = new GridBagConstraints();
        gbc_lblLeadership.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblLeadership.insets = new Insets(0, 0, 20, 0);
        gbc_lblLeadership.gridx = 0;
        gbc_lblLeadership.gridy = 0;
        leadershipPanel.add(lblLeadership, gbc_lblLeadership);

        tableLeadership = new TableLeadership();

        JScrollPane scrollPane = new JScrollPane(tableLeadership);
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.insets = new Insets(0, 40, 10, 40);
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.gridx = 0;
        gbc_scrollPane.gridy = 1;
        leadershipPanel.add(scrollPane, gbc_scrollPane);

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc_inputPanel = new GridBagConstraints();
        gbc_inputPanel.insets = new Insets(10, 0, 10, 0);
        gbc_inputPanel.fill = GridBagConstraints.BOTH;
        gbc_inputPanel.gridx = 0;
        gbc_inputPanel.gridy = 1;
        mainPanel.add(inputPanel, gbc_inputPanel);

        JLabel lblName = new JLabel("Enter your name: ");
        GridBagConstraints gbc_lblName = new GridBagConstraints();
        gbc_lblName.anchor = GridBagConstraints.LINE_START;
        gbc_lblName.insets = new Insets(0, 0, 10, 5);
        gbc_lblName.gridx = 0;
        gbc_lblName.gridy = 0;
        inputPanel.add(lblName, gbc_lblName);

        txtName = new JTextField();
        GridBagConstraints gbc_txtName = new GridBagConstraints();
        gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtName.insets = new Insets(0, 0, 10, 0);
        gbc_txtName.gridx = 1;
        gbc_txtName.gridy = 0;
        inputPanel.add(txtName, gbc_txtName);
        txtName.setColumns(10);

        JLabel lblSpeed = new JLabel("Initial game speed: ");
        GridBagConstraints gbc_lblSpeed = new GridBagConstraints();
        gbc_lblSpeed.anchor = GridBagConstraints.LINE_START;
        gbc_lblSpeed.insets = new Insets(0, 0, 10, 5);
        gbc_lblSpeed.gridx = 0;
        gbc_lblSpeed.gridy = 1;
        inputPanel.add(lblSpeed, gbc_lblSpeed);

        cbxSpeed = new JComboBox<String>();
        cbxSpeed.setModel(new DefaultComboBoxModel<String>(new String[] { "Fast", "Normal", "Slow" }));
        cbxSpeed.setToolTipText("Set initial speed...");
        GridBagConstraints gbc_cbxSpeed = new GridBagConstraints();
        gbc_cbxSpeed.insets = new Insets(0, 0, 10, 0);
        gbc_cbxSpeed.fill = GridBagConstraints.HORIZONTAL;
        gbc_cbxSpeed.gridx = 1;
        gbc_cbxSpeed.gridy = 1;
        inputPanel.add(cbxSpeed, gbc_cbxSpeed);

        JLabel lblButtonNumber = new JLabel("Initial no. of buttons: ");
        GridBagConstraints gbc_lblButtonNumber = new GridBagConstraints();
        gbc_lblButtonNumber.anchor = GridBagConstraints.LINE_START;
        gbc_lblButtonNumber.insets = new Insets(0, 0, 10, 5);
        gbc_lblButtonNumber.gridx = 0;
        gbc_lblButtonNumber.gridy = 2;
        inputPanel.add(lblButtonNumber, gbc_lblButtonNumber);

        cbxButtonNumber = new JComboBox<Integer>();
        cbxButtonNumber.setModel(new DefaultComboBoxModel<Integer>(new Integer[] { 1, 2, 3, 4, 5 }));
        cbxButtonNumber.setToolTipText("Set initial number of buttons...");
        GridBagConstraints gbc_cbxButtonNumber = new GridBagConstraints();
        gbc_cbxButtonNumber.insets = new Insets(0, 0, 10, 0);
        gbc_cbxButtonNumber.fill = GridBagConstraints.HORIZONTAL;
        gbc_cbxButtonNumber.gridx = 1;
        gbc_cbxButtonNumber.gridy = 2;
        inputPanel.add(cbxButtonNumber, gbc_cbxButtonNumber);

        lblMessage = new JLabel("Please enter your name.");
        lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
        lblMessage.setForeground(Color.RED);
        lblMessage.setVisible(false);
        GridBagConstraints gbc_lblMessage = new GridBagConstraints();
        gbc_lblMessage.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblMessage.gridwidth = 2;
        gbc_lblMessage.insets = new Insets(0, 0, 10, 0);
        gbc_lblMessage.gridx = 0;
        gbc_lblMessage.gridy = 3;
        inputPanel.add(lblMessage, gbc_lblMessage);

        JPanel controlPanel = new JPanel();
        FlowLayout flowLayout = (FlowLayout) controlPanel.getLayout();
        flowLayout.setHgap(20);
        GridBagConstraints gbc_controlPanel = new GridBagConstraints();
        gbc_controlPanel.insets = new Insets(10, 0, 20, 0);
        gbc_controlPanel.fill = GridBagConstraints.HORIZONTAL;
        gbc_controlPanel.gridx = 0;
        gbc_controlPanel.gridy = 2;
        mainPanel.add(controlPanel, gbc_controlPanel);

        btnCancel = new JButton("Cancel");
        controlPanel.add(btnCancel);

        btnConfirm = new JButton("Confirm");
        controlPanel.add(btnConfirm);
    }

    public TableLeadership getTableLeadership() {
        return this.tableLeadership;
    }

    public JTextField getTxtName() {
        return this.txtName;
    }

    public JComboBox<String> getCbxSpeed() {
        return this.cbxSpeed;
    }

    public JComboBox<Integer> getCbxButtonNumber() {
        return this.cbxButtonNumber;
    }

    public JLabel getLblMessage() {
        return this.lblMessage;
    }

    public JButton getBtnConfirm() {
        return this.btnConfirm;
    }

    public JButton getBtnCancel() {
        return this.btnCancel;
    }

    public JFrame getFrame() {
        return this.frame;
    }

}
