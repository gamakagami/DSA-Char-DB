import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;

public class Methods {

    // Used to get the rarity, path, and the element of a character
    static void getInfo(String Character, Hashtable<String, String[]> Information, Integer Option) {

        Character = Character.substring(0, 1).toUpperCase() + Character.substring(1).toLowerCase(); // To make the first letter capitalized and the rest to be lowercase, so it will match the hashtable keys
        String[] Info = Information.get(Character); // Receives the array of information regarding the character

        switch (Option) {
            case 0:

                // The index 0 in the array represents the rarity of the character
                System.out.println(Character + " is a " + Info[Option] + " character.");
                break;

            case 1:

                // The index 1 in the array represents the path of the character
                System.out.println(Character + " is a " + Info[Option] + " path character.");
                break;

            case 2:

                // The index 2 in the array represents the element of the character
                System.out.println(Character + "'s element is " + Info[Option] + ".");
                break;
        }
    }

    // Method that ensures the character entered is valid
    static String getCharacter(Scanner scn, String[] Characters) {

        boolean present = false;
        String Char = "";

        System.out.println("Please Enter a Character Name: ");

        while (!present) {
            Char = scn.nextLine();
            Char = Char.replace(" ", "");

            /* Goes through the character storage, if the string entered is equal to one of the character name,
               it will stop. Otherwise, it will continue to loop until it receives a valid name */
            for (String i : Characters) {
                if (i.equalsIgnoreCase(Char)) {
                    present = true;
                    break;
                }
            }
            if (!present) {
                System.out.println("Please enter a valid Character");
            }
        }
        return Char; // Returns the valid character name
    }

    // Method that prints the information of all characters
    static void printAllCharacters(String[] characterContainer, String[][] characterInformation) {

        System.out.println("Character:          Rarity:             Path:               Element:            Faction:");

        for (int i = 0; i < characterContainer.length; i++) {
            printCharacterInfo(characterContainer[i], characterInformation[i]);
        }
    }

    // The method that takes in the character name and the information array as an input to display their information with proper spacing
    static void printCharacterInfo(String character, String[] info) {

        // It utilizes the length of the information printed to provide equal distance from each category of information by using th for loop.

        System.out.print(character);
        int nameLength = character.length();
        for (int j = nameLength; j < 20; j++) { // Prints " " 20 - name length amount of times
            System.out.print(" ");
        }

        // Uses a as the index for the information array
        for (int a = 0; a < 3; a++) {
            System.out.print(info[a]);

            int length = info[a].length();
            for (int k = length; k < 20; k++) {
                System.out.print(" ");
            }
        }

        System.out.println(info[3]); // Println to create space from the previous character
    }

    // Method that requests user confirmation whether to continue or stop
    static boolean proceed() {

        System.out.println("Would you like to Continue? (Y/N)");
        Scanner scn = new Scanner(System.in);
        boolean loop = true; // To loop until input is valid
        boolean continueTheProgram = false;

        while (loop) {
            String proceed = scn.nextLine();
            if (proceed.equalsIgnoreCase("Y")) { // If user enters Y, the program will continue
                continueTheProgram = true;
                loop = false;

            } else if (proceed.equalsIgnoreCase("N")) { // If the user enters N, the program will stop
                loop = false;
            }

            if (loop) {
                System.out.print("Please enter Y or N "); // Will continue to loop until receives input Y or N
            }
        }

        // Will print if the user chooses to exit the program
        if (!continueTheProgram) {
            System.out.println("Exiting...");
        }

        return continueTheProgram;
    }

    // A method that takes in scanner and an array if targetActions representing the input wanted
    static String checkInput(Scanner scn, String[] targetActions) {

        boolean action_present = false;
        String action = "";

        while (!action_present) {
            action = scn.nextLine();

            // Checking if the user input is equal to any of the target inputs
            for (String targetAction : targetActions) {

                if (action.equalsIgnoreCase(targetAction)) {
                    action_present = true; // Stopping the loop
                    break;
                }
            }

            if (!action_present) {
                System.out.println("Please enter a valid action");
            }
        }
        return action; // Returns the valid action
    }


