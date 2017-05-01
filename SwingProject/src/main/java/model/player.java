
package model;

/**
 * Created by Ameya on 4/25/17.
 */
public class player extends user{

    String name;
    character Character;

    public player(){
        this.name = "Jim";
        this.Character = new character("Jim the Dubious", "Rogue");
    }

    public player(String name){
        this.name = name;
        this.Character = new character(name +" the Dubious", "Rogue");
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
