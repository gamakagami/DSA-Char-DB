import java.util.*;

public class Methods2 {
    // Header that is printed when printing characters
    static String header = "Character:            Rarity:               Path:                 Element:              Faction:\n";

    static void getInfo(String character, Hashtable<String, LinkedList<String>> information, Integer option) {

        character = character.substring(0, 1).toUpperCase() + character.substring(1).toLowerCase(); // To make the first letter capitalized and the rest to be lowercase, so it will match the hashtable keys
        LinkedList<String> info = information.get(character); // Receives the array of information regarding the character

        switch (option) {
            case 0:
                // The index 0 in the array represents the rarity of the character
                System.out.println(character + " is a " + info.get(option) + " character.");
                break;

            case 1:
                // The index 1 in the array represents the path of the character
                System.out.println(character + " is a " + info.get(option) + " path character.");
                break;

            case 2:
                // The index 2 in the array represents the element of the character
                System.out.println(character + "'s element is " + info.get(option) + ".");
                break;
        }
    }

    static String getCharacter(Scanner scn, LinkedList<String> characters) {

        System.out.print("Please Enter a Character Name: ");

        return checkInput(scn, characters.toArray(new String[0])); // Returns the valid character name
    }

    // Method that prints the information of all characterss
    static void printAllCharacters(LinkedList<String> characterContainer, LinkedList<LinkedList<String>> characterInformation) {

        System.out.println(header);

        for (int i = 0; i < characterContainer.size(); i++) {
            printCharacterInfo(characterContainer.get(i), characterInformation.get(i), i);
        }
    }

    // The method that takes in the character name and the information array as an input to display their information with proper spacing
    static void printCharacterInfo(String character, LinkedList<String> info, int no) {
        // It utilizes the length of the information printed to provide equal distance from each category of information by using th for loop.

        System.out.print(no + 1 + ". " + character);
        int nameLength = (character + String.valueOf(no + 1) + ". ").length();
        for (int j = nameLength; j < 22; j++) { // Prints " " 20 - name length amount of times
            System.out.print(" ");
        }

        // Uses a as the index for the information array
        for (int a = 0; a < 3; a++) {
            System.out.print(info.get(a));

            int length = info.get(a).length();
            for (int k = length; k < 22; k++) {
                System.out.print(" ");
            }
        }

        System.out.println(info.get(3)); // Println to create space from the previous character
    }

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