    // Method that filters based on the input taken, taking in the character container and information
    static void filter(Scanner scn, String input, String[] characterContainer, String[][] characterInformation){

        switch(input.toUpperCase()) {

            // Filter characters by alphabet entered
            case "A":
                System.out.print("Please enter an alphabet to filter by: ");

                // To check if the input is one of the alphabets
                String alphabet = checkInput(scn, new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"});
                System.out.println("Character:          Rarity:             Path:               Element:            Faction:");

                // Checks if the alphabet of each character is the same with the input entered, if it is the same, will display the character information
                for (String s : characterContainer){
                    if (String.valueOf(s.charAt(0)).equalsIgnoreCase(alphabet)){
                        printCharacterInfo(s, characterInformation[Arrays.asList(characterContainer).indexOf(s)]); // Finds the index of the character name, and puts the character information array as an input to the method
                    }
                }
                break;

            // Filters by the element
            case "B":
                System.out.print("Please enter an element to filter by (Fire, Ice, Lightning, Physical, Wind, Quantum, Imaginary, Adaptive): ");
                String element = checkInput(scn, new String[]{"Fire", "Ice", "Lightning", "Physical", "Wind", "Quantum", "Imaginary", "Adaptive"}); // Ensures that the element entered is valid
                System.out.println("Character:          Rarity:             Path:               Element:            Faction:");

                // For loop to check through index 2 (element) of the arrays inside the character information array. If it is equivalent, will print the character information
                for (int i = 0; i < characterContainer.length; i++) {
                    if (characterInformation[i][2].equalsIgnoreCase(element)) {
                        printCharacterInfo(characterContainer[i], characterInformation[i]); // Prints Info
                    }
                }
                break;

            // Filters by the path
            case "C":
                System.out.print("Please enter a path to filter by (Nihility, Erudition, Destruction, Harmony, The Hunt, Preservation, Abundance, Adaptive): ");
                String path = checkInput(scn, new String[]{"Nihility", "Erudition", "Destruction", "Harmony", "The Hunt", "Preservation", "Abundance", "Adaptive"}); // Ensure input is valid
                System.out.println("Character:          Rarity:             Path:               Element:            Faction:");

                // For loop to check through index 1 (path) of the arrays inside the character information array. If it is equivalent, will print the character information
                for (int i = 0; i < characterContainer.length; i++) {
                    if (characterInformation[i][1].equalsIgnoreCase(path)) {
                        printCharacterInfo(characterContainer[i], characterInformation[i]); // Prints Info
                    }
                }
                break;

            // Filters by the faction
            case "D":
                System.out.print("Please enter a faction to filter by (Herta Space Station, IPC, The Xianzhou Loufu, Stellaron Hunter, Belobog, Astral Express, Intelligentsia Guild, Penacony, Masked Fools): ");
                String faction = checkInput(scn, new String[]{"Herta Space Station", "IPC", "The Xianzhou Loufu", "Stellaron Hunter", "Belobog", "Astral Express", "Intelligentsia Guild", "Penacony", "Masked Fools"});
                System.out.println("Character:          Rarity:             Path:               Element:            Faction:");

                // For loop to check through index 3 (faction) of the arrays inside the character information array. If it is equivalent, will print the character information
                for (int i = 0; i < characterContainer.length; i++) {
                    if (characterInformation[i][3].equalsIgnoreCase(faction)) {
                        printCharacterInfo(characterContainer[i], characterInformation[i]); // Prints Info
                    }
                }
                break;

            // Filters by Rarity
            case "E":
                System.out.print("Please enter a rarity to filter by (4 Star, 5 Star): ");
                String rarity = checkInput(scn, new String[]{"4 Star", "5 Star"}); // Ensure Input is valid
                System.out.println("Character:          Rarity:             Path:               Element:            Faction:");

                // For loop to check through index 0 (rarity) of the arrays inside the character information array. If it is equivalent, will print the character information
                for (int i = 0; i < characterContainer.length; i++) {
                    if (characterInformation[i][0].equalsIgnoreCase(rarity)) {
                        printCharacterInfo(characterContainer[i], characterInformation[i]); // Prints Info
                    }
                }
                break;
        }
    }

    // Sorting basic Method, where the feature indicates what index of the character information will be checked, and the elements representing the order of printing
    static void sortBasic(String[] characters, String[][] characterInfo, String[] elements, int feature){

        // Goes through each element and compares them (by order)
        for (int i = 0; i < elements.length; i++){

            for (int j = 0; j < characters.length; j++){

                // Checks if the feature is equal
                if (characterInfo[j][feature].equalsIgnoreCase(elements[i])){
                    printCharacterInfo(characters[j], characterInfo[j]); // Prints Info
                }
            }
        }

    }

    // Method that uses the sort basics method, changing the feature and the array of order
    static void sortCharacters(String sort, String[] characters, String[][] characterInfo){

        switch (sort.toUpperCase()){

            // Sorting by alphabet will be the same as printing the characters
            case "A":
                printAllCharacters(characters, characterInfo);
                break;


            case "B":
                String[] rarity = {"4 Star", "5 Star"}; // Order of Printing
                sortBasic(characters, characterInfo, rarity, 0); // 0 is the index of the rarity in the array
                break;

            case "C":
                String[] paths = {"Abundance", "Destruction","Euridition","Harmony","Nihility", "Preservation", "The Hunt"}; // Order pf Printing
                sortBasic(characters, characterInfo, paths, 1); // 1 is the index of the path in the array
                break;

            case "D":
                String[] elements = {"Fire","Ice","Imaginary","Lightning", "Physical", "Quantum", "Wind"}; // Order of Printing
                sortBasic(characters, characterInfo, elements, 2); // 2 is the index of the elements in the array
                break;

            case "E":
                String[] factions = {"Astral Express","Belobog","Garden of Recollection","Herta Space Station","Intelligentsia Guild","IPC","Knight of Beauty","Masked Fools","Penacony","Self Anihilator", "Stellaron Hunter" ,"The Xianzhou Loufu"}; // Order of Printing
                sortBasic(characters, characterInfo, factions, 3); // 3 is the index of the faction in the array
                break;
        }
    }

}
