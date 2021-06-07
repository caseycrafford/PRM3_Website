/*
 * Lance Claude Kruger
 * 218159501
 * logIn.java
 * 7 June 2021
 * LogIn Page
 */
import java.io.*;
import javax.swing.JOptionPane;

public class User {
    private String email;
    private String username;
    private int cellphone;
    private String password;
    private String confirmPassword;

    public User(String email, String username, int cellphone, String password,String confirmPassword) {
        this.email = email;
        this.username = username;
        this.cellphone = cellphone;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public boolean isValidUser() {
        boolean valid = false;
        FileReader inFile = null;
        BufferedReader reader = null;
        String user, pass;

        try {
            inFile = new FileReader("users.txt");
            reader = new BufferedReader(inFile);

            user = reader.readLine();   // priming read
            while (user != null) {
                pass = reader.readLine();
                if (username.equals(user) && password.equals(pass)) {
                    valid = true;
                    break;
                }
                user = reader.readLine();   // secondary read
            }

            reader.close();
            inFile.close();
        }
        catch (IOException fe) {
            valid = false;
            JOptionPane.showMessageDialog(null, fe.getMessage());
        }

        return valid;
    }
}
