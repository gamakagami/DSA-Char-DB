import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;

public class Methods{

    // Header that is printed when printing characters
    static String header = "Character:            Rarity:               Path:                 Element:              Faction:\n";


    // Used to get the rarity, path, and the element of a character
    static void getInfo(String Character, Hashtable<String, String[]> Information, Integer Option) {

        Character = Character.substring(0, 1).toUpperCase() + Character.substring(1).toLowerCase(); // To make the first letter capitalized and the rest to be lowercase, so it will match the hashtable keys
        String[] Info = Information.get(Character); // Receives the array of information regarding the character

        switch (Option) {
            case 0:
                // The index 0 in the array represents the rarity of the character
                System.out.println("\n== " + Character + " is a " + Info[Option] + " Character ==");
                break;

            case 1:
                // The index 1 in the array represents the path of the character
                System.out.println("\n== " + Character + " is a " + Info[Option] + " Path Character ==");
                break;

            case 2:
                // The index 2 in the array represents the element of the character
                System.out.println("\n== " + Character + "'s element is " + Info[Option] + " ==");
                break;
        }
    }

    // Method that ensures the character entered is valid
    static String getCharacter(Scanner scn, String[] Characters) {

        System.out.print("Please Enter a Character Name: ");

        return checkInput(scn, Characters); // Returns the valid character name
    }

    // Method that prints the information of all characters
    static void printAllCharacters(String[] characterContainer, String[][] characterInformation) {

        System.out.println(header);

        for (int i = 0; i < characterContainer.length; i++) {
            printCharacterInfo(characterContainer[i], characterInformation[i], i);
        }
    }

    // The method that takes in the character name and the information array as an input to display their information with proper spacing
    static void printCharacterInfo(String character, String[] info, int no) {

        // It utilizes the length of the information printed to provide equal distance from each category of information by using th for loop.

        System.out.print(no + 1 + ". " + character);
        int nameLength = (character + String.valueOf(no + 1) + ". ").length();
        for (int j = nameLength; j < 22; j++) { // Prints " " 20 - name length amount of times
            System.out.print(" ");
        }

        // Uses a as the index for the information array
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

        System.out.print("\nWould you like to Continue? (Y/N): ");
        Scanner scn = new Scanner(System.in);
        boolean continueTheProgram = false;

        String input = checkInput(scn, new String[]{"Y", "N"});

        // Will print if the user chooses to exit the program
        if (input.equalsIgnoreCase("N")){
            System.out.println("\n== Exiting the Program ==");
        } else continueTheProgram = true;

        return continueTheProgram;
    }

    // A method that takes in scanner and an array if targetActions representing the input wanted
    static String checkInput(Scanner scn, String[] target) {

        boolean action_present = false;
        String action = "";

        while (!action_present) {
            action = scn.nextLine();

            // Checking if the user input is equal to any of the target inputs
            for (String targetInput : target) {

                String actions = action.replace(" ", "");
                if (action.equalsIgnoreCase(targetInput) || actions.equalsIgnoreCase(targetInput)) {
                    action_present = true; // Stopping the loop
                    break;
                }
            }

            if (!action_present) {
                System.out.print("Please enter a valid input: ");
            }
        }
        return action; // Returns the valid action
    }

    // Method to make the code more efficient, checking features by taking the option representing the index and filter string
    static void filterBasics(String[] characterContainer, String[][] characterInformation, int feature, String filter){

        System.out.println("\n== Printing Characters ==\n" + header);

        int j = 0;
        // For loop to check through the index of the arrays inside the character information array corresponding to the feature it is filtering by. If it is equivalent, will print the character information
        for (int i = 0; i < characterContainer.length; i++) {
            if (characterInformation[i][feature].equalsIgnoreCase(filter) || characterInformation[i][feature].replace(" ", "").equalsIgnoreCase(filter)) {
                printCharacterInfo(characterContainer[i], characterInformation[i], j); // Prints Info
                j += 1;
            }
        }
    }

    // Method that filters based on the input taken, taking in the character container and information
    static void filter(Scanner scn, String input, String[] characterContainer, String[][] characterInformation){

        switch(input.toUpperCase()) {

            // Filter characters by alphabet entered
            case "A":
                System.out.print("Please enter an alphabet to filter by: ");

                // To check if the input is one of the alphabets
                String alphabet = checkInput(scn, new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"});
                System.out.println("\n" + header);

                int i = 0;
                // Checks if the alphabet of each character is the same with the input entered, if it is the same, will display the character information
                for (String s : characterContainer){
                    if (String.valueOf(s.charAt(0)).equalsIgnoreCase(alphabet)){
                        printCharacterInfo(s, characterInformation[Arrays.asList(characterContainer).indexOf(s)], i); // Finds the index of the character name, and puts the character information array as an input to the method
                        i += 1;
                    }
                }
                break;

            // Filters by the element
            case "B":
                System.out.print("Please enter an element to filter by (Fire, Ice, Lightning, Physical, Wind, Quantum, Imaginary, Adaptive): ");
                String element = checkInput(scn, new String[]{"Fire", "Ice", "Lightning", "Physical", "Wind", "Quantum", "Imaginary", "Adaptive"}); // Ensures that the element entered is valid

                filterBasics(characterContainer, characterInformation, 2, element);

                break;

            // Filters by the path
            case "C":
                System.out.print("Please enter a path to filter by (Nihility, Erudition, Destruction, Harmony, The Hunt, Preservation, Abundance, Adaptive): ");
                String path = checkInput(scn, new String[]{"Nihility", "Erudition", "Destruction", "Harmony", "TheHunt", "Preservation", "Abundance", "Adaptive"}); // Ensure input is valid

                filterBasics(characterContainer, characterInformation, 1, path);
                break;

            // Filters by the faction
            case "D":
                System.out.print("Please enter a faction to filter by (Herta Space Station, IPC, The Xianzhou Loufu, Stellaron Hunter, Belobog, Astral Express, Intelligentsia Guild, Penacony, Masked Fools): ");
                String faction = checkInput(scn, new String[]{"HertaSpaceStation", "IPC", "TheXianzhouLoufu", "StellaronHunter", "Belobog", "AstralExpress", "IntelligentsiaGuild", "Penacony", "MaskedFools"});

                filterBasics(characterContainer, characterInformation, 3, faction);
                break;

            // Filters by Rarity
            case "E":
                System.out.print("Please enter a rarity to filter by (4 Star, 5 Star): ");
                String rarity = checkInput(scn, new String[]{"4Star", "5Star"}); // Ensure Input is valid

                filterBasics(characterContainer, characterInformation, 0, rarity);
                break;
        }
    }

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
