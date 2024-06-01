import java.util.*;

public class Methods {
    static void getInfo(String character, Hashtable<String, LinkedList<String>> information, Integer option) {

        character = character.substring(0, 1).toUpperCase() + character.substring(1).toLowerCase();
        LinkedList<String> info = information.get(character);

        switch (option) {
            case 0:
                System.out.println(character + " is a " + info.get(option) + " character.");
                break;

            case 1:
                System.out.println(character + " is a " + info.get(option) + " path character.");
                break;

            case 2:
                System.out.println(character + "'s element is " + info.get(option) + ".");
                break;
        }
    }

    static String getCharacter(Scanner scn, LinkedList<String> characters) {

        boolean present = false;
        String character = "";

        System.out.println("Please Enter a Character Name: ");

        while (!present) {
            character = scn.nextLine();
            character = character.replace(" ", "");

            for (String i : characters) {
                if (i.equalsIgnoreCase(character)) {
                    present = true;
                    break;
                }
            }
            if (!present) {
                System.out.println("Please enter a valid Character");
            }
        }
        return character;
    }

    static void printAllCharacters(LinkedList<String> characterContainer, LinkedList<LinkedList<String>> characterInformation) {

        System.out.println("Character:          Rarity:             Path:               Element:            Faction:");

        for (int i = 0; i < characterContainer.size(); i++) {
            printCharacterInfo(characterContainer.get(i), characterInformation.get(i));
        }
    }

    static void printCharacterInfo(String character, LinkedList<String> info) {
        System.out.print(character);
        int nameLength = character.length();
        for (int j = nameLength; j < 20; j++) {
            System.out.print(" ");
        }

        for (int a = 0; a < 3; a++) {
            System.out.print(info.get(a));
            int length = info.get(a).length();
            for (int k = length; k < 20; k++) {
                System.out.print(" ");
            }
        }

        System.out.println(info.get(3));
    }

    static boolean proceed() {

        System.out.println("Would you like to Continue? (Y/N)");
        Scanner scn = new Scanner(System.in);
        boolean loop = true;
        boolean continueTheProgram = false;

        while (loop) {
            String proceed = scn.nextLine();
            if (proceed.equalsIgnoreCase("Y")) {
                continueTheProgram = true;
                loop = false;

            } else if (proceed.equalsIgnoreCase("N")) {
                loop = false;
            }

            if (loop) {
                System.out.print("Please enter Y or N ");
            }
        }

        System.out.println("Exiting...");
        return continueTheProgram;
    }

    static String checkInput(Scanner scn, String[] targetActions) {

        boolean action_present = false;
        String action = "";

        while (!action_present) {
            action = scn.nextLine();

            for (String targetAction : targetActions) {
                if (action.equalsIgnoreCase(targetAction)) {
                    action_present = true;
                    break;
                }
            }

            if (!action_present) {
                System.out.println("Please enter a valid action");
            }
        }
        return action;
    }

    static void filter(Scanner scn, String input, LinkedList<String> characterContainer, LinkedList<LinkedList<String>> characterInformation) {

        switch (input.toUpperCase()) {

            case "A":
                System.out.print("Please enter an alphabet to filter by: ");
                String alphabet = checkInput(scn, new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"});

                for (String s : characterContainer) {
                    if (String.valueOf(s.charAt(0)).equalsIgnoreCase(alphabet)) {
                        printCharacterInfo(s, characterInformation.get(characterContainer.indexOf(s)));
                    }
                }
                break;

            case "B":
                System.out.print("Please enter an element to filter by (Fire, Ice, Lightning, Physical, Wind, Quantum, Imaginary, Adaptive): ");
                String element = checkInput(scn, new String[]{"Fire", "Ice", "Lightning", "Physical", "Wind", "Quantum", "Imaginary", "Adaptive"});
                for (int i = 0; i < characterContainer.size(); i++) {
                    if (characterInformation.get(i).get(2).equalsIgnoreCase(element)) {
                        printCharacterInfo(characterContainer.get(i), characterInformation.get(i));
                    }
                }
                break;

            case "C":
                System.out.print("Please enter a path to filter by (Nihility, Erudition, Destruction, Harmony, The Hunt, Preservation, Abundance, Adaptive): ");
                String path = checkInput(scn, new String[]{"Nihility", "Erudition", "Destruction", "Harmony", "The Hunt", "Preservation", "Abundance", "Adaptive"});
                for (int i = 0; i < characterContainer.size(); i++) {
                    if (characterInformation.get(i).get(1).equalsIgnoreCase(path)) {
                        printCharacterInfo(characterContainer.get(i), characterInformation.get(i));
                    }
                }
                break;

            case "D":
                System.out.print("Please enter a faction to filter by (Herta Space Station, IPC, The Xianzhou Loufu, Stellaron Hunter, Belobog, Astral Express, Intelligentsia Guild, Penacony, Masked Fools): ");
                String faction = checkInput(scn, new String[]{"Herta Space Station", "IPC", "The Xianzhou Loufu", "Stellaron Hunter", "Belobog", "Astral Express", "Intelligentsia Guild", "Penacony", "Masked Fools"});
                for (int i = 0; i < characterContainer.size(); i++) {
                    if (characterInformation.get(i).get(3).equalsIgnoreCase(faction)) {
                        printCharacterInfo(characterContainer.get(i), characterInformation.get(i));
                    }
                }
                break;

            case "E":
                System.out.print("Please enter a rarity to filter by (4 Star, 5 Star): ");
                String rarity = checkInput(scn, new String[]{"4 Star", "5 Star"});
                filterByRarity(rarity, characterContainer, characterInformation);
                break;
        }
    }

    static void filterByRarity(String rarity, LinkedList<String> characterContainer, LinkedList<LinkedList<String>> characterInformation) {
        System.out.println("Characters with Rarity " + rarity + ":");
        System.out.println("Character:          Rarity:             Path:               Element:            Faction:");

        for (int i = 0; i < characterContainer.size(); i++) {
            if (characterInformation.get(i).size() > 0 && characterInformation.get(i).get(0).equalsIgnoreCase(rarity)) {
                printCharacterInfo(characterContainer.get(i), characterInformation.get(i));
            }
        }
    }

    static void sortBasic(LinkedList<String> characters, LinkedList<LinkedList<String>> characterInfo, String[] elements, int feature) {

        for (String element : elements) {
            for (int j = 0; j < characters.size(); j++) {
                if (characterInfo.get(j).get(feature).equalsIgnoreCase(element)) {
                    printCharacterInfo(characters.get(j), characterInfo.get(j));
                }
            }
        }
    }

    static void sortCharacters(String sort, LinkedList<String> characters, LinkedList<LinkedList<String>> characterInfo) {

        switch (sort.toUpperCase()) {
            case "A":
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

