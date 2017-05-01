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
 * Created by vindi on 4/29/2017.
 *
 */
public class tradeDialogue extends JPanel{


    private character charA;
    private character charB;
    private Item[] charAItems;
    private Item[] charBItems;
    private Item itemA;
    private Item itemB;
    private JComboBox<Item> tradeCharABox;
    private JComboBox<Item> tradeCharBBox;


    public tradeDialogue(character charA, character charB){

        super();
        JPanel mainPanel = new JPanel(new BorderLayout());
        //add charIterator
        this.charA = charA;
        this.charAItems = this.charA.getItemArray();
        this.charB = charB;
        this.charBItems = this.charB.getItemArray();





        //get activechar info

        JLabel tradeLabel = new JLabel();
        tradeLabel.setText("Trade Items: ");
        mainPanel.add(tradeLabel, BorderLayout.NORTH);


        //End turn and Save Buttons
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.LINE_AXIS));

        JButton confirmTradeButton = new JButton("Confirm Trade");
        // add the listener to the jbutton to handle the "pressed" event
        confirmTradeButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                tradeDialogue.this.charA.Trade(tradeDialogue.this.itemA, tradeDialogue.this.itemB, tradeDialogue.this.charB);
                tradeDialogue.this.charBItems = tradeDialogue.this.charB.getItemArray();
                tradeDialogue.this.charAItems = tradeDialogue.this.charA.getItemArray();
                //tradeDialogue.this.tradeCharABox = new JComboBox(tradeDialogue.this.charAItems);
                //tradeDialogue.this.tradeCharBBox = new JComboBox(tradeDialogue.this.charBItems);
            }

        });

      //  JButton cancelTradeButton = new JButton("Cancel Trade");
        // add the listener to the jbutton to handle the "pressed" event
        //confirmTradeButton.addActionListener(new ActionListener()
       // {
         //   public void actionPerformed(ActionEvent e)
           // {
         //       tradeDialogue.this.charA.Trade(tradeDialogue.this.itemA, tradeDialogue.this.itemB, tradeDialogue.this.charB);

        //    }

       // });

        southPanel.add(confirmTradeButton);
        //southPanel.add(cancelTradeButton);

        JButton saveButton = this.SaveButton("Save", southPanel);
        mainPanel.add(southPanel, BorderLayout.SOUTH);

        //Your Items

        DefaultComboBoxModel charAModel = new DefaultComboBoxModel(this.charAItems);
        JPanel charATrade = new JPanel(new BorderLayout());
        JLabel charATradeLabel = new JLabel();
        charATradeLabel.setText(charA.getName()+ "'s Items: ");
        charATrade.add(charATradeLabel, BorderLayout.NORTH);
        this.tradeCharABox = new JComboBox(this.charAItems);
        tradeCharABox.setRenderer(new itemListCellRenderer());
        tradeCharABox.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                tradeDialogue.this.itemA = ((Item) tradeDialogue.this.tradeCharABox.getSelectedItem());


            }
        });


        charATrade.add(this.tradeCharABox, BorderLayout.CENTER);
        mainPanel.add(charATrade, BorderLayout.WEST);

        //Their Items
        DefaultComboBoxModel charBModel = new DefaultComboBoxModel(this.charBItems);
        JPanel charBTrade = new JPanel(new BorderLayout());
        JLabel charBTradeLabel = new JLabel();
        charBTradeLabel.setText(charB.getName()+ "'s Items: ");
        charBTrade.add(charBTradeLabel, BorderLayout.NORTH);
        this.tradeCharBBox = new JComboBox(this.charBItems);
        tradeCharBBox.setRenderer(new itemListCellRenderer());
        tradeCharBBox.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                tradeDialogue.this.itemB = ((Item) tradeDialogue.this.tradeCharBBox.getSelectedItem());


            }
        });


        charBTrade.add(this.tradeCharBBox, BorderLayout.CENTER);
        mainPanel.add(charBTrade, BorderLayout.EAST);
        this.add(mainPanel);
        mainPanel.setVisible(true);
        this.setVisible(true);
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
}
