import java.util.*;

// To know what the methods do, please refer to the Methods.java file.

public class Main extends Methods {

    public static Hashtable<String, LinkedList<String>> Retrieve_Information; // Make it public so it can be accessed from other classes

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

            action = checkInput(scn, new String[]{"A", "B", "C", "D", "E", "F", "G", "Q"}); // To ensure user input is valid

            // To perform different actions based on user input
            switch (action.toUpperCase()) {

                // Getting Rarity
                case "A":
                    String character = getCharacter(scn, chars.characterContainer);
                    getInfo(character, Retrieve_Information, 0);
                    loop = proceed();
                    break;

                // Getting Path
                case "B":
                    character = getCharacter(scn, chars.characterContainer);
                    getInfo(character, Retrieve_Information, 1);
                    loop = proceed();
                    break;

                // Getting Element
                case "C":
                    character = getCharacter(scn, chars.characterContainer);
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
                    System.out.print("\n== Filter Characters By: ==\n- A: Alphabet\n- B: Element\n- C: Path\n- D: Faction\n- E: Rarity\n");

                    System.out.print("\nFilter Characters by: ");
                    String filter = checkInput(scn, new String[]{"A","B","C","D","E"});

                    filter(scn, filter, Retrieve_Information, chars.characterContainer);
                    loop = proceed();
                    break;

                // Displaying information of a character
                case "F":
                    System.out.print("Enter a character name: ");
                    String name = checkInput(scn, chars.characterContainer.toArray(new String[0]));

                    for (int i = 0; i < chars.characterContainer.size(); i++){

                        name = name.replace(" ",""); // To ensure no error happens due to space

                        // Goes through the character container and if it matches, it will display the character information
                        if (chars.characterContainer.get(i).equalsIgnoreCase(name)){
                            System.out.println("\nCharacter:            Rarity:               Path:                 Element:              Faction:");
                            printCharacterInfo(chars.characterContainer.get(i), chars.characterInformation.get(i), 0);
                        }
                    }
                    loop = proceed();
                    break;

                // Sorting Characters
                case "G":
                    System.out.print("\n== Sort Characters Features ==\nA: Alphabet\nB: Rarity\nC: Path\nD: Element\nE: Faction\n");
                    System.out.print("\nSort Characters By: ");
                    String sort = checkInput(scn, new String[]{"A","B","C","D","E"});
                    sortCharacters(sort, Retrieve_Information, chars.characterContainer);
                    loop = proceed();
                    break;


                // Quitting program
                case "Q":
                    System.out.println("Quitting program..");
                    loop = false;
                    break;
            }
        }
    }
}
