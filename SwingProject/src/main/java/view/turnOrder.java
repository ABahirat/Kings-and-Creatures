package view;
import javax.swing.*;

import controller.databaseProxy;
import model.character.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by vindi on 4/28/2017.
 */
public class turnOrder extends JPanel {


    public character activeChar;
    public JLabel activeCharLabel;


    public characterArrayIterator charIterator;

    private JLabel attackResult;
    private JComboBox<character> attackCharBox;
    private JComboBox<character> tradeCharBox;



    public turnOrder(dungeonMaster dm){

        //set layout
        super(new BorderLayout());
        //add charIterator
        this.charIterator = dm.activeSession.getIterator();
        this.setBackground(Color.green);

        //get activechar info
        this.activeChar = dm.activeSession.getIterator().getCurrent();

        this.activeCharLabel = new JLabel();
        this.activeCharLabel.setText(this.activeChar.getName()+ "'s Turn");
        this.add(activeCharLabel, BorderLayout.NORTH);


        //End turn and Save Buttons
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.LINE_AXIS));

        JButton endTurnButton = new JButton("End Turn");
        // add the listener to the jbutton to handle the "pressed" event
        endTurnButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                turnOrder.this.doEndTurnButton(turnOrder.this.activeCharLabel);
            }

        });

        southPanel.add(endTurnButton);

        JButton saveButton = this.SaveButton("Save", southPanel);
        this.add(southPanel, BorderLayout.SOUTH);

        //Attack Combobox
        this.attackResult = new JLabel();
        this.attackResult.setText("");

        JPanel attack = new JPanel(new BorderLayout());
        JLabel attackLabel = new JLabel();
        attackLabel.setText("Attack: (Select Character)");
        attack.add(attackLabel, BorderLayout.NORTH);
        this.attackCharBox = new JComboBox(this.charIterator.getCharArray());
        attackCharBox.setRenderer(new charListCellRenderer());
        attackCharBox.addActionListener( new ActionListener(){
           public void actionPerformed(ActionEvent e){
               String result = turnOrder.this.activeChar.Attack((character) turnOrder.this.attackCharBox.getSelectedItem());
               turnOrder.this.attackResult.setText(result);

           }
        });

        attack.add(this.attackResult, BorderLayout.SOUTH);
        attack.add(this.attackCharBox, BorderLayout.CENTER);
        this.add(attack, BorderLayout.WEST);

        JPanel trade = new JPanel(new BorderLayout());
        JLabel tradeLabel = new JLabel();
        tradeLabel.setText("Trade With: (Select Character)");
        trade.add(tradeLabel, BorderLayout.NORTH);
        this.tradeCharBox = new JComboBox(this.charIterator.getCharArray());
        tradeCharBox.setRenderer(new charListCellRenderer());
        tradeCharBox.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //Open trade dialogue
                tradeDialogue tradeDia = new tradeDialogue(turnOrder.this.activeChar, ((character) turnOrder.this.tradeCharBox.getSelectedItem()));
                tradeDia.setVisible(true);

    }
});


        trade.add(this.tradeCharBox, BorderLayout.CENTER);
        this.add(trade, BorderLayout.EAST);











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
                //System.exit(0);
            }

        });
        panel.add(showDialogButton, BorderLayout.SOUTH);
        return showDialogButton;

    }

    public void doEndTurnButton(JLabel activeCharLabel){
        //this.attackResult.setText("");
        this.charIterator.next();
        this.activeChar = this.charIterator.getCurrent();
        this.setActiveCharText(activeCharLabel);

    }

    public void setActiveCharText(JLabel activeCharLabel){
        activeCharLabel.setText(this.activeChar.getName() + "'s Turn");
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
