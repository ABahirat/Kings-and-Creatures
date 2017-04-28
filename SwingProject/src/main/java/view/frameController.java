package view;

import model.character.character;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by vindi on 4/26/2017.
 */
public class frameController {
    public String name;
    public JFrame mainFrame;
    public String newname;
    public JLabel mainLabel;
    public JPanel mainPanel;
    public JButton mainButton;



    public frameController(String paramname){
        this.newname = paramname;
        this.mainFrame = new JFrame("Kings and Creatures");
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setSize(512, 512);
        character joe = new character("Joe", "Knight");
        this.name = joe.getName();
        this.mainPanel = this.addPanel(this.mainFrame);
        this.mainLabel = this.addLabel("Hello There", this.mainPanel);
        this.mainButton = this.addButton("I am a button", this.mainPanel);




        this.mainFrame.setVisible(true);
    }




    public void doButtonstuff(JLabel label){
//        label.setText(this.newname);
        //System.out.println(someString);
        JFrame secondFrame = new JFrame("Second");
        JPanel secondPanel = this.addPanel(secondFrame);
        this.addLabel("this is the second frame",secondPanel);
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        secondFrame.add(secondPanel);
        secondFrame.setSize(500,500);
        secondFrame.setVisible(true);
        this.mainFrame.setVisible(false);
    }

    public JButton addButton(String buttonText, JPanel panel){
        JButton showDialogButton = new JButton(buttonText);

        // add the listener to the jbutton to handle the "pressed" event
        showDialogButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                frameController.this.doButtonstuff(frameController.this.mainLabel);
            }

        });
        panel.add(showDialogButton);
        return showDialogButton;

    }

    public JLabel addLabel(String text, JPanel panel){
        JLabel myLabel = new JLabel();
        myLabel.setText(text);
        panel.add(myLabel);
        return myLabel;



    }

    public JPanel addPanel(JFrame frame){
        JPanel panel = new JPanel();

        frame.add(panel);
        panel.setVisible(true);
        return panel;
    }


}
