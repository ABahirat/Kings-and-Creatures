
package model;



import java.util.*;

/**
 * Created by Peter on 4/24/2017.
 */
public class character{
    String name;
    String charClass;
    int str = 10;
    int dex = 10;
    int intelligence = 10;
    //itemList items[];
    public ArrayList<item> itemList;
    //spellList spells[];
    int armor = 10;
    int mr = 10;
    int health = 10;
    //Equipmentlist equipment[]
    int gold = 10;
    int speed = 10;
    String notes = "";

    public character() {
        this.name = "Jim the Dubious";
        this.charClass = "Rogue";
        ArrayList<item> myList = new ArrayList<item>();
        this.itemList = new ArrayList<item>();
        this.addItem("Jim's Rope");
        this.addItem("Jim's Shoes");
    }

    public character(String name, String charClass){
        this.name = name;
        this.charClass = charClass;
        ArrayList<item> myList = new ArrayList<item>();
        this.itemList = new ArrayList<item>();
        this.addItem(name + "'s Rope");
        this.addItem(name + "'s Shoes");
    }

    public void addItem(String name){
        this.itemList.add(new item(name));
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

    public int getstr() {
        return str;
    }

    public void setstr(int str) {
        str = str;
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

    public String Attack(character target) {
        int attack_roll = (int) Math.ceil(Math.random() * 20) + getstr();
        int ac = target.getArmor() + target.getDex();
        System.out.println("Roll: " + attack_roll);
        System.out.println("AC: " + ac);
        if (attack_roll >= ac) {
            int damage = (int) Math.ceil(Math.random() * 6);
            int prev = target.getHealth();
            target.takeDamage(damage);
            int current = target.getHealth();
            String ret = target.getName()+" took "+ damage+ " damage. "+ prev + "->"+current;
            return ret;
        } else {
            System.out.println("miss");
            return "miss";
        }
    }

    public boolean checkAlive(){
        if(this.getHealth()> 0){
            return true;
        } else {
            return false;
        }
    }

    public void takeDamage(int damage){
        setHealth(getHealth()-damage);
    }

    public void Trade(item item, item item1, character character){
        //Access item Array list of character, and self, swap items
        removeItem(item, this.itemList);
        storeItem(item1, this.itemList);

        if(character != null) {
            removeItem(item1, character.itemList);
            storeItem(item, character.itemList);
        }

        System.out.println("Traded " +item1.getName()+ " for "+ item.getName());

    }

    public void removeItem(item item, ArrayList<item> itemList){
        itemList.remove(item);
    }

    public void storeItem(item item, ArrayList<item> itemList){
        itemList.add(item);
    }

    public void displayItems(character character){
        for(model.item item : character.itemList){
            System.out.println(item.Name); //Needs to be changed to print to text box
        }
    }

    public item[] getItemArray(){
        item[] itemArr = this.itemList.toArray(new item[this.itemList.size()]);
        return itemArr;
    }

}

