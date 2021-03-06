package model;
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
    public characterArrayIterator createIterator(){
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
            System.out.println(this.characterList.get(currentIndex).getName());
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

    public void addAllPlayerChars(ArrayList<player> playerList){
        for (int i = 0; i < playerList.size(); i++){
            this.characterList.add(playerList.get(i).getCharacter());
        }
    }

    public void addChar(character character){
        this.characterList.add(character);
    }

    public String display(){
        String list = "";
        for (int i = 0; i < characterList.size(); i++){
            list += characterList.get(i).getName()+" the "+ characterList.get(i).getCharClass()+"\n";
        }

        return list;
    }

    public void addNPCs(ArrayList<character> npcList){
        for (int i = 0; i < npcList.size(); i++){
            this.characterList.add(npcList.get(i));
        }
    }

    public void removeChar(character target){
        this.characterList.remove(target);
    }

    //jcomboboxes need arrays not arraylists
    public character[] getCharArray(){
        character [] charArr = this.characterList.toArray(new character[this.characterList.size()]);
        return charArr;
    }

}
