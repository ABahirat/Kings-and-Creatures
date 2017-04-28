package model.character;
import java.util.ArrayList;
import java.util.*;
/**
 *  Collection and concreteCollection should have method to create iterators and return them.
 * Created by vindi on 4/25/2017.
 */
public class characterArrayIterator implements iteratorDP {

    private int currentIndex = 0;
    private ArrayList<character> characterList;

    public characterArrayIterator(){
        this.characterList = new ArrayList<character>();
    }

    @Override
    public iteratorDP createIterator(){
        return new characterArrayIterator();
    }

    @Override
    public character next(){
        if (this.hasNext()){
            currentIndex++;
            System.out.println(this.characterList.get(currentIndex).getName());
            return this.characterList.get(currentIndex);
        }
        else{
            currentIndex = 0;
            System.out.println("New Round!");
            Collections.shuffle(this.characterList);
            return this.characterList.get(currentIndex);
        }
    }

    @Override
    public character getCurrent(){
        return this.characterList.get(currentIndex);
    }


    @Override
    public boolean hasNext(){
        if (currentIndex + 1 >= this.characterList.size()){
            return false;
        }
        else{
            return true;
        }
    }

    public void addAllPlayerChars(ArrayList<Player> PlayerList){
        for (int i = 0; i < PlayerList.size(); i++){
            this.characterList.add(PlayerList.get(i).getCharacter());
        }
    }

    public void addNPCs(ArrayList<character> npcList){
        for (int i = 0; i < npcList.size(); i++){
            this.characterList.add(npcList.get(i));
        }
    }

}
