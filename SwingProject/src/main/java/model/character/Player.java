package model.character;

/**
 * Created by Ameya on 4/25/17.
 */
public class Player extends user{

    character Character;

    public Player(){
        this.name = "Jim";
        this.Character = new character("Jim the Dubious", "Rogue");
    }


    //Probably needs to take in something different
    public character createCharacter(String name, String charClass){

        character new_Character = new character();

        new_Character.name = name;
        new_Character.charClass = charClass;
        //Empty array list of items is created upon instantiation of character
        return new_Character;
    }

    public character getCharacter(){
        return this.Character;
    }

}
