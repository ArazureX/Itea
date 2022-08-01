package homework10;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Dota2Engine {

    Hero hero1;
    Hero hero2;
    DBWorker worker = new DBWorker();

    private static final String GET_HERO = "SELECT * FROM heroes WHERE hero_name = ";

    private static final String LOGS_PATTERN = "%s\nAfter round %d\n%s have: %d HP\n%s have: %d HP\n";

    public Dota2Engine(DBWorker dbworker,Hero hero1, Hero hero2) {
        this.worker = dbworker;
        this.hero1=hero1;
        this.hero2=hero2;
    }
    ItemBD itemBD = new ItemBD(worker);

    LogsWorker logsWorker = new LogsWorker(worker);
    public void startGame() {
        HeroesBD heroesBD = new HeroesBD(worker);

        heroesBD.loadHeroesToDB();
        itemBD.loadItemsToDB();

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        conn = worker.getConnection();
        if (conn != null) {
            try {
                st = conn.createStatement();
                rs = st.executeQuery(GET_HERO + "'Pudge'");
                while (rs.next()) {
                    hero1.setAgility(rs.getInt("hero_agility"));
                    hero1.setInteligence(rs.getInt("hero_intelligence"));
                    hero1.setStrange(rs.getInt("hero_strange"));
                    hero1.setName(rs.getString("hero_name"));
                }
                rs = st.executeQuery(GET_HERO + "'Techies'");
                while (rs.next()) {
                    hero2.setAgility(rs.getInt("hero_agility"));
                    hero2.setInteligence(rs.getInt("hero_intelligence"));
                    hero2.setStrange(rs.getInt("hero_strange"));
                    hero2.setName(rs.getString("hero_name"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (st != null) {
                        st.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("DBWorker returned null connection");
        }
        List<Item> hero1List = new ArrayList<>();
        List<Item> hero2List = new ArrayList<>();
        Map<Hero,List> map = new HashMap<>();
        hero1List.add(hero1.getItemFromHashSet(itemBD.getItemsFromBD()));
        hero1List.add(hero1.getItemFromHashSet(itemBD.getItemsFromBD()));
        map.put(hero1,hero1List);
        hero1.setItem(hero1List.get(0));
        hero1.setItem(hero1List.get(1));

        hero2List.add(hero2.getItemFromHashSet(itemBD.getItemsFromBD()));
        hero2List.add(hero2.getItemFromHashSet(itemBD.getItemsFromBD()));
        map.put(hero2,hero2List);
        hero2.setItem(hero2List.get(0));
        hero2.setItem(hero2List.get(1));
        System.out.println(map);
        hero1.compareHeroes(hero1, hero2);

        System.out.println("-----------Fight!----------");
        logsWorker.createTableLogs();

        int count = 1;
        while (((hero1.getHealth() >= 0) || (hero2.getHealth() >= 0))) {
            String tempStr = " Turn " + hero1.getName();
            System.out.println(new Date() + tempStr);
            logsWorker.createLogs(tempStr);
            hero2.takeDamage(hero1.getHitPower() * hero1.damegeBonus());
            String tempStr1 = " Turn " + hero2.getName();
            System.out.println(new Date() + tempStr1);
            logsWorker.createLogs(tempStr1);
            hero1.takeDamage(hero2.getHitPower() * hero2.damegeBonus());
            if (hero2.getHealth() < 0) {
                String tempString2 = hero1.getName() + " Won";
                System.out.println(new Date() + tempString2);
                logsWorker.createLogs(tempString2);
                break;
            } else if (hero1.getHealth() < 0) {
                String tempStr3 = hero2.getName() + "Won ";
                System.out.println(new Date() + tempStr3);
                logsWorker.createLogs(tempStr3);
                break;
            } else {
                System.out.printf(LOGS_PATTERN, new Date(), count, hero1.getName(), hero1.getHealth(), hero2.getName(), hero2.getHealth());
                String str = "After round " + (count++) + hero1.getName() + " have: " + hero1.getHealth() + "HP" + hero2.getName() + " have: " + hero2.getHealth() + "HP";
                logsWorker.createLogs(str);

            }


        }
    }
}





