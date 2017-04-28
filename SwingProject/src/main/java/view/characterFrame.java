package view;

import model.character.Player;
import model.character.character;
import view.characterCreation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Ameya on 4/27/17.
 */
public class characterFrame {


        public String name;
        public JFrame mainFrame;
        public String newname;
        public JLabel mainLabel;
        public JPanel mainPanel;
        public JButton mainButton;
        public JTextField txtdata;
        public JTextArea character_name;
        public JTextArea character_class;
        public JPanel upperPanel;
        public ArrayList<character> findCharacterList;



        public characterFrame(String Character){
            findCharacterList = characterCreation.getCreatedCharacters();
            this.mainFrame = new JFrame(character.getCharacter(new_character).getName() + " the " + new_character.getCharClass());
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

            this.character_name = new JTextArea(1, 6);
            upperPanel.add(character_name);

            this.character_class = new JTextArea(1, 6);
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
            label.setText("Welcome " + new_character.getName() + " the " + new_character.getCharClass() + "!");

        }

        public JButton addButton(String buttonText, JPanel panel){
            JButton showDialogButton = new JButton(buttonText);

            // add the listener to the jbutton to handle the "pressed" event
            showDialogButton.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    view.characterFrame.this.doButtonstuff(view.characterFrame.this.mainLabel);
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

