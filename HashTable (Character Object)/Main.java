import java.util.*;

public class Main extends Methods {

    public static void main(String[] args) {
        Hashtable<String, Character> Retrieve_Information = new Hashtable<>(48);
        Retrieve_Information.put("Acheron", new Character("Acheron", "5 Star", "Nihility", "Lightning", "Self Annihilator"));
        Retrieve_Information.put("Argenti", new Character("Argenti", "5 Star", "Erudition", "Physical", "Knights of Beauty"));
        Retrieve_Information.put("Arlan", new Character("Arlan", "4 Star", "Destruction", "Lightning", "Herta Space Station"));
        Retrieve_Information.put("Asta", new Character("Asta", "4 Star", "Harmony", "Fire", "Herta Space Station"));
        Retrieve_Information.put("Aventurine", new Character("Aventurine", "5 Star", "Preservation", "Imaginary", "IPC"));
        Retrieve_Information.put("Bailu", new Character("Bailu", "5 Star", "Abundance", "Lightning", "The Xianzhou Loufu"));
        Retrieve_Information.put("Blackswan", new Character("Blackswan", "5 Star", "Nihility", "Wind", "Garden of Recollection"));
        Retrieve_Information.put("Blade", new Character("Blade", "5 Star", "Destruction", "Wind", "Stellaron Hunter"));
        Retrieve_Information.put("Bronya", new Character("Bronya", "5 Star", "Harmony", "Wind", "Belobog"));
        Retrieve_Information.put("Clara", new Character("Clara", "5 Star", "Destruction", "Physical", "Belobog"));
        Retrieve_Information.put("Danheng", new Character("Danheng", "4 Star", "The Hunt", "Wind", "Astral Express"));
        Retrieve_Information.put("Dr.Ratio", new Character("Dr.Ratio", "5 Star", "The Hunt", "Imaginary", "Intelligensia Guild"));
        Retrieve_Information.put("Fuxuan", new Character("Fuxuan", "5 Star", "Preservation ", "Quantum", "The Xianzhou Loufu"));
        Retrieve_Information.put("Gallagher", new Character("Gallagher", "4 Star", "Abundance", "Fire", "Penacony"));
        Retrieve_Information.put("Gepard", new Character("Gepard", "5 Star", "Preservation", "Ice", "Belobog"));
        Retrieve_Information.put("Guinafen", new Character("Guinafen", "4 Star", "Nihility", "Fire", "The Xianzhou Loufu"));
        Retrieve_Information.put("Hanya", new Character("Hanya", "4 Star", "Harmony", "Physical", "The Xianzhou Loufu"));
        Retrieve_Information.put("Herta", new Character("Herta", "4 Star", "Erudition", "Ice", "Herta Space Station"));
        Retrieve_Information.put("Himeko", new Character("Himeko", "5 Star", "Erudition", "Fire", "Astral Express"));
        Retrieve_Information.put("Hook", new Character("Hook", "4 Star", "Destruction", "Fire", "Belobog"));
        Retrieve_Information.put("Huo Huo", new Character("Huo Huo", "5 Star", "Abundance", "Wind", "The Xianzhou Loufu"));
        Retrieve_Information.put("Imbibitor Lunae ", new Character("Imbibitor Lunae ", "5 Star", "Destruction", "Imaginary", "Astral Express"));
        Retrieve_Information.put("Jingyuan ", new Character("Jingyuan", "5 Star", "Erudition", "Lightning", "The Xianzhou Loufu"));
        Retrieve_Information.put("Jingliu ", new Character("Jingliu", "5 Star", "Destruction", "Ice", "The Xianzhou Loufu"));
        Retrieve_Information.put("Kafka ", new Character("Kafka", "5 Star", "Nihility", "Lightning", "Stellaron Hunter"));
        Retrieve_Information.put("Luka ", new Character("Luka", "4 Star", "Nihility", "Physical", "Belobog"));
        Retrieve_Information.put("Luocha ", new Character("Luocha", "5 Star", "Abundance", "Imaginary", "The Xianzhou Loufu"));
        Retrieve_Information.put("Lynx ", new Character("Lynx", "4 Star", "Abundance", "Quantum", "Belobog"));
        Retrieve_Information.put("March7th ", new Character("March7th", "4 Star", "Preservation", "Ice", "Astral Express"));
        Retrieve_Information.put("Misha ", new Character("Misha", "4 Star", "Destruction", "Ice", "Penacony"));
        Retrieve_Information.put("Natasha ", new Character("Natasha", "4 Star", "Abundance", "Physical", "Belobog"));
        Retrieve_Information.put("Pela ", new Character("Pela", "4 Star", "Nihility", "Ice", "Belobog"));
        Retrieve_Information.put("Qingque ", new Character("Qingque", "4 Star", "Erudition", "Quantum", "The Xianzhou Loufu"));
        Retrieve_Information.put("Robin ", new Character("Robin", "5 Star", "Harmony", "Physical", "Penacony"));
        Retrieve_Information.put("Ruanmei ", new Character("Ruanmei", "5 Star", "Harmony", "Ice", "Herta Space Station"));
        Retrieve_Information.put("Sampo ", new Character("Sampo", "4 Star", "Nihility", "Wind", "Belobog"));
        Retrieve_Information.put("Serval ", new Character("Serval", "4 Star", "Erudition", "Lightning", "Belobog"));
        Retrieve_Information.put("Silverwolf ", new Character("Silverwolf", "5 Star", "Nihility", "Quantum", "Stellaron Hunter"));
        Retrieve_Information.put("Sparkle ", new Character("Sparkle", "5 Star", "Harmony", "Quantum", "Mask Fools"));
        Retrieve_Information.put("Sushang ", new Character("Sushang", "4 Star", "The Hunt", "Physical", "The Xianzhou Loufu"));
        Retrieve_Information.put("Tingyun ", new Character("Tingyun", "4 Star", "Harmony", "Lightning", "The Xianzhou Loufu"));
        Retrieve_Information.put("Topaz", new Character("Topaz", "5 Star", "The Hunt", "Fire", "IPC"));
        Retrieve_Information.put("Trailblazer", new Character("Trailblazer", "5 Star", "Adaptive", "Adaptive", "Astral Express"));
        Retrieve_Information.put("Welt", new Character("Welt", "5 Star", "Nihility", "Imaginary", "Astral Express"));
        Retrieve_Information.put("Xueyi ", new Character("Xueyi", "4 Star", "Destruction", "Quantum", "The Xianzhou Loufu"));
        Retrieve_Information.put("Yanqing ", new Character("Yangqing", "5 Star", "The Hunt", "Ice", "The Xianzhou Loufu"));
        Retrieve_Information.put("Yukong ", new Character("Yukong", "4 Star", "Harmony", "Imaginary", "The Xianzhou Loufu"));

        Scanner scn = new Scanner(System.in);

        System.out.println("Welcome to a Honkai Star Rail Database System");
        boolean loop = true;

        while (loop) {
            System.out.println("----------------------------------\nA: Get Rarity\nB: Get Path\nC: Get Element\nD: Print all Characters\nE: Filter Characters\nF: Display Information of a Character\nG: Sort Characters\nQ: Quit\nPlease enter an action you want to perform: ");

            String action = "";

            action = checkInput(scn, new String[]{"A", "B", "C", "D", "E", "F", "G", "Q"});

            switch (action.toUpperCase()) {
                case "A":
                    String character = getCharacter(scn, Retrieve_Information);
                    getInfo(character, Retrieve_Information, 0);
                    loop = proceed();
                    break;

                case "B":
                    character = getCharacter(scn, Retrieve_Information);
                    getInfo(character, Retrieve_Information, 1);
                    loop = proceed();
                    break;

                case "C":
                    character = getCharacter(scn, Retrieve_Information);
                    getInfo(character, Retrieve_Information, 2);
                    loop = proceed();
                    break;

                case "D":
                    System.out.println("|| Printing Characters Information ||\n ");
                    Retrieve_Information.values().stream()
                            .sorted(Comparator.comparing(Character::getName))
                            .forEach(Methods::printCharacterDetails);
                    loop = proceed();
                    break;
                case "E":
                    System.out.print("Filter Characters By: \nA: Alphabet\nB: Element\nC: Path\nD: Faction\nE: Rarity\n");
                    String filter = checkInput(scn, new String[]{"A", "B", "C", "D", "E"});
                    filter(scn, filter, Retrieve_Information);
                    loop = proceed();
                    break;

                case "F":
                    System.out.print("Enter a character name: ");
                    String characterName = scn.nextLine().trim();
                    Character Character = Retrieve_Information.get(characterName);

                    if (Character != null) {
                        System.out.println("\nCharacter:            Rarity:               Path:                 Element:              Faction:");
                        Methods.printCharacterDetails(Character);
                    } else {
                        System.out.println("Character not found.");
                    }
                    loop = proceed();
                    break;

                case "G":
                    System.out.print("\n== Sort Characters Features ==\nA: Alphabet\nB: Rarity\nC: Path\nD: Element\nE: Faction\n");
                    System.out.print("\nSort Characters By: ");
                    String sort = checkInput(scn, new String[]{"A", "B", "C", "D", "E"});
                    sortCharacters(sort, Retrieve_Information);
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

