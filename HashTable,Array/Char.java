import java.util.*;

public class Char {
    public static void main(String[] args) {

        Character chars = new Character();

        Hashtable<String, String[]> Retrieve_Information = new Hashtable<>(48);

        for (int i = 0; i < chars.characterContainer.length; i++) {
            Retrieve_Information.put(chars.characterContainer[i], chars.characterInformation[i]);
        }

        Scanner scn = new Scanner(System.in);

        System.out.println("Welcome to a Honkai Star Rail Database System");
        boolean loop = true;

        while (loop) {
            System.out.println("----------------------------------\nA: Get Rarity\nB: Get Path\nC: Get Element\nD: Print all Characters\nE: Filter Characters\nQ: Quit\n----------------------------------\nPlease enter an action you want to perform: ");

            boolean action_present = false;
            String action = "";

            action = checkInput(scn, new String[]{"A", "B", "C", "D", "E", "Q"});

            switch (action.toUpperCase()) {
                case "A":
                    String character = getCharacter(scn, chars.characterContainer);
                    getInfo(character, Retrieve_Information, 0);
                    loop = proceed();
                    break;

                case "B":
                    character = getCharacter(scn, chars.characterContainer);
                    getInfo(character, Retrieve_Information, 1);
                    loop = proceed();
                    break;

                case "C":
                    character = getCharacter(scn, chars.characterContainer);
                    getInfo(character, Retrieve_Information, 2);
                    loop = proceed();
                    break;

                case "D":
                    System.out.println("                                         || Printing Characters Information ||\n ");
                    printWithSpace(chars.characterContainer, chars.characterInformation);
                    loop = proceed();
                    break;

                case "E":
                    System.out.print("Filter Characters By: \nA: Alphabet\nB: Element\nC: Path\nD: Faction\nE: Rarity\n");
                    String filter = checkInput(scn, new String[]{"A","B","C","D","E"});

                    filter(scn, filter, chars.characterContainer, chars.characterInformation);
                    loop = proceed();
                    break;

                case "Q":
                    System.out.println("Quitting program..");
                    loop = false;
                    break;
            }
        }

    }

    static void getInfo(String Character, Hashtable<String, String[]> Information, Integer Option) {

        Character = Character.substring(0, 1).toUpperCase() + Character.substring(1, Character.length()).toLowerCase();
        String[] Info = Information.get(Character.substring(0, 1).toUpperCase() + Character.substring(1, Character.length()).toLowerCase());

        switch (Option) {
            case 0:
                System.out.println(Character + " is a " + Info[Option] + " character.");
                break;

            case 1:
                System.out.println(Character + " is a " + Info[Option] + " path character.");
                break;

            case 2:
                System.out.println(Character + "'s element is " + Info[Option] + ".");
                break;
        }
    }

    static String getCharacter(Scanner scn, String[] Characters) {

        boolean present = false;
        String Char = "";

        System.out.println("Please Enter a Character Name: ");

        while (!present) {
            Char = scn.nextLine();
            Char = Char.replace(" ", "");

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
        return Char;
    }

    static void printWithSpace(String[] characterContainer, String[][] characterInformation) {

        System.out.println("Character:          Rarity:             Path:               Element:            Faction:");

        for (int i = 0; i < characterContainer.length; i++) {
            printCharacterInfo(characterContainer[i], characterInformation[i]);
        }
    }

    static void printCharacterInfo(String character, String[] info) {
        System.out.print(character);
        int nameLength = character.length();
        for (int j = nameLength; j < 20; j++) {
            System.out.print(" ");
        }

        for (int a = 0; a < 3; a++) {
            System.out.print(info[a]);
            int length = info[a].length();
            for (int k = length; k < 20; k++) {
                System.out.print(" ");
            }
        }

        System.out.println(info[3]);
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
                continueTheProgram = false;
                loop = false;
            }

            if (loop) {
                System.out.print("Please enter Y or N ");
            }
        }

        return continueTheProgram;
    }

    static String checkInput(Scanner scn, String[] targetActions) {

        boolean action_present = false;
        String action = "";

        while (!action_present) {
            action = scn.nextLine();

            for (int i = 0; i < targetActions.length; i++) {
                if (action.equalsIgnoreCase(targetActions[i])) {
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


    static void filter(Scanner scn, String input, String[] characterContainer, String[][] characterInformation){

        switch(input.toUpperCase()) {

            case "A":
                System.out.print("Please enter an alphabet to filter by: ");
                String alphabet = checkInput(scn, new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"});

                for (String s : characterContainer){
                    if (String.valueOf(s.charAt(0)).equalsIgnoreCase(alphabet)){
                        printCharacterInfo(s, characterInformation[Arrays.asList(characterContainer).indexOf(s)]);
                    }
                }
                break;

            case "B":
                System.out.print("Please enter an element to filter by (Fire, Ice, Lightning, Physical, Wind, Quantum, Imaginary, Adaptive): ");
                String element = checkInput(scn, new String[]{"Fire", "Ice", "Lightning", "Physical", "Wind", "Quantum", "Imaginary", "Adaptive"});
                for (int i = 0; i < characterContainer.length; i++) {
                    if (characterInformation[i][2].equalsIgnoreCase(element)) {
                        printCharacterInfo(characterContainer[i], characterInformation[i]);
                    }
                }
                break;

            case "C":
                System.out.print("Please enter a path to filter by (Nihility, Erudition, Destruction, Harmony, The Hunt, Preservation, Abundance, Adaptive): ");
                String path = checkInput(scn, new String[]{"Nihility", "Erudition", "Destruction", "Harmony", "The Hunt", "Preservation", "Abundance", "Adaptive"});
                for (                int i = 0; i < characterContainer.length; i++) {
                    if (characterInformation[i][1].equalsIgnoreCase(path)) {
                        printCharacterInfo(characterContainer[i], characterInformation[i]);
                    }
                }
                break;

            case "D":
                System.out.print("Please enter a faction to filter by (Herta Space Station, IPC, The Xianzhou Loufu, Stellaron Hunter, Belobog, Astral Express, Intelligentsia Guild, Penacony, Masked Fools): ");
                String faction = checkInput(scn, new String[]{"Herta Space Station", "IPC", "The Xianzhou Loufu", "Stellaron Hunter", "Belobog", "Astral Express", "Intelligentsia Guild", "Penacony", "Masked Fools"});
                for (int i = 0; i < characterContainer.length; i++) {
                    if (characterInformation[i][3].equalsIgnoreCase(faction)) {
                        printCharacterInfo(characterContainer[i], characterInformation[i]);
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

    static void filterByRarity(String rarity, String[] characterContainer, String[][] characterInformation) {
        System.out.println("Characters with Rarity " + rarity + ":");
        System.out.println("Character:          Rarity:             Path:               Element:            Faction:");

        for (int i = 0; i < characterContainer.length; i++) {
            if (characterInformation[i].length > 0 && characterInformation[i][0].equalsIgnoreCase(rarity)) {
                printCharacterInfo(characterContainer[i], characterInformation[i]);
            }
        }
    }
}