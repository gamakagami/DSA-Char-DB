import java.util.Scanner;

public class Main extends Methods {
    public static void main(String[] args) {
        Character chars = new Character();

        // Initializing the binary search tree and adding elements (Name : Array of Information)
        Tree Retrieve_Information = new Tree();
        for (int i = 0; i < chars.characterContainer.length; i++) {
            Retrieve_Information.put(chars.characterContainer[i], chars.characterInformation[i]);
        }

        Scanner scn = new Scanner(System.in);

        System.out.println("Welcome to a Honkai Star Rail Database System");
        boolean loop = true; // If the loop becomes false, the program will stop (Determined by the method proceed)

        while (loop) {
            System.out.println("----------------------------------\nA: Get Rarity\nB: Get Path\nC: Get Element\nD: Print all Characters\nE: Filter Characters\nF: Display Information of a Character\nG: Sort Characters\nQ: Quit\n----------------------------------\nPlease enter an action you want to perform: ");

            String action = checkInput(scn, new String[]{"A", "B", "C", "D", "E", "F", "G", "Q"}); // To ensure user input is valid

            // To perform different actions based on user input
            switch (action.toUpperCase()) {

                // Getting Rarity
                case "A":
                    String character = getCharacter(scn, chars.characterContainer);
                    getInfo(character, Retrieve_Information, 0);
                    loop = proceed();
                    break;

                // Getting Path
                case "B":
                    character = getCharacter(scn, chars.characterContainer);
                    getInfo(character, Retrieve_Information, 1);
                    loop = proceed();
                    break;

                // Getting Element
                case "C":
                    character = getCharacter(scn, chars.characterContainer);
                    getInfo(character, Retrieve_Information, 2);
                    loop = proceed();
                    break;

                // Printing all Characters
                case "D":
                    System.out.println("                                         || Printing Characters Information ||\n ");
                    printAllCharacters(chars.characterContainer, chars.characterInformation);
                    loop = proceed();
                    break;

                // Filtering
                case "E":
                    System.out.print("Filter Characters By: \nA: Alphabet\nB: Element\nC: Path\nD: Faction\nE: Rarity\n");
                    String filter = checkInput(scn, new String[]{"A", "B", "C", "D", "E"});

                    filter(scn, filter, chars.characterContainer, chars.characterInformation);
                    loop = proceed();
                    break;

                // Displaying information of a character
                case "F":
                    System.out.println("Enter a character name: ");
                    String name = checkInput(scn, chars.characterContainer);

                    for (int i = 0; i < chars.characterContainer.length; i++) {

                        name = name.replace(" ", ""); // To ensure no error happens due to space

                        // Goes through the character container and if it matches, it will display the character information
                        if (chars.characterContainer[i].equalsIgnoreCase(name)) {
                            System.out.println("Character:          Rarity:             Path:               Element:            Faction:");
                            printCharacterInfo(chars.characterContainer[i], chars.characterInformation[i]);
                        }
                    }
                    loop = proceed();
                    break;

                // Sorting Characters
                case "G":
                    System.out.print("Sort Characters By: \nA: Alphabet\nB: Rarity\nC: Path\nD: Element\nE: Faction\n");
                    String sort = checkInput(scn, new String[]{"A", "B", "C", "D", "E"});
                    sortCharacters(sort, chars.characterContainer, chars.characterInformation);
                    loop = proceed();
                    break;

                // Quitting program
                case "Q":
                    System.out.println("Quitting program..");
                    loop = false;
                    break;
            }
 }
}
}
