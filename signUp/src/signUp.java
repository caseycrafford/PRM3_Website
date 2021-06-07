/*
 * Lance Claude Kruger
 * 218159501
 * logIn.java
 * 7 June 2021
 * LogIn Page
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class signUp extends JFrame implements ActionListener {
    private JPanel panelNorth, panelSouth;
    private JLabel lblEmail;
    private JTextField txtEmail;
    private JLabel lblUsername;
    private JTextField txtUsername;
    private JLabel lblPassword;
    private JPasswordField txtPassword;
    private JLabel lblPhone;
    private JTextField txtPhone;
    private JLabel lblConfirmPassword;
    private JPasswordField txtConfirmPassword;
    private JButton btnLogin, btnSignUp, btnExit;
    private Font ft;

    public signUp() {
        super("User Authentication");
        panelNorth = new JPanel();
        panelSouth = new JPanel();
        lblEmail = new JLabel("Email: ");
        txtEmail = new JTextField();
        lblUsername = new JLabel("Username: ");
        txtUsername = new JTextField();
        lblPhone = new JLabel("Cellphone: ");
        txtPhone = new JTextField();
        lblPassword = new JLabel("Password: ");
        txtPassword = new JPasswordField();
        lblConfirmPassword = new JLabel("Confirm Password: ");
        txtConfirmPassword = new JPasswordField();
        btnSignUp = new JButton("SignUp");
        btnLogin = new JButton("Go to Login");
        btnExit = new JButton("Exit");
        ft = new Font("Arial", Font.PLAIN, 24);
    }

    public void setGUI() {
        panelNorth.setLayout(new GridLayout(2, 2));
        panelSouth.setLayout(new GridLayout(1, 3));

        lblEmail.setFont(ft);
        txtEmail.setFont(ft);
        lblUsername.setFont(ft);
        txtUsername.setFont(ft);
        lblPassword.setFont(ft);
        txtPassword.setFont(ft);
        btnLogin.setFont(ft);
        btnSignUp.setFont(ft);
        btnExit.setFont(ft);

        panelNorth.add(lblUsername);
        panelNorth.add(txtUsername);
        panelNorth.add(lblPassword);
        panelNorth.add(txtPassword);
        panelSouth.add(btnLogin);
        panelSouth.add(btnSignUp);
        panelSouth.add(btnExit);

        this.add(panelNorth, BorderLayout.NORTH);
        this.add(panelSouth, BorderLayout.SOUTH);

        btnLogin.addActionListener(this);
        btnSignUp.addActionListener(this);
        btnExit.addActionListener(this);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Login")) {
            User u = new User(txtUsername.getText(), txtPassword.getText(), txtPhone.getText(), txtConfirmPassword.getText());
            if (u.isValidUser()) {
                JOptionPane.showMessageDialog(null, "Welcome. Login successful!");
            }
            else {
                JOptionPane.showMessageDialog(null, "Invalid user");
            }
        }
        else if (e.getActionCommand().equals("Reset")) {
            txtUsername.setText("");
            txtPassword.setText("");
            txtUsername.requestFocus();
        }
        else if (e.getActionCommand().equals("Exit")) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new signUp().setGUI();
    }
}
