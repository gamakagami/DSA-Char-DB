public class Character{
    String name, rarity, path, element, faction;

    public Character(String name, String rarity, String path, String element, String faction) {
        this.name = name;
        this.rarity = rarity;
        this.path = path;
        this.element = element;
        this.faction = faction;
    }
    public String getFaction() {
        return faction;
    }
    public String getElement() {
        return this.element;
    }

    public String getPath() {
        return path;
    }

    public String getName() {
        return name;

    }
    public String getRarity() {
        return rarity;
    }
}

