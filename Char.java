import java.util.*;
public class Char {
    public static void main(String[] args) {
        Hashtable<Integer,String> table = new Hashtable<>(46);

        table.put(1,"Acheron");
        table.put(2,"Argenti");
        table.put(3,"Arlan");
        table.put(4,"Asta");
        table.put(5,"Aventurine");
        table.put(6,"Bailu");
        table.put(7,"Blackswan");
        table.put(8,"Blade");
        table.put(9,"Bronya");
        table.put(10,"Clara");
        table.put(11,"Dan heng");
        table.put(12,"Dr.Ratio");
        table.put(13,"Fu xuan");
        table.put(14,"Gallagher");
        table.put(15,"Gepard");
        table.put(16,"Guinaifen");
        table.put(17,"Hanya");
        table.put(18,"Herta");
        table.put(19,"Himeko");
        table.put(20,"Hook");
        table.put(21,"HuoHuo");
        table.put(22,"Jing liu");
        table.put(23,"Jing yuan");
        table.put(24,"Kafka");
        table.put(25,"Luka");
        table.put(26,"Luocha");
        table.put(27,"Lynx");
        table.put(28,"March 7th");
        table.put(29,"Misha");
        table.put(30,"Natasha");
        table.put(31,"Pela");
        table.put(32,"Qingque");
        table.put(33,"Ruan mei");
        table.put(34,"Sampo");
        table.put(35,"Seele");
        table.put(36,"Serval");
        table.put(37,"Silver wolf");
        table.put(38,"Sparkle");
        table.put(39,"Sushang");
        table.put(40,"Tingyun");
        table.put(41,"Topaz and numby");
        table.put(42,"Trailblazer");
        table.put(43,"Welt");
        table.put(44,"Xueyi");
        table.put(45,"Yanqing");
        table.put(46,"Yukong");

        for(int key=1;key<=46;key++){
        System.out.println(key+"\t"+table.get(key));
    }
    }
}
