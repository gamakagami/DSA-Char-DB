//  The Character class
public class Character {

    // Variables that hold the attributes of a character
    String name, rarity, path, element, faction;

    // Constructor to initialize a Character object with specific attributes
    public Character(String name, String rarity, String path, String element, String faction) {
        this.name = name;       
        this.rarity = rarity;   
        this.path = path;       
        this.element = element; 
        this.faction = faction; 
    }

    // Getter method for the faction attribute
    public String getFaction() {
        return faction; 
    }

    // Getter method for the element attribute
    public String getElement() {
        return this.element; 
    }

    // Getter method for the path attribute
    public String getPath() {
        return path; 
    }

    // Getter method for the name attribute
    public String getName() {
        return name; 
    }

    // Getter method for the rarity attribute
    public String getRarity() {
        return rarity; 
    }
}
