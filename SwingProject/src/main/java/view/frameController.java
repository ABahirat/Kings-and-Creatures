package view;

import model.character.character;
import controller.databaseProxy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.PipedOutputStream;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import model.character.*;


/**
 * Created by vindi on 4/26/2017.
 */
public class frameController extends JFrame {
    public String name;
    public JFrame mainFrame;
    public String newname;
    public JLabel mainLabel;
    public JPanel mainPanel;
    public JButton mainButton;
    public turnOrder turnOrderPanel;



    public frameController(String paramname, dungeonMaster dm){
        this.newname = paramname;
        this.mainFrame = new JFrame("Kings and Creatures");
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setSize(512, 512);
        character joe = new character("Joe", "Knight");
        this.turnOrderPanel = new turnOrder(dm);
//        tradeDialogue tradeDialogue = new tradeDialogue(joe, joe);
//        this.mainFrame.add(tradeDialogue);
        this.mainFrame.add(turnOrderPanel);
        //this.name = joe.getName();
        //this.mainPanel = this.addPanel(this.mainFrame);
        //this.mainLabel = this.addLabel("Hello There", this.mainPanel);
        //this.mainButton = this.addButton("I am a button", this.mainPanel);
        //character james = new character("james","god");
        //this.addLabel(james.Attack(joe),mainPanel);





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

    public void doNextButtonstuff(JPanel panel){
        getContentPane().removeAll();
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().revalidate();
        getContentPane().doLayout();
        getContentPane().repaint();
        update(getGraphics());
    }


    /**source: http://www.java2s.com/Code/Java/Swing-JFC/Reacttoframecloseaction.htm **/
    public class CloseFrameAction extends JFrame {
        public CloseFrameAction() {
            setTitle("CloseableFrame");
            setSize(300, 200);
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    String sql = "placeholder";//insert into database
                    databaseProxy mysqlConnect = new databaseProxy();
                    try {
                        PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
                    } catch (SQLException E) {
                        E.printStackTrace();
                    } finally {
                        mysqlConnect.disconnect();
                    }
                    System.exit(0);

                }
            });
        }
    }


}
