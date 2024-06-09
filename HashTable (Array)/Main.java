import java.util.*;

// To know what the methods do, please refer to the Methods.java file.

public class Main extends Methods {

    public static Hashtable<String, String[]> Retrieve_Information; // Make it public so it can be accessed from other classes

    public static void main(String[] args) {

        Character chars = new Character(); // To access the data structures used to store the characters along with their information

        // Initializing the hashtable and adding elements (Name : Array of Information)
        Retrieve_Information = new Hashtable<>();
        for (int i = 0; i < chars.characterContainer.length; i++) {
            Retrieve_Information.put(chars.characterContainer[i], chars.characterInformation[i]);
        }

        Scanner scn = new Scanner(System.in); // Define Scanner

        System.out.println("\n== Welcome to a Honkai Star Rail Database System ==");
        boolean loop = true; // If the loop becomes false, the program will stop (Determined by he method proceed)

        while (loop) {
            System.out.print("\n== List Of Actions ==\n- A: Get Rarity\n- B: Get Path\n- C: Get Element\n- D: Print all Characters\n- E: Filter Characters\n- F: Display Information of a Chracter\n- G: Sort Characters\n- Q: Quit\n\nPlease enter an action you want to perform: ");
            // List of Actions
            
            String action = "";

            action = checkInput(scn, new String[]{"A", "B", "C", "D", "E", "F", "G", "Q"}); // To ensure user input is valid, and within the list of actions. If not, it will loop.

            // To perform different actions based on user input
            switch (action.toUpperCase()) { // To Uppercase to avoid errors

                // Getting Rarity
                case "A":
                    String character = getCharacter(scn, chars.characterContainer); // Ensure that the character name is valid
                    getInfo(character, Retrieve_Information, 0); // 0 represents the index of the rarity in the arrays, returns the rarity of the character
                    loop = proceed(); // Asks whether the user wants to proceed or not
                    break;

                // Getting Path
                case "B":
                    character = getCharacter(scn, chars.characterContainer);
                    getInfo(character, Retrieve_Information, 1); // 1 represents the index of the path in the arrays
                    loop = proceed();
                    break;

                // Getting Element
                case "C":
                    character = getCharacter(scn, chars.characterContainer);
                    getInfo(character, Retrieve_Information, 2); // 2 represents the index of the element in the arrays
                    loop = proceed();
                    break;

                // Printing all Characters
                case "D":
                    System.out.println("\n== Printing Characters Information ==\n ");
                    printAllCharacters(Retrieve_Information, chars.characterContainer); // Prints all characters
                    loop = proceed();
                    break;

                // Filtering
                case "E":
                    System.out.print("\n== Filter Characters By: ==\n- A: Alphabet\n- B: Element\n- C: Path\n- D: Faction\n- E: Rarity\n");

                    System.out.print("\nFilter Characters by: ");
                    String filter = checkInput(scn, new String[]{"A","B","C","D","E"}); // To ensure the input is valid

                    filter(scn, filter, Retrieve_Information, chars.characterContainer); // Filters the characters
                    loop = proceed();
                    break;

                // Displaying information of a character
                case "F":
                    System.out.print("Enter a character name: ");
                    String name = checkInput(scn, chars.characterContainer);

                    for (int i = 0; i < chars.characterContainer.length; i++){

                        name = name.replace(" ",""); // To ensure no error happens due to space

                        // Goes through the character container and if it matches, it will display the character information
                        if (chars.characterContainer[i].equalsIgnoreCase(name)){ 
                            System.out.println("\nCharacter:            Rarity:               Path:                 Element:              Faction:");
                            printCharacterInfo(chars.characterContainer[i], chars.characterInformation[i], 0);
                        }
                    }
                    loop = proceed();
                    break;

                // Sorting Characters
                case "G":
                    System.out.print("\n== Sort Characters Features ==\nA: Alphabet\nB: Rarity\nC: Path\nD: Element\nE: Faction\n");
                    System.out.print("\nSort Characters By: ");
                    String sort = checkInput(scn, new String[]{"A","B","C","D","E"}); // Checks valid input
                    sortCharacters(sort, Retrieve_Information, chars.characterContainer); // Sorts the characters
                    loop = proceed();
                    break;


                // Quitting program
                case "Q":
                    System.out.println("Quitting program..");
                    loop = false; // Stops the loop
                    break;
            }
        }
    }
}
