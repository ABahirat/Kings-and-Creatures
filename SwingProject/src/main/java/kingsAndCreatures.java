
/**
 * Created by Peter on 4/24/2017.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import view.frameController;
import view.startFrame;
import view.characterCreation;


import model.character.character;
import model.character.*;


public class kingsAndCreatures {


    public static void main(String args[]){

        dungeonMaster dm = new dungeonMaster("Azir");
        dm.addNPC("Grog");
        dm.addNPC("Blagnorz");
        dm.addNPC("Grog Junior");
        Player player1 = new Player();
        Player player2 = new Player("player2");
        Player player3 = new Player("player3");
        dm.activeSession.addPlayer(player1);
        dm.activeSession.addPlayer(player2);
        dm.activeSession.addPlayer(player3);
        dm.activeSession.setupchars(dm.npcList);
        dm.activeSession.doturns();




    //frameController mainFrame = new frameController("I am a changed String");
    characterCreation mainFrame = new characterCreation();



    }
}

