
package model.character;
import java.util.*;
/**
 * Created by Peter on 4/25/2017.
 */
public class session {
    String name;
    String password;
    ArrayList<Player> playerList;
    dungeonMaster DM;
    ArrayList<room> map;
    characterArrayIterator characterIterator;

    public session(){
        this.name = "Game";
        this.password = "Game";
        this.playerList = new ArrayList<Player>();
        this.characterIterator = this.makeIterator();

    }
    public void doturns(){
        this.characterIterator.next();
        this.characterIterator.next();
        this.characterIterator.next();
        this.characterIterator.next();
        this.characterIterator.next();
        this.characterIterator.next();
        this.characterIterator.next();
        this.characterIterator.next();
    }

    public characterArrayIterator makeIterator(){
        return new characterArrayIterator();
    }

    public void setupchars(ArrayList<character> npcs){
        this.characterIterator.addAllPlayerChars(this.playerList);
        this.characterIterator.addNPCs(npcs);
    }
    public void generateTurnOrder(){
        Collections.shuffle(this.playerList);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }

    public void setMap(ArrayList<room> map) {
        this.map = map;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public ArrayList<room> getMap() {
        return map;
    }

    public void addPlayer(Player Player){
        playerList.add(Player);
    }
}

