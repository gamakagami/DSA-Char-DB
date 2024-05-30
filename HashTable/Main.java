import java.util.*;

public class Main extends Methods {
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
            System.out.println("----------------------------------\nA: Get Rarity\nB: Get Path\nC: Get Element\nD: Print all Characters\nE: Filter Characters\nF: Display Information of a Chracter\nG: Sort Characters\nQ: Quit\n----------------------------------\nPlease enter an action you want to perform: ");

            boolean action_present = false;
            String action = "";

            action = checkInput(scn, new String[]{"A", "B", "C", "D", "E", "F", "G", "Q"});

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
                    printAllCharacters(chars.characterContainer, chars.characterInformation);
                    loop = proceed();
                    break;

                case "E":
                    System.out.print("Filter Characters By: \nA: Alphabet\nB: Element\nC: Path\nD: Faction\nE: Rarity\n");
                    String filter = checkInput(scn, new String[]{"A","B","C","D","E"});

                    filter(scn, filter, chars.characterContainer, chars.characterInformation);
                    loop = proceed();
                    break;

                case "F":
                    System.out.println("Enter a charfacter name: ");
                    String name = checkInput(scn, chars.characterContainer);

                    for (int i = 0; i < chars.characterContainer.length; i++){

                        name = name.replace(" ","");
                        if (chars.characterContainer[i].equalsIgnoreCase(name)){
                            System.out.println("Character:          Rarity:             Path:               Element:            Faction:");
                            printCharacterInfo(chars.characterContainer[i], chars.characterInformation[i]);
                        }
                    }
                    loop = proceed();
                    break;

                case "G":
                    System.out.print("Sort Characters By: \nA: Alphabet\nB: Rarity\nC: Path\nD: Element\nE: Faction\n");
                    String sort = checkInput(scn, new String[]{"A","B","C","D","E"});
                    sortCharacters(sort, chars.characterContainer, chars.characterInformation);
                    loop = proceed();
                    break;


                case "Q":
                    System.out.println("Quitting program..");
                    loop = false;
                    break;
            }
        }

    }
}
