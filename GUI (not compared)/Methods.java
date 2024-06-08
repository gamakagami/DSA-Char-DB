import javax.swing.*;
import java.util.Hashtable;
import java.util.Scanner;

public class Methods{

    // Header that is printed when printing characters
    static String header = "Character:            Rarity:               Path:                 Element:              Faction:\n";

    // Used to get the rarity, path, and the element of a character
    static void getInfo(String Character, Hashtable<String, String[]> Information, Integer Option) {

        Character = Character.replace(" ", "");
        Character = Character.substring(0, 1).toUpperCase() + Character.substring(1).toLowerCase(); // To make the first letter capitalized and the rest to be lowercase, so it will match the hashtable keys
        String[] Info = Information.get(Character); // Receives the array of information regarding the character

        switch (Option) {
            case 0:
                // The index 0 in the array represents the rarity of the character
                JOptionPane.showMessageDialog(null, "\n== " + Character + " is a " + Info[Option] + " Character ==");
                break;

            case 1:
                // The index 1 in the array represents the path of the character
                JOptionPane.showMessageDialog(null, "\n== " + Character + " is a " + Info[Option] + " Path Character ==");
                break;

            case 2:
                // The index 2 in the array represents the element of the character
                JOptionPane.showMessageDialog(null,"\n== " + Character + "'s element is " + Info[Option] + " ==");
                break;
        }
    }

    // Method that ensures the character entered is valid
    static String getCharacter(String[] Characters) {

        String charName = JOptionPane.showInputDialog("Please Enter a Character Name: ");

        return checkInput(Characters, charName); // Returns the valid character name
    }

    // Method that prints the information of all characters
    static void printAllCharacters(Hashtable<String, String[]> Container, String[] characterContainer) {

        String print = "";

        print += header + "\n";

        for (int i = 0; i < Container.size(); i++) {
            print = printCharacterInfo(characterContainer[i], Container.get(characterContainer[i]), i, print); // Prints Character Information
        }

        int x = print.indexOf("29"); // To separate the printing as it will not fit in one screen

        // Printing in 2 different sections
        JOptionPane.showMessageDialog(null, print.substring(0, x));
        JOptionPane.showMessageDialog(null,print.substring(x, print.length()));
    }

    // The method that takes in the character name and the information array as an input to display their information with proper spacing
    static String printCharacterInfo(String character, String[] info, int no, String print) {

        // It utilizes the length of the information printed to provide equal distance from each category of information by using th for loop.

        print += (no + 1 + ". " + character);
        int nameLength = (character + String.valueOf(no + 1) + ". ").length();
        for (int j = nameLength; j < 22; j++) { // Print is the string that is continuously appended with other strings (The same like how it is printed) so it can be printed in one screen in JOption pane
            print += (" ");
        }

        // Uses a as the index for the information array
        for (int a = 0; a < 3; a++) {
            print += (info[a]);

            int length = info[a].length();
            for (int k = length; k < 22; k++) {
                print += (" ");
            }
        }

        print += (info[3] + "\n"); // Println to create space from the previous character

        return print;
    }

    // Method that requests user confirmation whether to continue or stop
    static boolean proceed() {

        String input = JOptionPane.showInputDialog("\nWould you like to Continue? (Y/N): ");

        boolean continueTheProgram = false;

        input = checkInput(new String[]{"Y", "N"}, input);

        // Will print if the user chooses to exit the program
        if (input.equalsIgnoreCase("N")){
            System.out.println("\n== Exiting the Program ==");
        } else continueTheProgram = true;

        return continueTheProgram;
    }

    // A method that takes in scanner and an array if targetActions representing the input wanted
    static String checkInput(String[] target, String action) {

        boolean action_present = false;

        while (!action_present) {

            // Checking if the user input is equal to any of the target inputs
            for (String targetInput : target) {

                String actions = action.replace(" ", "");
                if (action.equalsIgnoreCase(targetInput) || actions.equalsIgnoreCase(targetInput)) {
                    action_present = true; // Stopping the loop
                    break;
                }
            }

            if (!action_present) {
                action = JOptionPane.showInputDialog("Please enter a valid input");
            }
        }
        return action; // Returns the valid action
    }

    // Method to make the code more efficient, checking features by taking the option representing the index and filter string
    static void filterBasics(Hashtable<String, String[]> Container, int feature, String filter, String[] characterContainer){

        System.out.println("\n== Printing Characters ==\n" + header);

        String print = "";
        int j = 0;
        // For loop to check through the value of the hashtable, which is an array. It checks through the feature it is filtering by (using the index). If it is equivalent, will print the character information
        for (int i = 0; i < Container.size(); i++) {

            String data = Container.get(characterContainer[i])[feature]; // Represents the feature of the character
            if (data.equalsIgnoreCase(filter) || data.replace(" ", "").equalsIgnoreCase(filter)) {
                printCharacterInfo(characterContainer[i], Container.get(characterContainer[i]), j, print); // Prints Info
                j += 1;
            }
        }
    }

