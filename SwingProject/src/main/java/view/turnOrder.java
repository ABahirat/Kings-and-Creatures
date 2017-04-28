package view;
import javax.swing.*;
import model.character.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by vindi on 4/28/2017.
 */
public class turnOrder extends JPanel {


    public character activeChar;
    public JLabel activeCharLabel;
    public JButton mainButton;
    public JTextField txtdata;
    public JTextArea character_name;
    public JTextArea character_class;
    public JPanel upperPanel;
    public ArrayList<character> findCharacterList;
    public characterArrayIterator charIterator;
    private Container container;



    public turnOrder(characterArrayIterator charIterator){
        super(new BorderLayout());
        this.charIterator = charIterator;
        this.setBackground(Color.red);

        JPanel upperPanel = new JPanel();



        upperPanel.add(new JTextArea());

        this.character_name = new JTextArea(1, 6);
        upperPanel.add(character_name);

        this.character_class = new JTextArea(1, 6);
        upperPanel.add(character_class);


    }

    public void doEndTurnButton(JLabel label){


    }
/*
    public JButton addButton(String buttonText, JPanel panel){
        JButton showDialogButton = new JButton(buttonText);

        // add the listener to the jbutton to handle the "pressed" event
        showDialogButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

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
    } */

}
