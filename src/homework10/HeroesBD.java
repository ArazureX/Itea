package homework10;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class HeroesBD {

    private DBWorker worker;
    private static final String CREATE_TABLE_HEROES = "CREATE TABLE IF NOT EXISTS heroes(hero_id INT PRIMARY KEY AUTO_INCREMENT," +
            " hero_name VARCHAR(100), hero_strange INT, hero_agility INT, hero_intelligence INT)";
    private static final String PATTERN_ADD_HEROES = "INSERT INTO heroes(hero_name,hero_strange,hero_agility,hero_intelligence)";


    public HeroesBD(DBWorker worker) {
        this.worker = worker;
    }

    public void loadHeroesToDB() {
        Connection conn = null;
        Statement st = null;
        conn = worker.getConnection();
        if (conn != null) {
            try {
                st = conn.createStatement();
                st.execute(CREATE_TABLE_HEROES);
                st.execute(PATTERN_ADD_HEROES + "VALUES('Pudge',10,5,4)");
                st.execute(PATTERN_ADD_HEROES + "VALUES('Void',5,10,5)");
                st.execute(PATTERN_ADD_HEROES + "VALUES('Marci',10,6,5)");
                st.execute(PATTERN_ADD_HEROES + "VALUES('Techies',4,5,10)");

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
    }

}


