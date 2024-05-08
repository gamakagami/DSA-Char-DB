import java.util.*;
public class Main{
    public static void main(String[] args){

        String[] Characters = {"ACHERON","ARGENTI","ARLAN","ASTA","AVENTURINE","BAILU","BLACKSWAN","BLADE","BRONYA",
                "CLARA","DANHENG","DR.RATIO","FUXUAN","GALLAGHER","GEPARD","GUINAIFEN","HANYA","HERTA","HIMEKO",
                "HOOK","HUOHUO","IMBIBITORLUNAE","JINGYUAN","JINGLIU","KAFKA","LUKA","LUOCHA","LYNX","MARCH7TH",
                "MISHA","NATASHA","PELA","QINGQUE","ROBIN","RUANMEI","SAMPO","SEELE","SERVAL","SILVERWOLF","SPARKLE",
                "SUSHANG","TINGYUN","TOPAZ","TRAILBLAZER","WELT","XUEYI","YANQING","YUKONG"};

        String[][] Character_Information = {
                {"5 Star"},
                {"5 Star"},
                {"4 Star"},
                {"4 Star"},
                {"5 Star"},
                {"5 Star"},
                {"5 Star"},
                {"5 Star"},
                {"5 Star"},
                {"5 Star"},
                {"4 Star"},
                {"5 Star"},
                {"5 Star"},
                {"4 Star"},
                {"5 Star"},
                {"4 Star"},
                {"4 Star"},
                {"4 Star"},
                {"5 Star"},
                {"4 Star"},
                {"5 Star"},
                {"5 Star"},
                {"5 Star"},
                {"5 Star"},
                {"5 Star"},
                {"4 Star"},
                {"5 Star"},
                {"4 Star"},
                {"4 Star"},
                {"4 Star"},
                {"4 Star"},
                {"4 Star"},
                {"4 Star"},
                {"5 Star"},
                {"5 Star"},
                {"4 Star"},
                {"5 Star"},
                {"4 Star"},
                {"5 Star"},
                {"5 Star"},
                {"4 Star"},
                {"4 Star"},
                {"5 Star"},
                {"5 Star"},
                {"5 Star"},
                {"4 Star"},
                {"5 Star"},
                {"4 Star"}
        };

        Hashtable<String, String[]> Retrieve_Information = new Hashtable<>(48);

        for (int i = 0; i <Characters.length; i++){
            Retrieve_Information.put(Characters[i], Character_Information[i]);
        }

        Scanner scn = new Scanner(System.in);
        System.out.println("Welcome to Honkai Star Rail Database System!");
        System.out.println("---------------------------------------------");
        System.out.println("Action:");
        System.out.println("A: Get Rarity");
        System.out.println("---------------------------------------------");
        System.out.println("Enter the Character:");
        String Char = scn.nextLine().trim().toUpperCase();
        System.out.println("Enter the Action:");
        String input = scn.nextLine().toUpperCase();

        switch (input){
            case "A":
                getRarity(Char, Retrieve_Information); break;
            default:
                System.out.println("Action Entered is Invalid"); break;
        }
    }
    static void getRarity(String Character, Hashtable<String, String[]> Information){
        String[] Info = Information.get(Character);
        Character = Character.charAt(0) + Character.substring(1, Character.length()).toLowerCase();

        System.out.println(Character + " is a " + Info[0] + " character.");
    }
}
