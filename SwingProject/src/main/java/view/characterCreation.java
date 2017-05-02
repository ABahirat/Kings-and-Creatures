package view;

import model.character;
import model.characterArrayIterator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ameya on 4/27/17.
 */
public class characterCreation extends JFrame {

    public JFrame mainFrame;
    public JLabel mainLabel;
    public JPanel mainPanel;
    public JButton mainButton;
    public JButton nextButton;
    public JTextField txtdata;
    public JTextArea character_name;
    public JTextArea character_class;
    public JPanel jcharacterFrame;
    public characterArrayIterator iterator;


    public characterCreation(characterArrayIterator iterator){
        this.iterator = iterator;
        this.mainFrame = new JFrame("Kings and Creatures");
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setSize(512, 512);
        txtdata = new JTextField();
        mainFrame.add(txtdata);
        //character joe = new character("Joe", "Knight");
        //this.name = joe.getName();
        this.mainPanel = this.addPanel();
        this.mainLabel = this.addLabel("Hello There", this.mainPanel);
        this.mainButton = this.addButton("Create Character!", this.mainPanel);

        JPanel upperPanel = new JPanel();

        mainFrame.getContentPane().add(upperPanel, "North");
        //mainFrame.getContentPane().add(lowerPanel, "South");

        upperPanel.add(new JTextArea());

        this.character_name = new JTextArea("enter name", 1, 6);
        upperPanel.add(character_name);

        this.character_class = new JTextArea("enter class", 1, 6);
        upperPanel.add(character_class);

        mainFrame.pack();




        this.mainFrame.setVisible(true);
    }

    public void doButtonstuff(JLabel label){
        //label.setText(this.newname);
        //System.out.println(someString);
        String new_character_name = character_name.getText();
        String new_character_class = character_class.getText();
        character new_character = new character(new_character_name, new_character_class);
        iterator.addChar(new_character);
        System.out.println(iterator.display());
        //createdCharacters.add(new_character);
        label.setText("Welcome " + new_character.getName() + " the " + new_character.getCharClass() + "!");

    }


    /**** source: http://stackoverflow.com/questions/8248152/jframe-removing-jpanels-and-adding-a-new-jpanel *****/
    public void doNextButtonstuff(JPanel panel){
        getContentPane().removeAll();
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().revalidate();
        getContentPane().doLayout();
        getContentPane().repaint();
        update(getGraphics());
    }

    public JButton addButton(String buttonText, JPanel panel){
        JButton showDialogButton = new JButton(buttonText);


        // add the listener to the jbutton to handle the "pressed" event
        showDialogButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                characterCreation.this.doButtonstuff(characterCreation.this.mainLabel);
                mainButton.setVisible(false);
                nextButton = nextButton("Next", mainPanel);
                nextButton.setVisible(true);
            }

        });
        panel.add(showDialogButton);
        return showDialogButton;

    }

    public JButton nextButton(String buttonText, JPanel panel){
        JButton showDialogButton = new JButton(buttonText);

        // add the listener to the jbutton to handle the "pressed" event
        showDialogButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                jcharacterFrame = new characterFrame();
                characterCreation.this.doNextButtonstuff(jcharacterFrame);
                mainFrame.setVisible(false);

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

    public JPanel addPanel(){
        JPanel panel = new JPanel();

        this.mainFrame.add(panel);
        panel.setVisible(true);
        return panel;
    }


}