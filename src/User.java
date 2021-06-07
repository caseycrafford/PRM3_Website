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
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
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
