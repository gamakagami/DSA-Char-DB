import java.util.Arrays;
import java.util.Scanner;

public class Methods {

    // Header that is printed when printing characters
    static String header = "Character:              Rarity:                 Path:                   Element:                Faction:\n";


    public static void getInfo(String character, Tree tree, int infoIndex) {
        // Normalize the character name to match the tree's key format
        String normalizedCharacter = tree.normalizeKey(character);
        // Retrieve the array of information about the character
        String[] info = tree.get(normalizedCharacter);

        if (info != null) {
            // Check if the infoIndex is within the bounds of the info array
            if (infoIndex >= 0 && infoIndex < info.length) {
                switch (infoIndex) {
                    case 0:
                        System.out.println("\n== " + normalizedCharacter + " is a " + info[infoIndex] + " Character ==");
                        break;
                    case 1:
                        System.out.println("\n== " + normalizedCharacter + " is a " + info[infoIndex] + " Path Character ==");
                        break;
                    case 2:
                        System.out.println("\n== " + normalizedCharacter + "'s element is " + info[infoIndex] + " ==");
                        break;
                    default:
                        System.out.println("Invalid information index.");
                }
            }
        }
    }

    // Method that ensures the character entered is valid
    public static String getCharacter(Scanner scn, String[] characterContainer) {

        System.out.println("Please Enter a Character Name: ");

        return checkInput(scn, characterContainer); // Returns the valid character name
    }


    // Method to print all characters
    public static void printAllCharacters(String[] characterContainer, String[][] characterInformation) {
        System.out.println("Character:            Rarity:               Path:                 Element:              Faction:");
        for (int i = 0; i < characterContainer.length; i++) {
            printCharacterInfo(characterContainer[i], characterInformation[i], i);
        }
    }

    // Method to print a single character's information
    public static void printCharacterInfo(String character, String[] info, int no) {
        // It utilizes the length of the information printed to provide equal distance from each category of information by using th for loop.

        System.out.print(no + 1 + ". " + character);
        int nameLength = (character + String.valueOf(no + 1) + ". ").length();
        for (int j = nameLength; j < 22; j++) { // Prints " " 20 - name length amount of times
            System.out.print(" ");
        }

        // Uses as the index for the information array
        for (int a = 0; a < 3; a++) {
            System.out.print(info[a]);

            int length = info[a].length();
            for (int k = length; k < 22; k++) {
                System.out.print(" ");
            }
        }
        System.out.println(info[3]); // Println to create space from the previous character
    }

    // Method that requests user confirmation whether to continue or stop
    static boolean proceed() {

        System.out.println("Would you like to Continue? (Y/N): ");
        Scanner scn = new Scanner(System.in);
        boolean continueTheProgram = false;

        String input = checkInput(scn, new String[]{"Y", "N"});

        // Will print if the user chooses to exit the program
        if (input.equalsIgnoreCase("N")){
            System.out.println("Exiting...");
        } else continueTheProgram = true;

        return continueTheProgram;
    }

    // Method to check if the input is valid
    static String checkInput(Scanner scn, String[] target) {

        boolean action_present = false;
        String action = "";

        while (!action_present) {
            action = scn.nextLine();

            // Checking if the user input is equal to any of the target inputs
            for (String targetInput : target) {

                if (action.equalsIgnoreCase(targetInput)) {
                    action_present = true; // Stopping the loop
                    break;
                }
            }

            if (!action_present) {
                System.out.println("Please enter a valid input");
            }
        }
        return action; // Returns the valid action
    }

    // Method to make the code more efficient, checking features by taking the option representing the index and filter string
    // Method to make the code more efficient, checking features by taking the option representing the index and filter string
    static void filterBasics(Tree tree, String[] characterContainer, int feature, String filter) {
        System.out.println("\n== Printing Characters ==\n" + header);

        int j = 0;
        // For loop to check through the characterContainer array and fetch the corresponding information from the tree
        for (String character : characterContainer) {
            String[] info = tree.get(tree.normalizeKey(character));
            if (info != null && (info[feature].equalsIgnoreCase(filter) || info[feature].replace(" ", "").equalsIgnoreCase(filter))) {
                printCharacterInfo(character, info, j); // Prints Info
                j += 1;
            }
        }
    }

