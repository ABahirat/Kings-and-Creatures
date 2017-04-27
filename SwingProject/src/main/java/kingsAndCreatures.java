/**
 * Created by Peter on 4/24/2017.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import model.character.character;


public class kingsAndCreatures {
    static String name;

    public static void doButtonstuff(JLabel label){
        label.setText("I am now a changed string");
        //System.out.println(someString);
    }

    public static void main(String args[]){
        String mystring = "I am a string";
        JFrame mainFrame = new JFrame("Kings and Creatures");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(512, 512);

        JPanel panel = new JPanel();



        character joe = new character("Joe", "Knight");
        name = joe.getName();
        final JLabel joename = new JLabel(name);
        joename.setText(name);
        panel.add(joename);
        // create our jbutton
        JButton showDialogButton = new JButton("Click Me");

        // add the listener to the jbutton to handle the "pressed" event
        showDialogButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                doButtonstuff(joename);
            }
        });
        panel.add(showDialogButton);
        joename.setVisible(true);
        mainFrame.add(panel);

        character james = new character("james","theif");

        JLabel attack = new JLabel(james.Attack(joe));
        panel.add(attack);
        mainFrame.setVisible(true);




    }
}
