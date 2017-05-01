package model.character;

/**
 * Created by Ameya on 4/24/17.
 */
public class Item{
    String Name;
    int Health;
    int Value;

    public Item(String name){
        this.Name = name;
        this.Health = 10;
        this.Value = 10;
    }


    public void setValue(int value) {
        Value = value;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setHealth(int health) {
        Health = health;
    }



    public int getHealth() {
        return Health;
    }

    public String getName() {
        return Name;
    }

    public int getValue() {
        return Value;
    }
}
