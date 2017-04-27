package model.character;

/**
 * Created by Ameya on 4/24/17.
 */
public class Item{

    String Name;

    public void setValue(int value) {
        Value = value;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setHealth(int health) {
        Health = health;
    }

    int Health;
    int Value;

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
