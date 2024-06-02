import java.util.ArrayList;
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
    static void printAllCharacters(Hashtable<String, String[]> Container) {

        System.out.println(header);
        ArrayList<String> names = new ArrayList<>(Container.keySet()); // List containing the keys of the hashtable

        for (int i = 0; i < Container.size(); i++) {
            printCharacterInfo(names.get(i), Container.get(names.get(i)), i); // Prints Character Information
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
    static void filterBasics(Hashtable<String, String[]> Container, int feature, String filter){

        System.out.println("\n== Printing Characters ==\n" + header);
        ArrayList<String> keys = new ArrayList<>(Container.keySet());

        int j = 0;
        // For loop to check through the value of the hashtable, which is an array. It checks through the feature it is filtering by (using the index). If it is equivalent, will print the character information
        for (int i = 0; i < Container.size(); i++) {

            String data = Container.get(keys.get(i))[feature]; // Represents the feature of the character
            if (data.equalsIgnoreCase(filter) || data.replace(" ", "").equalsIgnoreCase(filter)) {
                printCharacterInfo(keys.get(i), Container.get(keys.get(i)), j); // Prints Info
                j += 1;
            }
        }
    }

    // Method that filters based on the input taken, taking in the Hashtable
    static void filter(Scanner scn, String input, Hashtable<String, String[]> Container){

        ArrayList<String> keys = new ArrayList<>(Container.keySet());

        switch(input.toUpperCase()) {

            // Filter characters by alphabet entered
            case "A":
                System.out.print("Please enter an alphabet to filter by: ");

                // To check if the input is one of the alphabets
                String alphabet = checkInput(scn, new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"});
                System.out.println("\n" + header);

                int i = 0;
                // Checks if the alphabet of each character is the same with the input entered, if it is the same, will display the character information
                for (String s : Container.keySet()){
                    if (String.valueOf(s.charAt(0)).equalsIgnoreCase(alphabet)){
                        printCharacterInfo(s, Container.get(keys.get(i)), i); // Finds the index of the character name, and puts the character information array as an input to the method
                        i += 1;
                    }
                }
                break;

            // Filters by the element
            case "B":
                System.out.print("Please enter an element to filter by (Fire, Ice, Lightning, Physical, Wind, Quantum, Imaginary, Adaptive): ");
                String element = checkInput(scn, new String[]{"Fire", "Ice", "Lightning", "Physical", "Wind", "Quantum", "Imaginary", "Adaptive"}); // Ensures that the element entered is valid

                filterBasics(Container, 2, element);

                break;

            // Filters by the path
            case "C":
                System.out.print("Please enter a path to filter by (Nihility, Erudition, Destruction, Harmony, The Hunt, Preservation, Abundance, Adaptive): ");
                String path = checkInput(scn, new String[]{"Nihility", "Erudition", "Destruction", "Harmony", "TheHunt", "Preservation", "Abundance", "Adaptive"}); // Ensure input is valid

                filterBasics(Container, 1, path);
                break;

            // Filters by the faction
            case "D":
                System.out.print("Please enter a faction to filter by (Herta Space Station, IPC, The Xianzhou Loufu, Stellaron Hunter, Belobog, Astral Express, Intelligentsia Guild, Penacony, Masked Fools): ");
                String faction = checkInput(scn, new String[]{"HertaSpaceStation", "IPC", "TheXianzhouLoufu", "StellaronHunter", "Belobog", "AstralExpress", "IntelligentsiaGuild", "Penacony", "MaskedFools"});

                filterBasics(Container, 3, faction);
                break;

            // Filters by Rarity
            case "E":
                System.out.print("Please enter a rarity to filter by (4 Star, 5 Star): ");
                String rarity = checkInput(scn, new String[]{"4Star", "5Star"}); // Ensure Input is valid

                filterBasics(Container, 0, rarity);
                break;
        }
    }

    // Sorting basic Method, where the feature indicates what index of the character information will be checked, and the elements representing the order of printing
    static void sortBasic(Hashtable<String, String[]> Container, String[] elements, int feature){

        int k = 0;
        System.out.println("\n== Printing Characters ==\n\n" + header);
        ArrayList<String> keys = new ArrayList<>(Container.keySet());

        // Goes through each element and compares them (by order)
        for (int i = 0; i < elements.length; i++){

            for (int j = 0; j < Container.size(); j++){

                String data = Container.get(keys.get(j))[feature]; // Data representing the feature of each character
                // Checks if the feature is equal
                if (data.equalsIgnoreCase(elements[i])){
                    printCharacterInfo(keys.get(j), Container.get(keys.get(j)), k); // Prints Info
                    k += 1;
                }
            }
        }

    }

    // Method that uses the sort basics method, changing the feature and the array of order
    static void sortCharacters(String sort, Hashtable<String, String[]> Container){

        switch (sort.toUpperCase()){

            // Sorting by alphabet will be the same as printing the characters
            case "A":
                System.out.println(" ");
                printAllCharacters(Container);
                break;


            case "B":
                String[] rarity = {"4 Star", "5 Star"}; // Order of Printing
                sortBasic(Container, rarity, 0); // 0 is the index of the rarity in the array
                break;

            case "C":
                String[] paths = {"Abundance", "Destruction","Erudition","Harmony","Nihility", "Preservation", "The Hunt"}; // Order pf Printing
                sortBasic(Container, paths, 1); // 1 is the index of the path in the array
                break;

            case "D":
                String[] elements = {"Fire","Ice","Imaginary","Lightning", "Physical", "Quantum", "Wind"}; // Order of Printing
                sortBasic(Container, elements, 2); // 2 is the index of the elements in the array
                break;

            case "E":
                String[] factions = {"Astral Express","Belobog","Garden of Recollection","Herta Space Station","Intelligentsia Guild","IPC","Knight of Beauty","Masked Fools","Penacony","Self Anihilator", "Stellaron Hunter" ,"The Xianzhou Loufu"}; // Order of Printing
                sortBasic(Container, factions, 3); // 3 is the index of the faction in the array
                break;
        }
    }

}
