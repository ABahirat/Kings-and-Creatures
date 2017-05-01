
package model;
import java.util.*;
/**
 * Created by Peter on 4/25/2017.
 */
public class session {
    String name;
    String password;
    ArrayList<player> playerList;
    characterArrayIterator characterIterator;

    public session(){
        this.name = "Game";
        this.password = "Game";
        this.playerList = new ArrayList<player>();
        this.characterIterator = this.makeIterator();

    }

    public characterArrayIterator makeIterator(){
        return new characterArrayIterator();
    }

    public characterArrayIterator getIterator(){
        return this.characterIterator;
    }

    public void setupchars(ArrayList<character> npcs){
        this.characterIterator.addAllPlayerChars(this.playerList);
        this.characterIterator.addNPCs(npcs);
    }

    public String getName() {
        return name;
    }

    public void addPlayer(player player){
        playerList.add(player);
    }
}

