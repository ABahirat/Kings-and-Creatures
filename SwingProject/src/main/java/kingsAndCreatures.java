/**
 * Created by Peter on 4/24/2017.
 */
import javax.swing.*;

import model.character.character;


public class kingsAndCreatures {


    public static void main(String args[]){
        String mystring = "I am a string";
        JFrame mainFrame = new JFrame("Kings and Creatures");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(512, 512);
        mainFrame.setVisible(true);
        JPanel panel = new JPanel();

        character joe = new character("Joe", "Knight");
        String name = joe.getName();
        JLabel joename = new JLabel(name);
        joename.setText(name);
        panel.add(joename);
        joename.setVisible(true);
        mainFrame.add(panel);


    }
}
