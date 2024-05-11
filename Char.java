import java.util.*;
public class Char{
    public static void main(String[] args){

        String[] Characters = {"ACHERON","ARGENTI","ARLAN","ASTA","AVENTURINE","BAILU","BLACKSWAN","BLADE","BRONYA",
                "CLARA","DANHENG","DR.RATIO","FUXUAN","GALLAGHER","GEPARD","GUINAIFEN","HANYA","HERTA","HIMEKO",
                "HOOK","HUOHUO","IMBIBITORLUNAE","JINGYUAN","JINGLIU","KAFKA","LUKA","LUOCHA","LYNX","MARCH7TH",
                "MISHA","NATASHA","PELA","QINGQUE","ROBIN","RUANMEI","SAMPO","SEELE","SERVAL","SILVERWOLF","SPARKLE",
                "SUSHANG","TINGYUN","TOPAZ","TRAILBLAZER","WELT","XUEYI","YANQING","YUKONG"};

        String[][] Character_Information = {
                {"5 Star","Nihility","Lightning"},
                {"5 Star","Erudition","Physical"},
                {"4 Star","Destruction","Lightning"},
                {"4 Star","Harmony","Fire"},
                {"5 Star","Preservation","Imaginary"},
                {"5 Star","Abundance","Lightning"},
                {"5 Star","Nihility","Wind"},
                {"5 Star","Destruction","Wind"},
                {"5 Star","Harmony","Wind"},
                {"5 Star","Destruction","Physical"},
                {"4 Star","The Hunt","Wind"},
                {"5 Star","The Hunt","Imaginary"},
                {"5 Star","Preservation","Quantum"},
                {"4 Star","Abundance","Fire"},
                {"5 Star","Preservation","Ice"},
                {"4 Star","Nihility","Fire"},
                {"4 Star","Harmony","Physical"},
                {"4 Star","Erudition","Ice"},
                {"5 Star","Erudition","Fire"},
                {"4 Star","Destuction","Fire"},
                {"5 Star","Abundance","Wind"},
                {"5 Star","Destruction","Imaginary"},
                {"5 Star","Erudition","Lightning"},
                {"5 Star","Destruction","Ice"},
                {"5 Star","Nihility","Lightning"},
                {"4 Star","Nihility","Physical"},
                {"5 Star","Abundance","Imaginary"},
                {"4 Star","Abundance","Quantum"},
                {"4 Star","Preservation","Ice"},
                {"4 Star","Destruction","Ice"},
                {"4 Star","Abundance","Physical"},
                {"4 Star","Nihilty","Ice"},
                {"4 Star","Erudition","Quantum"},
                {"5 Star","Harmony","Physical"},
                {"5 Star","Harmony","Ice"},
                {"4 Star","Nihility","Wind"},
                {"5 Star","The Hunt","Quantum"},
                {"4 Star","Erudition","Lightning"},
                {"5 Star","Nihility","Quantum"},
                {"5 Star","Harmony","Quantum"},
                {"4 Star","The Hunt","Physical"},
                {"4 Star","Harmony","Lightning"},
                {"5 Star","The Hunt","Fire"},
                {"5 Star","Adaptive","Adaptive"},
                {"5 Star","Nihility","Quantum"},
                {"4 Star","Destruction","Quantum"},
                {"5 Star","The Hunt","Ice"},
                {"4 Star","Harmony","Imaginary"}
        };

        Hashtable<String, String[]> Retrieve_Information = new Hashtable<>(48);

        for (int i = 0; i <Characters.length; i++){
            Retrieve_Information.put(Characters[i], Character_Information[i]);
        }

        Scanner scn = new Scanner(System.in);
        System.out.println("Welcome to Honkai Star Rail Database System!");
        System.out.println("---------------------------------------------");

        Boolean present = false;
        System.out.println("Enter the Character:");
        String Char = scn.nextLine();
        Char = Char.replace(" ", "").toUpperCase();
        if (Char.equals("IMBIBITORLUNAE")){
            Char = "DANHENGIL";
        }

        for (String i : Characters){
            if (i.equals(Char)){
                present = true;
            }
        }

        if (present) {
            System.out.println("---------------------------------------------");
            System.out.println("Action:");
            System.out.println("A: Get Rarity");
            System.out.println("B: Get Path");
            System.out.println("C: Get Element");
            System.out.println("---------------------------------------------");
            System.out.println("Enter the Action:");
            String input = scn.nextLine().toUpperCase();

            switch (input) {
                case "A":
                    getRarity(Char, Retrieve_Information);
                    break;
                case "B":
                    getPath(Char, Retrieve_Information);
                    break;
                case "C":
                    getElement(Char, Retrieve_Information);
                    break;
                default:
                    System.out.println("Action Entered is Invalid");
                    break;
            }
        } else {
            System.out.println("Character is invalid");
        }
    }
    static void getRarity(String Character, Hashtable<String, String[]> Information){
        String[] Info = Information.get(Character);
        Character = Character.charAt(0) + Character.substring(1, Character.length()).toLowerCase();

        System.out.println(Character + " is a " + Info[0] + " character.");

    }
    static void getPath(String Character, Hashtable<String, String[]> Information){
        String[] Info = Information.get(Character);
        Character = Character.charAt(0) + Character.substring(1, Character.length()).toLowerCase();

        System.out.println(Character + " is in " + Info[1] + " path.");

    }
    static void getElement(String Character, Hashtable<String, String[]> Information){
        String[] Info = Information.get(Character);
        Character = Character.charAt(0) + Character.substring(1, Character.length()).toLowerCase();

        System.out.println(Character + " is a " + Info[2] + " character.");

    }
}
