import java.util.*;
public class Char{
    public static void main(String[] args){

        String[] characterContainer = {"ACHERON","ARGENTI","ARLAN","ASTA","AVENTURINE","BAILU","BLACKSWAN","BLADE","BRONYA",
                "CLARA","DANHENG","DR.RATIO","FUXUAN","GALLAGHER","GEPARD","GUINAIFEN","HANYA","HERTA","HIMEKO",
                "HOOK","HUOHUO","IMBIBITORLUNAE","JINGYUAN","JINGLIU","KAFKA","LUKA","LUOCHA","LYNX","MARCH7TH",
                "MISHA","NATASHA","PELA","QINGQUE","ROBIN","RUANMEI","SAMPO","SEELE","SERVAL","SILVERWOLF","SPARKLE",
                "SUSHANG","TINGYUN","TOPAZ","TRAILBLAZER","WELT","XUEYI","YANQING","YUKONG"};

        String[][] characterInformation = {
                {"5 Star","Nihility","Lightning","Self Anihilator"},
                {"5 Star","Erudition","Physical","Knights of Beauty"},
                {"4 Star","Destruction","Lightning","Herta Space Station"},
                {"4 Star","Harmony","Fire","Herta Space Station"},
                {"5 Star","Preservation","Imaginary","IPC"},
                {"5 Star","Abundance","Lightning",,"The Xianzhou Loufu"},
                {"5 Star","Nihility","Wind","Garden of Recollection"},
                {"5 Star","Destruction","Wind","Stelalron Hunter"},
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
                action = scn.nextLine().toUpperCase();

                for (int i = 0; i < Action_List.length; i++) {
                    if (action.equals(Action_List[i])) {
                        action_present = true;
                        break;
                    }
                }

                if (!action_present) {
                    System.out.println("Enter a valid action (A, B, C, D)");
                }
            }

            switch (action) {
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
                    System.out.println("List of Characters: ");
                    for (int i = 0; i < characterContainer.length; i++) {
                        String name = (characterContainer[i].charAt(0)) + (characterContainer[i].substring(1, characterContainer[i].length()).toLowerCase());
                        System.out.println(i + 1 + ". " + name);
                    }
                    break;

                case "Q":
                    System.out.println("Quitting program..");
                    loop = false; break;
            }
        }

    }

    static void getInfo(String Character, Hashtable<String, String[]> Information, Integer Option) {

        String[] Info = Information.get(Character);
        Character = Character.charAt(0) + Character.substring(1, Character.length()).toLowerCase();

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
            Char = Char.replace(" ", "").toUpperCase();
            if (Char.equals("IMBIBITORLUNAE")) {
                Char = "DANHENGIL";
            }

            for (String i : Characters) {
                if (i.equals(Char)) {
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

}
