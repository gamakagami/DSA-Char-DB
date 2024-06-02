import java.util.*;
import java.io.*;

public class Main extends Methods {
    public static void main(String[] args) {

        Character chars = new Character();

        // Create a hashtable to retrieve information
        Hashtable<String, LinkedList<String>> Retrieve_Information = new Hashtable<>(48);

        // Populate the hashtable using the LinkedLists
        for (int i = 0; i < chars.characterContainer.size(); i++) {
            Retrieve_Information.put(chars.characterContainer.get(i), chars.characterInformation.get(i));
        }

        Scanner scn = new Scanner(System.in);

        System.out.println("\n== Welcome to a Honkai Star Rail Database System ==");
        boolean loop = true; // If the loop becomes false, the program will stop (Determined by he method proceed)

        while (loop) {
            System.out.print("\n== List Of Actions ==\n- A: Get Rarity\n- B: Get Path\n- C: Get Element\n- D: Print all Characters\n- E: Filter Characters\n- F: Display Information of a Chracter\n- G: Sort Characters\n- Q: Quit\n\nPlease enter an action you want to perform: ");

            String action = "";

            action = checkInput(scn, new String[]{"A", "B", "C", "D", "E", "F", "G", "Q"});

            switch (action.toUpperCase()) {
                case "A":
                    String character = getCharacter(scn, chars.characterContainer);
                    getInfo(character, Retrieve_Information, 0);
                    loop = proceed();
                    break;

                case "B":
                    character = getCharacter(scn, chars.characterContainer);
                    getInfo(character, Retrieve_Information, 1);
                    loop = proceed();
                    break;

                case "C":
                    character = getCharacter(scn, chars.characterContainer);
                    getInfo(character, Retrieve_Information, 2);
                    loop = proceed();
                    break;

                case "D":
                    System.out.println("\n== Printing Characters Information ==\n ");
                    printAllCharacters(chars.characterContainer, chars.characterInformation);
                    loop = proceed();
                    break;

                case "E":
                    System.out.print("\n== Filter Characters By: ==\n- A: Alphabet\n- B: Element\n- C: Path\n- D: Faction\n- E: Rarity\n");

                    System.out.print("\nFilter Characters by: ");
                    String filter = checkInput(scn, new String[]{"A", "B", "C", "D", "E"});

                    filter(scn, filter, chars.characterContainer, chars.characterInformation);
                    loop = proceed();
                    break;

                case "F":
                    System.out.print("Enter a character name: ");
                    String name = checkInput(scn, chars.characterContainer.toArray(new String[0]));

                    for (int i = 0; i < chars.characterContainer.size(); i++) {
                        name = name.replace(" ",""); // To ensure no error happens due to space

                        // Goes through the character container and if it matches, it will display the character information
                        if (chars.characterContainer[i].equalsIgnoreCase(name)){
                            System.out.println("\nCharacter:            Rarity:               Path:                 Element:              Faction:");
                            printCharacterInfo(chars.characterContainer[i], chars.characterInformation[i], 0);
                        }
                    }
                    loop = proceed();
                    break;

                case "G":
                    System.out.print("\n== Sort Characters Features ==\nA: Alphabet\nB: Rarity\nC: Path\nD: Element\nE: Faction\n");
                    System.out.print("\nSort Characters By: ");
                    String sort = checkInput(scn, new String[]{"A", "B", "C", "D", "E"});
                    sortCharacters(sort, chars.characterContainer, chars.characterInformation);
                    loop = proceed();
                    break;

                case "Q":
                    System.out.println("Quitting program..");
                    loop = false;
                    break;
            }
        }
    }
}
