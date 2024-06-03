import java.util.Hashtable;
import java.util.Scanner;
import java.util.Comparator;


public class Methods {
    static String header = "Character:            Rarity:               Path:                 Element:              Faction:\n";
    static void getInfo(String character, Hashtable<String, Character> information, Integer option) {
        character = character.substring(0, 1).toUpperCase() + character.substring(1).toLowerCase();

        Character character1 = information.get(character);

        if (character == null) {
            System.out.println("Character not found.");
            return;
        }

        switch (option) {
            case 0:
                System.out.println(character1.name + " is a " + character1.rarity + " character.");
                break;
            case 1:
                System.out.println(character1.name + " is a " + character1.path + " path character.");
                break;
            case 2:
                System.out.println(character1.name + "'s element is " + character1.element + ".");
                break;
        }
    }

    static String getCharacter(Scanner scn, Hashtable<String, Character> Information) {

        boolean present = false;
        String Char = "";

        System.out.println("Please Enter a Character Name: ");

        while (!present) {
            Char = scn.nextLine();
            Char = Char.replace(" ", "");

            for (String key : Information.keySet()) {
                if (key.equalsIgnoreCase(Char)) {
                    present = true;
                    break;
                }
            }
            if (!present) {
                System.out.println("Please enter a valid Character");
            }
        }
        return Char;
    }


    // Method to print all character information from the hashtable
    static void printCharacterInfo(Hashtable<String, Character> hashtable) {
        for (String key : hashtable.keySet()) {
            Character character = hashtable.get(key);
            System.out.println(character.name + ", " + character.rarity + ", " + character.path + ", " + character.element + ", " + character.faction);
        }
    }

    // Method to ask the user if they want to continue the program
    static boolean proceed() {
        System.out.println("\n Would you like to Continue? (Y/N): ");
        Scanner scn = new Scanner(System.in);
        boolean continueTheProgram = false;

        String input = checkInput(scn, new String[]{"Y", "N"});
        if (input.equalsIgnoreCase("N")) {
            System.out.println("\n== Exiting the Program ==");
        } else continueTheProgram = true;

        return continueTheProgram;
    }

    // Method to check and validate user input against a list of valid options
    static String checkInput(Scanner scn, String[] target) {
        boolean action_present = false;
        String action = "";

        while (!action_present) {
            action = scn.nextLine();
            for (String targetInput : target) {
                action = action.replace(",", ""); // Remove commas
                if (action.equalsIgnoreCase(targetInput)) {
                    action_present = true;
                    break;
                }
            }

            if (!action_present) {
                System.out.println("Please enter a valid input");
            }
        }
        return action;
    }

    // Method to filter characters based on user input criteria
    static void filter(Scanner scn, String input, Hashtable<String, Character> container) {
        switch (input.toUpperCase()) {
            case "A":
                System.out.print("Please enter an alphabet to filter by: ");
                String alphabet = scn.nextLine().trim().substring(0, 1).toUpperCase();
                System.out.println("\n");

                container.values().stream()
                        .filter(character -> character.getName().toUpperCase().startsWith(alphabet))
                        .sorted(Comparator.comparing(Character::getName))
                        .forEach(Methods::printCharacterDetails);
                break;

            case "B":
                System.out.print("Please enter an element to filter by (Fire, Ice, Lightning, Physical, Wind, Quantum, Imaginary, Adaptive): ");
                String element = checkInput(scn, new String[]{"Fire", "Ice", "Lightning", "Physical", "Wind", "Quantum", "Imaginary", "Adaptive"});

                container.values().stream()
                        .filter(character -> character.getElement().equalsIgnoreCase(element))
                        .sorted(Comparator.comparing(Character::getName))
                        .forEach(Methods::printCharacterDetails);
                break;

            case "C":
                System.out.print("Please enter a path to filter by (Nihility, Erudition, Destruction, Harmony, The Hunt, Preservation, Abundance, Adaptive): ");
                String path = checkInput(scn, new String[]{"Nihility", "Erudition", "Destruction", "Harmony", "The Hunt", "Preservation", "Abundance", "Adaptive"});

                container.values().stream()
                        .filter(character -> character.getPath().equalsIgnoreCase(path))
                        .sorted(Comparator.comparing(Character::getName))
                        .forEach(Methods::printCharacterDetails);
                break;

            case "D":
                System.out.print("Please enter a faction to filter by (Herta Space Station, IPC, The Xianzhou Loufu, Stellaron Hunter, Belobog, Astral Express, Intelligentsia Guild, Penacony, Masked Fools): ");
                String faction = checkInput(scn, new String[]{"Herta Space Station", "IPC", "The Xianzhou Loufu", "Stellaron Hunter", "Belobog", "Astral Express", "Intelligentsia Guild", "Penacony", "Masked Fools"});

                container.values().stream()
                        .filter(character -> character.getFaction().equalsIgnoreCase(faction))
                        .sorted(Comparator.comparing(Character::getName))
                        .forEach(Methods::printCharacterDetails);
                break;

            case "E":
                System.out.print("Please enter a rarity to filter by (4 Star, 5 Star): ");
                String rarity = checkInput(scn, new String[]{"4 Star", "5 Star"});

                container.values().stream()
                        .filter(character -> character.getRarity().equalsIgnoreCase(rarity))
                        .sorted(Comparator.comparing(Character::getName))
                        .forEach(Methods::printCharacterDetails);
                break;
        }
    }
    static void printCharacterDetails(Character character) {
        System.out.println(character.name + ", " + character.rarity + ", " + character.path + ", " + character.element + ", " + character.faction);
    }

    static void sortCharacters(String sort, Hashtable<String, Character> character) {
        switch (sort.toUpperCase()) {
            case "A":
                System.out.println("\n== Printing Characters in Alphabetical Order ==\n");
                character.keySet().stream()
                        .sorted()
                        .map(character::get) // Get the character object based on the key
                        .forEach(Methods::printCharacterDetails); // Print the details of each character
                break;

            case "B":
                System.out.println("\n== Print Characters by Rarity ==\n");
                character.values().stream()
                        .sorted(Comparator.comparing(Character::getRarity))
                        .forEach(Character -> {
                            Methods.printCharacterDetails(Character);
                            System.out.println(); // Add a line break after each character's details
                        });
                break;
            case "C":
                System.out.println("\n== Printing Characters by Path ==\n");
                character.values().stream()
                        .sorted(Comparator.comparing(Character::getPath))
                        .forEach(Character -> {
                            Methods.printCharacterDetails(Character);
                            System.out.println(); // Add a line break after each character's details
                        });
                break;
            case "D":
                System.out.println("\n== Printing Characters by Element ==\n");
                character.values().stream()
                        .sorted(Comparator.comparing(Character::getElement))
                        .forEach(Character -> {
                            Methods.printCharacterDetails(Character);
                            System.out.println(); // Add a line break after each character's details
                        });
                break;
            case "E":
                System.out.println("\n== Printing Characters by Faction ==\n");
                character.values().stream()
                        .sorted(Comparator.comparing(Character::getFaction).thenComparing(Character::getName)) // Sort by faction, then by name
                        .forEach(Character -> {
                            Methods.printCharacterDetails(Character);
                            System.out.println(); // Add a line break after each character's details
                        });
                break;
        }
    }
}