    static String checkInput(Scanner scn, String[] targetActions) {

        boolean action_present = false;
        String action = "";

        while (!action_present) {
            action = scn.nextLine();

            // Checking if the user input is equal to any of the target inputs
            for (String targetInput : targetActions) {

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

    static void filterBasics(LinkedList<String> characterContainer, LinkedList<LinkedList<String>> characterInformation, int feature, String filter){

        System.out.println("\n== Printing Characters ==\n" + header);

        int j = 0;
        // For loop to check through the index of the arrays inside the character information array corresponding to the feature it is filtering by. If it is equivalent, will print the character information
        for (int i = 0; i < characterContainer.size(); i++) {
            if (characterInformation.get(i).get(feature).equalsIgnoreCase(filter) || characterInformation.get(i).get(feature).replace(" ", "").equalsIgnoreCase(filter)) {
                printCharacterInfo(characterContainer.get(i), characterInformation.get(i), j); // Prints Info
                j += 1;
            }
        }
    }
    static void filter(Scanner scn, String input, LinkedList<String> characterContainer, LinkedList<LinkedList<String>> characterInformation) {

        switch (input.toUpperCase()) {

            case "A":
                System.out.print("Please enter an alphabet to filter by: ");
                String alphabet = checkInput(scn, new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"});
                System.out.println("\n" + header);

                int i = 0;
                // Checks if the alphabet of each character is the same with the input entered, if it is the same, will display the character information
                for (String s : characterContainer){
                    if (String.valueOf(s.charAt(0)).equalsIgnoreCase(alphabet)){
                        printCharacterInfo(s, characterInformation.get(Arrays.asList(characterContainer).indexOf(s)), i); // Finds the index of the character name, and puts the character information array as an input to the method
                        i += 1;
                    }
                }
                break;

            case "B":
                System.out.print("Please enter an element to filter by (Fire, Ice, Lightning, Physical, Wind, Quantum, Imaginary, Adaptive): ");
                String element = checkInput(scn, new String[]{"Fire", "Ice", "Lightning", "Physical", "Wind", "Quantum", "Imaginary", "Adaptive"}); // Ensures that the element entered is valid

                filterBasics(characterContainer, characterInformation, 2, element);
                break;

            case "C":
                System.out.print("Please enter a path to filter by (Nihility, Erudition, Destruction, Harmony, The Hunt, Preservation, Abundance, Adaptive): ");
                String path = checkInput(scn, new String[]{"Nihility", "Erudition", "Destruction", "Harmony", "TheHunt", "Preservation", "Abundance", "Adaptive"}); // Ensure input is valid

                filterBasics(characterContainer, characterInformation, 1, path);
                break;

            case "D":
                System.out.print("Please enter a faction to filter by (Herta Space Station, IPC, The Xianzhou Loufu, Stellaron Hunter, Belobog, Astral Express, Intelligentsia Guild, Penacony, Masked Fools): ");
                String faction = checkInput(scn, new String[]{"HertaSpaceStation", "IPC", "TheXianzhouLoufu", "StellaronHunter", "Belobog", "AstralExpress", "IntelligentsiaGuild", "Penacony", "MaskedFools"});

                filterBasics(characterContainer, characterInformation, 3, faction);
                break;

            case "E":
                System.out.print("Please enter a rarity to filter by (4 Star, 5 Star): ");
                String rarity = checkInput(scn, new String[]{"4Star", "5Star"}); // Ensure Input is valid

                filterBasics(characterContainer, characterInformation, 0, rarity);
                break;
        }
    }

    static void sortBasic(LinkedList<String> characters, LinkedList<LinkedList<String>> characterInfo, String[] elements, int feature) {

        int k = 0;
        System.out.println("\n== Printing Characters ==\n\n" + header);

        // Goes through each element and compares them (by order)
        for (int i = 0; i < elements.length; i++){

            for (int j = 0; j < characters.size(); j++){
                // Checks if the feature is equal
                if (characterInfo.get(j).get(feature).equalsIgnoreCase(elements[i])){
                    printCharacterInfo(characters.get(j), characterInfo.get(j), k); // Prints Info
                    k += 1;
                }
            }
        }
    }

    static void sortCharacters(String sort, LinkedList<String> characters, LinkedList<LinkedList<String>> characterInfo) {

        switch (sort.toUpperCase()) {
            case "A":
                System.out.print(" ");
                printAllCharacters(characters, characterInfo);
                break;

            case "B":
                String[] rarity = {"4 Star", "5 Star"};
                sortBasic(characters, characterInfo, rarity, 0);
                break;

            case "C":
                String[] paths = {"Abundance", "Destruction", "Erudition", "Harmony", "Nihility", "Preservation", "The Hunt"};
                sortBasic(characters, characterInfo, paths, 1);
                break;

            case "D":
                String[] elements = {"Fire", "Ice", "Imaginary", "Lightning", "Physical", "Quantum", "Wind"};
                sortBasic(characters, characterInfo, elements, 2);
                break;

            case "E":
                String[] factions = {"Astral Express", "Belobog", "Garden of Recollection", "Herta Space Station", "Intelligentsia Guild", "IPC", "Knight of Beauty", "Masked Fools", "Penacony", "Self Annihilator", "Stellaron Hunter", "The Xianzhou Loufu"};
                sortBasic(characters, characterInfo, factions, 3);
                break;
        }
    }
}