    // Method to filter characters
    static void filter(Scanner scn, String input, Tree tree, String[] characterContainer) {
        switch(input.toUpperCase()) {
            // Filter characters by alphabet entered
            case "A":
                System.out.print("Please enter an alphabet to filter by: ");
                // To check if the input is one of the alphabets
                String alphabet = checkInput(scn, new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"});
                System.out.println("\n" + header);

                int i = 0;
                // Checks if the alphabet of each character is the same with the input entered, if it is the same, will display the character information
                for (String s : characterContainer) {
                    if (String.valueOf(s.charAt(0)).equalsIgnoreCase(alphabet)) {
                        String[] info = tree.get(tree.normalizeKey(s));
                        if (info != null) {
                            printCharacterInfo(s, info, i); // Finds the index of the character name, and puts the character information array as an input to the method
                            i += 1;
                        }
                    }
                }
                break;

            // Filters by the element
            case "B":
                System.out.print("Please enter an element to filter by (Fire, Ice, Lightning, Physical, Wind, Quantum, Imaginary, Adaptive): ");
                String element = checkInput(scn, new String[]{"Fire", "Ice", "Lightning", "Physical", "Wind", "Quantum", "Imaginary", "Adaptive"}); // Ensures that the element entered is valid

                filterBasics(tree, characterContainer, 2, element);
                break;

            // Filters by the path
            case "C":
                System.out.print("Please enter a path to filter by (Nihility, Erudition, Destruction, Harmony, The Hunt, Preservation, Abundance, Adaptive): ");
                String path = checkInput(scn, new String[]{"Nihility", "Erudition", "Destruction", "Harmony", "The Hunt", "Preservation", "Abundance", "Adaptive"}); // Ensure input is valid

                filterBasics(tree, characterContainer, 1, path);
                break;

            // Filters by the faction
            case "D":
                System.out.print("Please enter a faction to filter by (Herta Space Station, IPC, The Xianzhou Loufu, Stellaron Hunter, Belobog, Astral Express, Intelligentsia Guild, Penacony, Masked Fools): ");
                String faction = checkInput(scn, new String[]{"HertaSpaceStation", "IPC", "TheXianzhouLoufu", "StellaronHunter", "Belobog", "AstralExpress", "IntelligentsiaGuild", "Penacony", "MaskedFools"});

                filterBasics(tree, characterContainer, 3, faction);
                break;

            // Filters by Rarity
            case "E":
                System.out.print("Please enter a rarity to filter by (4 Star, 5 Star): ");
                String rarity = checkInput(scn, new String[]{"4Star", "5Star"}); // Ensure Input is valid

                filterBasics(tree, characterContainer, 0, rarity);
                break;
        }
    }
    // Method to sort characters
    // Sorting basic Method, where the feature indicates what index of the character information will be checked, and the elements representing the order of printing
    static void sortBasic(String[] characters, String[][] characterInfo, String[] elements, int feature){

        int k = 0;
        System.out.println("\n== Printing Characters ==\n\n" + header);

        // Goes through each element and compares them (by order)
        for (int i = 0; i < elements.length; i++){

            for (int j = 0; j < characters.length; j++){
                // Checks if the feature is equal
                if (characterInfo[j][feature].equalsIgnoreCase(elements[i])){
                    printCharacterInfo(characters[j], characterInfo[j], k); // Prints Info
                    k += 1;
                }
            }
        }
    }

    // Method that uses the sort basics method, changing the feature and the array of order
    static void sortCharacters(String sort, String[] characters, String[][] characterInfo){

        switch (sort.toUpperCase()){

            // Sorting by alphabet will be the same as printing the characters
            case "A":
                System.out.println(" ");
                printAllCharacters(characters, characterInfo);
                break;


            case "B":
                String[] rarity = {"4 Star", "5 Star"}; // Order of Printing
                sortBasic(characters, characterInfo, rarity, 0); // 0 is the index of the rarity in the array
                break;

            case "C":
                String[] paths = {"Abundance", "Destruction","Erudition","Harmony","Nihility", "Preservation", "The Hunt","Adaptive"}; // Order pf Printing
                sortBasic(characters, characterInfo, paths, 1); // 1 is the index of the path in the array
                break;

            case "D":
                String[] elements = {"Fire","Ice","Imaginary","Lightning", "Physical", "Quantum", "Wind","Adaptive"}; // Order of Printing
                sortBasic(characters, characterInfo, elements, 2); // 2 is the index of the elements in the array
                break;

            case "E":
                String[] factions = {"Astral Express","Belobog","Garden of Recollection","Herta Space Station","Intelligentsia Guild","IPC","Knights of Beauty","Masked Fools","Penacony","Self Annihilator", "Stellaron Hunter" ,"The Xianzhou Loufu"}; // Order of Printing
                sortBasic(characters, characterInfo, factions, 3); // 3 is the index of the faction in the array
                break;
        }
    }
}
