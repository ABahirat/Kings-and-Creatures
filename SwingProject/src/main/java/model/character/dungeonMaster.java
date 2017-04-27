package model.character;
import java.util.*;
/**
 * Created by vindi on 4/25/2017.
 */
public class dungeonMaster {
    public ArrayList<session> sessionList;
    public session activeSession;

    public session createSession() {
        session new_Session = new session();

        return new_Session;
    }

    public void addPlayer(session Session, Player Player){
        Session.addPlayer(Player);
    }

}
