import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.Font;
import javax.swing.plaf.FontUIResource;

// To know what the methods do, please refer to the Methods.java file.

public class Main extends Methods {

    public static Hashtable<String, String[]> Retrieve_Information; // Make it public so it can be accessed from other classes

    public static void main(String[] args) {

        Character chars = new Character();

        // Stores the font for JOptionpane related printing in the UIManager (Manages Javaxswing package)
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Monospaced", Font.PLAIN, 12)));

        // Initializing the hashtable and adding elements (Name : Array of Information)
        Retrieve_Information = new Hashtable<>(48);
        for (int i = 0; i < chars.characterContainer.length; i++) {
            Retrieve_Information.put(chars.characterContainer[i], chars.characterInformation[i]);
        }

        Scanner scn = new Scanner(System.in);

        boolean loop = true; // If the loop becomes false, the program will stop (Determined by he method proceed)

        while (loop) {
            String action = JOptionPane.showInputDialog("\n== Welcome to a Honkai Star Rail Database System ==\n== List Of Actions ==\n- A: Get Rarity\n- B: Get Path\n- C: Get Element\n- D: Print all Characters\n- E: Filter Characters\n- F: Display Information of a Chracter\n- G: Sort Characters\n- Q: Quit\n\nPlease enter an action you want to perform: ");

            action = checkInput(new String[]{"A", "B", "C", "D", "E", "F", "G", "Q"}, action); // To ensure user input is valid

            // To perform different actions based on user input
            switch (action.toUpperCase()) {

                // Getting Rarity
                case "A":
                    String character = getCharacter(chars.characterContainer);
                    getInfo(character, Retrieve_Information, 0);
                    loop = proceed();
                    break;

                // Getting Path
                case "B":
                    character = getCharacter(chars.characterContainer);
                    getInfo(character, Retrieve_Information, 1);
                    loop = proceed();
                    break;

                // Getting Element
                case "C":
                    character = getCharacter(chars.characterContainer);
                    getInfo(character, Retrieve_Information, 2);
                    loop = proceed();
                    break;

                // Printing all Characters
                case "D":
                    System.out.println("\n== Printing Characters Information ==\n ");
                    printAllCharacters(Retrieve_Information, chars.characterContainer);
                    loop = proceed();
                    break;

                // Filtering
                case "E":
                    String filter = JOptionPane.showInputDialog("\n== Filter Characters By: ==\n- A: Alphabet\n- B: Element\n- C: Path\n- D: Faction\n- E: Rarity\n\nFilter Characters by: ");

                    filter = checkInput(new String[]{"A","B","C","D","E"}, filter);

                    filter(filter, Retrieve_Information, chars.characterContainer);
                    loop = proceed();
                    break;

                // Displaying information of a character
                case "F":

                    String name = JOptionPane.showInputDialog("Enter a Character Name: ");
                    name = checkInput(chars.characterContainer, name);
                    String print = "";

                    for (int i = 0; i < chars.characterContainer.length; i++){

                        name = name.replace(" ",""); // To ensure no error happens due to space

                        // Goes through the character container and if it matches, it will display the character information
                        if (chars.characterContainer[i].equalsIgnoreCase(name)){
                            print += printCharacterInfo(chars.characterContainer[i], Retrieve_Information.get(chars.characterContainer[i]), 0, print);
                        }
                    }
                    JOptionPane.showMessageDialog(null, header + print);
                    loop = proceed();
                    break;

                // Sorting Characters
                case "G":

                    String sort = JOptionPane.showInputDialog("\n== Sort Characters Features ==\nA: Alphabet\nB: Rarity\nC: Path\nD: Element\nE: Faction\n\nSort Characters By: ");

                    sort = checkInput(new String[]{"A","B","C","D","E"}, sort);
                    sortCharacters(sort, Retrieve_Information, chars.characterContainer);
                    loop = proceed();
                    break;


                // Quitting program
                case "Q":
                    JOptionPane.showMessageDialog(null, "Quitting Program");
                    loop = false;
                    break;
            }
        }
    }
}
