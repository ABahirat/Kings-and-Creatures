package view;

import model.character;
import controller.databaseProxy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.dungeonMaster;


/**
 * Created by vindi on 4/26/2017.
 */
public class frameController extends JFrame {

    public JFrame mainFrame;
    public String newname;
    public turnOrder turnOrderPanel;



    public frameController(String paramname, dungeonMaster dm){
        this.newname = paramname;
        this.mainFrame = new JFrame("Kings and Creatures");
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setSize(512, 512);
        character joe = new character("Joe", "Knight");
        character moe = new character("Moe", "Chef");
        this.turnOrderPanel = new turnOrder(dm);
        tradeDialogue tradeDialogue = new tradeDialogue(joe, moe);

        this.mainFrame.add(turnOrderPanel);
        this.mainFrame.setVisible(true);
    }



}
