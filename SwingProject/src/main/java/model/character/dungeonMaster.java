
package model.character;
import java.util.*;
/**
 * Created by vindi on 4/25/2017.
 */
public class dungeonMaster extends user{
    public ArrayList<session> sessionList;
    public session activeSession;
    public ArrayList<character> npcList;



    public dungeonMaster(String name){
        this.name = name;
        this.activeSession = new session();
    }

    public  void addNPC(String name){
        this.npcList.add(new character("Steve", "Knight"));
    }

    public session createSession() {
        session new_Session = new session();

        return new_Session;
    }

    public void addPlayer(session Session, Player Player){
        Session.addPlayer(Player);
    }

}

