
package model;
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
        this.sessionList = new ArrayList<session>();
        this.sessionList.add(this.activeSession);
        this.npcList = new ArrayList<character>();
    }

    public  void addNPC(String name){
        this.npcList.add(new character(name, "Orc"));
    }

    public session createSession() {
        session new_Session = new session();

        return new_Session;
    }

    public void addPlayer(session Session, player player){
        Session.addPlayer(player);
    }

}

