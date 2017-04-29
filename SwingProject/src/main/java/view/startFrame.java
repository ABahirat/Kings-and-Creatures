package view;

import model.character.Player;
import model.character.character;
import view.characterCreation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/**
 * Created by Ameya on 4/27/17.
 */
public class startFrame extends JFrame {

    public String name;
    public JFrame mainFrame;
    public String newname;
    public JLabel mainLabel;
    public JPanel mainPanel;
    public JButton mainButton;
    private JPanel jcharacterCreationFrame;

    public startFrame(){
        this.mainFrame = new JFrame("Kings and Creatures");
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setSize(512, 512);
        //character joe = new character("Joe", "Knight");
        //this.name = joe.getName();
        //this.mainLabel = this.addLabel("Hello There", this.mainPanel);
        this.mainButton = this.nextButton("Play as character", this.mainPanel);
        this.mainButton = this.nextButton("Play as DM (not implemented)", this.mainPanel);

        JPanel upperPanel = new JPanel();

        mainFrame.getContentPane().add(upperPanel, "North");
        //mainFrame.getContentPane().add(lowerPanel, "South");

        upperPanel.add(new JTextArea());


        mainFrame.pack();




        this.mainFrame.setVisible(true);
    }


    public void doNextButtonstuff(JPanel panel){
        getContentPane().removeAll();
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().revalidate();
        getContentPane().doLayout();
        getContentPane().repaint();
        update(getGraphics());
    }



    public JButton nextButton(String buttonText, JPanel panel){
        JButton showDialogButton = new JButton(buttonText);

        // add the listener to the jbutton to handle the "pressed" event
        showDialogButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                jcharacterCreationFrame = new characterFrame();
                //frameController frameCont = new frameController("string");
                startFrame.this.doNextButtonstuff(jcharacterCreationFrame);
                //frameCont.doNextButtonstuff(jcharacterCreationFrame);
                mainFrame.setVisible(false);
            }

        });
        panel.add(showDialogButton);
        return showDialogButton;

    }
}
