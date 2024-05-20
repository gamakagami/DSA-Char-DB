import java.util.*;
public class Char{
    public static void main(String[] args){

        String[] characterContainer = {"Acheron","Argenti","Arlan","Asta","Aventurine","Bailu","Blackswan","Blade","Bronya",
                "Clara","Danheng","Dr.ratio","Fuxuan","Gallagher","Gepard","Guinaifen","Hanya","Herta","Himeko",
                "Hook","Huohuo","Imbibitorlunae","Jingyuan","Jingliu","Kafka","Luka","Luocha","Lynx","March7th",
                "Misha","Natasha","Pela","Qingque","Robin","Ruanmei","Sampo","Seele","Serval","Silverwolf","Sparkle",
                "Sushang","Tingyun","Topaz","Trailblazer","Welt","Xueyi","Yanqing","Yukong"};

        String[][] characterInformation = {
                {"5 Star","Nihility","Lightning","Self Anihilator"},
                {"5 Star","Erudition","Physical","Knights of Beauty"},
                {"4 Star","Destruction","Lightning","Herta Space Station"},
                {"4 Star","Harmony","Fire","Herta Space Station"},
                {"5 Star","Preservation","Imaginary","IPC"},
                {"5 Star","Abundance","Lightning","The Xianzhou Loufu"},
                {"5 Star","Nihility","Wind","Garden of Recollection"},
                {"5 Star","Destruction","Wind","Stellaron Hunter"},
                {"5 Star","Harmony","Wind","Belobog"},
                {"5 Star","Destruction","Physical","Belobog"},
                {"4 Star","The Hunt","Wind","Astral Express"},
                {"5 Star","The Hunt","Imaginary","Intelligentsia Guild"},
                {"5 Star","Preservation","Quantum","The Xianzhou Loufu"},
                {"4 Star","Abundance","Fire","Penacony"},
                {"5 Star","Preservation","Ice","Belobog"},
                {"4 Star","Nihility","Fire","The Xianzhou Loufu"},
                {"4 Star","Harmony","Physical","Xianzhou Loufu"},
                {"4 Star","Erudition","Ice","Herta Space Station"},
                {"5 Star","Erudition","Fire","Astral Express"},
                {"4 Star","Destuction","Fire","Belobog"},
                {"5 Star","Abundance","Wind","The Xianzhou Loufu"},
                {"5 Star","Destruction","Imaginary","Astral Express"},
                {"5 Star","Erudition","Lightning","The Xianzhou Loufu"},
                {"5 Star","Destruction","Ice","The Xianzhou Loufu"},
                {"5 Star","Nihility","Lightning","Stellaron hunter"},
                {"4 Star","Nihility","Physical","Belobog"},
                {"5 Star","Abundance","Imaginary","The Xianzhou Loufu"},
                {"4 Star","Abundance","Quantum","Belobog"},
                {"4 Star","Preservation","Ice","Astral Express"},
                {"4 Star","Destruction","Ice","Penacony"},
                {"4 Star","Abundance","Physical","Belobog"},
                {"4 Star","Nihilty","Ice","Belobog"},
                {"4 Star","Erudition","Quantum","The Xianzhou Loufu"},
                {"5 Star","Harmony","Physical","Penacony"},
                {"5 Star","Harmony","Ice","Herta Space Station"},
                {"4 Star","Nihility","Wind","Belobog"},
                {"5 Star","The Hunt","Quantum","Belobog"},
                {"4 Star","Erudition","Lightning","Belobog"},
                {"5 Star","Nihility","Quantum","Stellaron Hunter"},
                {"5 Star","Harmony","Quantum","Masked Fools"},
                {"4 Star","The Hunt","Physical","The Xianzhou Loufu"},
                {"4 Star","Harmony","Lightning","The Xianzhou Loufu"},
                {"5 Star","The Hunt","Fire","IPC"},
                {"5 Star","Adaptive","Adaptive","Astral Express"},
                {"5 Star","Nihility","Imaginary","Astral Express"},
                {"4 Star","Destruction","Quantum","The Xianzhou Loufu"},
                {"5 Star","The Hunt","Ice","The Xianzhou Loufu"},
                {"4 Star","Harmony","Imaginary","The Xianzhou Loufu"}
        };

        String[] Action_List = {"A", "B", "C", "D", "Q"};

        Hashtable<String, String[]> Retrieve_Information = new Hashtable<>(48);

        for (int i = 0; i < characterContainer.length; i++){
            Retrieve_Information.put(characterContainer[i], characterInformation[i]);
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
                    String character = getCharacter(scn, characterContainer);
                    getInfo(character, Retrieve_Information, 0);
                    break;

                case "B":
                    character = getCharacter(scn, characterContainer);
                    getInfo(character, Retrieve_Information, 1);
                    break;

                case "C":
                    character = getCharacter(scn, characterContainer);
                    getInfo(character, Retrieve_Information, 2);
                    break;

                case "D":
                    System.out.println("                                         || Printing Characters Information ||\n ");
                    System.out.println("Character:          Rarity:             Path:               Element:            Faction:");

                    printWithSpace(characterContainer, characterInformation);
                    break;

                case "Q":
                    System.out.println("Quitting program..");
                    loop = false; break;
            }
        }

    }

    static void getInfo(String Character, Hashtable<String, String[]> Information, Integer Option) {

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

}
