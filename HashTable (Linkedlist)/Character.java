import java.util.LinkedList;

public class Character {
    // Store character name in LinkedList
    LinkedList<String> characterContainer = new LinkedList<>(List.of("Acheron", "Argenti", "Arlan", "Asta", "Aventurine", "Bailu", "Blackswan", "Blade", "Bronya",
            "Clara", "Danheng", "Dr.ratio", "Fuxuan", "Gallagher", "Gepard", "Guinaifen", "Hanya", "Herta", "Himeko",
            "Hook", "Huohuo", "Imbibitorlunae", "Jingyuan", "Jingliu", "Kafka", "Luka", "Luocha", "Lynx", "March7th",
            "Misha", "Natasha", "Pela", "Qingque", "Robin", "Ruanmei", "Sampo", "Seele", "Serval", "Silverwolf", "Sparkle",
            "Sushang", "Tingyun", "Topaz", "Trailblazer", "Welt", "Xueyi", "Yanqing", "Yukong"));


    // Store character information in LinkedList
    LinkedList<LinkedList<String>> characterInformation = new LinkedList<>();

    // Constructor to initialize the lists
    public Character() {

        // Initialize characterInformation
        String[][] info = {
                {"5 Star", "Nihility", "Lightning", "Self Annihilator"},
                {"5 Star", "Erudition", "Physical", "Knights of Beauty"},
                {"4 Star", "Destruction", "Lightning", "Herta Space Station"},
                {"4 Star", "Harmony", "Fire", "Herta Space Station"},
                {"5 Star", "Preservation", "Imaginary", "IPC"},
                {"5 Star", "Abundance", "Lightning", "The Xianzhou Loufu"},
                {"5 Star", "Nihility", "Wind", "Garden of Recollection"},
                {"5 Star", "Destruction", "Wind", "Stellaron Hunter"},
                {"5 Star", "Harmony", "Wind", "Belobog"},
                {"5 Star", "Destruction", "Physical", "Belobog"},
                {"4 Star", "The Hunt", "Wind", "Astral Express"},
                {"5 Star", "The Hunt", "Imaginary", "Intelligentsia Guild"},
                {"5 Star", "Preservation", "Quantum", "The Xianzhou Loufu"},
                {"4 Star", "Abundance", "Fire", "Penacony"},
                {"5 Star", "Preservation", "Ice", "Belobog"},
                {"4 Star", "Nihility", "Fire", "The Xianzhou Loufu"},
                {"4 Star", "Harmony", "Physical", "Xianzhou Loufu"},
                {"4 Star", "Erudition", "Ice", "Herta Space Station"},
                {"5 Star", "Erudition", "Fire", "Astral Express"},
                {"4 Star", "Destruction", "Fire", "Belobog"},
                {"5 Star", "Abundance", "Wind", "The Xianzhou Loufu"},
                {"5 Star", "Destruction", "Imaginary", "Astral Express"},
                {"5 Star", "Erudition", "Lightning", "The Xianzhou Loufu"},
                {"5 Star", "Destruction", "Ice", "The Xianzhou Loufu"},
                {"5 Star", "Nihility", "Lightning", "Stellaron hunter"},
                {"4 Star", "Nihility", "Physical", "Belobog"},
                {"5 Star", "Abundance", "Imaginary", "The Xianzhou Loufu"},
                {"4 Star", "Abundance", "Quantum", "Belobog"},
                {"4 Star", "Preservation", "Ice", "Astral Express"},
                {"4 Star", "Destruction", "Ice", "Penacony"},
                {"4 Star", "Abundance", "Physical", "Belobog"},
                {"4 Star", "Nihility", "Ice", "Belobog"},
                {"4 Star", "Erudition", "Quantum", "The Xianzhou Loufu"},
                {"5 Star", "Harmony", "Physical", "Penacony"},
                {"5 Star", "Harmony", "Ice", "Herta Space Station"},
                {"4 Star", "Nihility", "Wind", "Belobog"},
                {"5 Star", "The Hunt", "Quantum", "Belobog"},
                {"4 Star", "Erudition", "Lightning", "Belobog"},
                {"5 Star", "Nihility", "Quantum", "Stellaron Hunter"},
                {"5 Star", "Harmony", "Quantum", "Masked Fools"},
                {"4 Star", "The Hunt", "Physical", "The Xianzhou Loufu"},
                {"4 Star", "Harmony", "Lightning", "The Xianzhou Loufu"},
                {"5 Star", "The Hunt", "Fire", "IPC"},
                {"5 Star", "Adaptive", "Adaptive", "Astral Express"},
                {"5 Star", "Nihility", "Imaginary", "Astral Express"},
                {"4 Star", "Destruction", "Quantum", "The Xianzhou Loufu"},
                {"5 Star", "The Hunt", "Ice", "The Xianzhou Loufu"},
                {"4 Star", "Harmony", "Imaginary", "The Xianzhou Loufu"}
        };

        // Adding the info to the LinkedList
        for (String[] infos : info) {
            LinkedList<String> infoList = new LinkedList<>();
            for (String detail : infos) {
                infoList.add(detail);
            }
            characterInformation.add(infoList);
        }
    }

}
