
/**
 * Created by Peter on 4/24/2017.
 */
import model.characterArrayIterator;
import model.dungeonMaster;
import model.player;
import view.frameController;
import view.characterCreation;


public class kingsAndCreatures {


    public static void main(String args[]){

        dungeonMaster dm = new dungeonMaster("Azir");
        dm.addNPC("Grog");
        dm.addNPC("Blagnorz");
        dm.addNPC("Grog Junior");
        player player1 = new player();
        player player2 = new player("player2");
        player player3 = new player("player3");
        dm.activeSession.addPlayer(player1);
        dm.activeSession.addPlayer(player2);
        dm.activeSession.addPlayer(player3);
        dm.activeSession.setupchars(dm.npcList);
        //dm.activeSession.doturns();
        characterArrayIterator charIterator = dm.activeSession.makeIterator();
        frameController mainFrame = new frameController("Kings And Creatures", dm);





//    frameController mainFrame = new frameController("I am a changed String");
        characterCreation mainFrame2 = new characterCreation(charIterator);



    }
}

