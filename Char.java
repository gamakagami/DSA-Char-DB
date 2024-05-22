import java.util.*;
public class Char{
    public static void main(String[] args){

        Character chars = new Character();

        String[] Action_List = {"A", "B", "C", "D", "Q"};

        Hashtable<String, String[]> Retrieve_Information = new Hashtable<>(48);

        for (int i = 0; i < chars.characterContainer.length; i++){
            Retrieve_Information.put(chars.characterContainer[i], chars.characterInformation[i]);
        }

        Scanner scn = new Scanner(System.in);

        System.out.println("Welcome to a Honkai Star Rail Database System");
        boolean loop = true;

        while (loop) {
            System.out.println("----------------------------------\nA: Get Rarity\nB: Get Path\nC: Get Element\nD: Print all Characters\nQ: Quit\n----------------------------------\nPlease enter an action you want to perform: ");

            boolean action_present = false;
            String action = "";

            while (!action_present) {
                action = scn.nextLine();

                for (int i = 0; i < Action_List.length; i++) {
                    if (action.equalsIgnoreCase(Action_List[i])) {
                        action_present = true;
                        break;
                    }
                }

                if (!action_present) {
                    System.out.println("Enter a valid action (A, B, C, D)");
                }
            }

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
                    System.out.println("Character:          Rarity:             Path:               Element:            Faction:");

                    printWithSpace(chars.characterContainer, chars.characterInformation);
                    loop = proceed();
                    break;

                case "Q":
                    System.out.println("Quitting program..");
                    loop = false; break;
            }
        }

    }

    static void getInfo(String Character, Hashtable<String, String[]> Information, Integer Option) {

        Character = Character.substring(0,1).toUpperCase() + Character.substring(1, Character.length()).toLowerCase();
        String[] Info = Information.get(Character.substring(0,1).toUpperCase() + Character.substring(1,Character.length()).toLowerCase());

        switch (Option){
            case 0:
                System.out.println(Character + " is a " + Info[Option] + " character.");;
                break;

            case 1:
                System.out.println(Character + " is a " + Info[Option] + " path character.");
                break;

            case 2:
                System.out.println(Character + "'s element is " + Info[Option] + ".");
                break;
        }

    }

    static String getCharacter(Scanner scn, String[] Characters){

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
            if (!present){
                System.out.println("Please enter a valid Character");
            }
        }
        return Char;
    }

    static void printWithSpace(String[] characterContainer, String[][] characterInformation){

        for (int i = 0; i < characterContainer.length; i++) {
            System.out.print(characterContainer[i]);

            int nameLength = characterContainer[i].length();
            for (int j = nameLength; j < 20; j++) {
                System.out.print(" ");
            }

            for (int a = 0; a<3; a++) {
                System.out.print(characterInformation[i][a]);
                int length = characterInformation[i][a].length();
                for (int k = length; k < 20; k++) {
                    System.out.print(" ");
                }
            }

            System.out.println(characterInformation[i][3]);
        }
    }

    static boolean proceed(){

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

            if (loop){
                System.out.print("Please enter Y or N ");
            }
        }

        return continueTheProgram;
    }

}
