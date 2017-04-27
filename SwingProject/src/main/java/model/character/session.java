package model.character;
import model.character.Player;
import model.character.character;
import java.util.*;
/**
 * Created by Peter on 4/25/2017.
 */
public class session {
    String name;
    String password;
    ArrayList<Player> playerList;
    ArrayList<room> map;

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
