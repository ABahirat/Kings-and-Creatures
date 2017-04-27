package model.character;



import java.io.*;
import java.util.*;

/**
 * Created by Peter on 4/24/2017.
 */
public class character extends Player{
    String name;
    String charClass;
    int Str = 10;
    int dex = 10;
    int intelligence = 10;
    //itemList items[];
    public ArrayList<Item> itemList;
    //spellList spells[];
    int armor = 10;
    int mr = 10;
    int health = 10;
    //Equipmentlist equipment[]
    int gold = 10;
    int speed = 10;
    String notes = "";

    public character() {
        ArrayList<Item> myList = new ArrayList<Item>();
    }

    public character(String name, String charClass){
        this.name = name;
        this.charClass = charClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharClass() {
        return charClass;
    }

    public void setCharClass(String charClass) {
        this.charClass = charClass;
    }

    public int getStr() {
        return Str;
    }

    public void setStr(int str) {
        Str = str;
    }

    public int getDex() {
        return dex;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getMr() {
        return mr;
    }

    public void setMr(int mr) {
        this.mr = mr;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void Attack(Character character){}

    public void Trade(Item item, Item item1, character character){
        //Access item Array list of character, and self, swap items
        removeItem(item, this.itemList);
        storeItem(item1, this.itemList);

        if(character != null) {
            removeItem(item1, character.itemList);
            storeItem(item, character.itemList);
        }

    }

    public void removeItem(Item item, ArrayList<Item> itemList){
        itemList.remove(item);
    }

    public void storeItem(Item item, ArrayList<Item> itemList){
        itemList.add(item);
    }

    public void displayItems(character character){
        for(Item item : character.itemList){
            System.out.println(item.Name); //Needs to be changed to print to text box
        }
    }





}
