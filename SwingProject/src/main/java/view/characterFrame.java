package view;

import controller.databaseProxy;
import model.character;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Ameya on 4/27/17.
 */
public class characterFrame extends JPanel{

        public JFrame mainFrame;
        public JLabel mainLabel;
        public JPanel mainPanel;
        public JButton mainButton;
        public JButton saveButton;
        public JTextField txtdata;
        public JTextArea character_name;
        public JTextArea character_class;



        public characterFrame(){

            this.mainFrame = new JFrame ("Character");
            this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.mainFrame.setSize(512, 512);
            txtdata = new JTextField();
            mainFrame.add(txtdata);

            this.mainPanel = this.addPanel();
            this.mainLabel = this.addLabel("Welcome to the character frame", this.mainPanel);
            this.mainButton = this.addButton("Character Frame", this.mainPanel);
            this.saveButton = this.SaveButton("Save", this.mainPanel);
            JPanel upperPanel = new JPanel();

            mainFrame.getContentPane().add(upperPanel, "North");


            upperPanel.add(new JTextArea());

            this.character_name = new JTextArea(1, 6);
            upperPanel.add(character_name);

            this.character_class = new JTextArea(1, 6);
            upperPanel.add(character_class);

            mainFrame.pack();


            this.mainFrame.setVisible(true);

        }

        public void doButtonstuff(JLabel label){

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

    public JButton SaveButton(String buttonText, JPanel panel){
        JButton showDialogButton = new JButton(buttonText);

        // add the listener to the jbutton to handle the "pressed" event
        showDialogButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String sql = "select * from `characters`";//insert into database
                databaseProxy mysqlConnect = new databaseProxy();
                try {
                    PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
                    System.out.println("Database Connected");
                } catch (SQLException E) {
                    System.out.println("ERROR");
                    E.printStackTrace();
                } finally {
                    mysqlConnect.disconnect();
                }

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

