package homework10;

public class hm10 {
    public static void main(String[] args) throws CloneNotSupportedException {
        DBWorker dbWorker = new DBWorker();
        Pudge hero1 = new Pudge();
        Techies hero2 = new Techies();
        Dota2Engine dota2Engine = new Dota2Engine(dbWorker, hero1, hero2);
        dota2Engine.startGame();

    }
}