    // Method that filters based on the input taken, taking in the Hashtable
    static void filter(String input, Hashtable<String, String[]> Container, String[] characterContainer){

        switch(input.toUpperCase()) {

            // Filter characters by alphabet entered
            case "A":
                String alphabet = JOptionPane.showInputDialog("Enter an alphabet to filter by:");

                // To check if the input is one of the alphabets
                alphabet = checkInput(new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"}, alphabet);
                String print = "";

                int i = 0;
                // Checks if the alphabet of each character is the same with the input entered, if it is the same, will display the character information
                for (String s : Container.keySet()){
                    if (String.valueOf(s.charAt(0)).equalsIgnoreCase(alphabet)){
                        print = printCharacterInfo(s, Container.get(characterContainer[i]), i, print); // Finds the index of the character name, and puts the character information array as an input to the method
                        i += 1;
                    }
                }
                JOptionPane.showMessageDialog(null, print);
                break;

            // Filters by the element
            case "B":
                String element = JOptionPane.showInputDialog("Please enter an element to filter by (Adaptive, Fire, Ice, Lightning, Physical, Wind, Quantum, Imaginary, Adaptive): ");
                element = checkInput(new String[]{"Adaptive","Fire", "Ice", "Lightning", "Physical", "Wind", "Quantum", "Imaginary", "Adaptive"}, element); // Ensures that the element entered is valid

                filterBasics(Container, 2, element, characterContainer);

                break;

            // Filters by the path
            case "C":
                String path = JOptionPane.showInputDialog("Please enter a path to filter by (Adaptive, Nihility, Erudition, Destruction, Harmony, The Hunt, Preservation, Abundance, Adaptive): ");
                path = checkInput(new String[]{"Adaptive","Nihility", "Erudition", "Destruction", "Harmony", "TheHunt", "Preservation", "Abundance", "Adaptive"}, path); // Ensure input is valid

                filterBasics(Container, 1, path, characterContainer);
                break;

            // Filters by the faction
            case "D":
                String faction = JOptionPane.showInputDialog("Please enter a faction to filter by (Herta Space Station, IPC, The Xianzhou Loufu, Stellaron Hunter, Belobog, Astral Express, Intelligentsia Guild, Penacony, Masked Fools): ");
                faction = checkInput(new String[]{"HertaSpaceStation", "IPC", "TheXianzhouLoufu", "StellaronHunter", "Belobog", "AstralExpress", "IntelligentsiaGuild", "Penacony", "MaskedFools"}, faction);

                filterBasics(Container, 3, faction, characterContainer);
                break;

            // Filters by Rarity
            case "E":
                String rarity = JOptionPane.showInputDialog("Please enter a rarity to filter by (4 Star, 5 Star): ");
                rarity = checkInput(new String[]{"4Star", "5Star"}, rarity); // Ensure Input is valid

                filterBasics(Container, 0, rarity, characterContainer);
                break;
        }
    }

    // Sorting basic Method, where the feature indicates what index of the character information will be checked, and the elements representing the order of printing
    static void sortBasic(Hashtable<String, String[]> Container, String[] elements, int feature, String[] characterContainer){

        String print = "";
        int numberInterface = 0;

        // Goes through each element and compares them (by order)

        for (String element : elements){

            for (String character : characterContainer){
                if (Container.get(character)[feature].equalsIgnoreCase(element)){

                    print = printCharacterInfo(character, Container.get(character), numberInterface, print);
                    numberInterface ++;
                }
            }
        }

        int x = print.indexOf("29");
        JOptionPane.showMessageDialog(null, print.substring(0, x));
        JOptionPane.showMessageDialog(null, print.substring(x));

    }

    // Method that uses the sort basics method, changing the feature and the array of order
    static void sortCharacters(String sort, Hashtable<String, String[]> Container, String[] characterContainer){

        switch (sort.toUpperCase()){

            // Sorting by alphabet will be the same as printing the characters
            case "A":
                System.out.println(" ");
                printAllCharacters(Container, characterContainer);
                break;


            case "B":
                String[] rarity = {"4 Star", "5 Star"}; // Order of Printing
                sortBasic(Container, rarity, 0, characterContainer); // 0 is the index of the rarity in the array
                break;

            case "C":
                String[] paths = {"Abundance", "Adaptive", "Destruction","Erudition","Harmony","Nihility", "Preservation", "The Hunt"}; // Order pf Printing
                sortBasic(Container, paths, 1, characterContainer); // 1 is the index of the path in the array
                break;

            case "D":
                String[] elements = {"Adaptive","Fire","Ice","Imaginary","Lightning", "Physical", "Quantum", "Wind"}; // Order of Printing
                sortBasic(Container, elements, 2, characterContainer); // 2 is the index of the elements in the array
                break;

            case "E":
                String[] factions = {"Astral Express","Belobog","Garden of Recollection","Herta Space Station","Intelligentsia Guild","IPC","Knight of Beauty","Masked Fools","Penacony","Self Anihilator", "Stellaron Hunter" ,"The Xianzhou Loufu"}; // Order of Printing
                sortBasic(Container, factions, 3, characterContainer); // 3 is the index of the faction in the array
                break;
        }
    }

}
