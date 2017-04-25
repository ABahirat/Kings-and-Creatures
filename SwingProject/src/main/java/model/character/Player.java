package model.character;

/**
 * Created by Ameya on 4/25/17.
 */
public class Player extends character {

    character Character;
    //Probably needs to take in something different
    public character createCharacter(String name, String charClass){

        character new_Character = new character();

        new_Character.name = name;
        new_Character.charClass = charClass;
        //Empty array list of items is created upon instantiation of character
        return new_Character;
    }

}
