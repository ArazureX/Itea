package homework10;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class ItemBD {
    Item item;
    private int maxRandomNumber = 50;
    private DBWorker worker;
    private int maxAmountOfItems = 12;

    private int getRandomNumber() {
        return (int) (Math.random() * (maxRandomNumber));
    }


    private static final String CREATE_TABLE_ITEMS = "CREATE TABLE IF NOT EXISTS items( item_id INT PRIMARY KEY AUTO_INCREMENT," +
            " item_name VARCHAR(100), item_strange INT, item_agility INT, item_intelligence INT)";
    private static final String PATTERN_ADD_ITEMS = "INSERT INTO items(item_name,item_strange,item_agility,item_intelligence)";
    private static final String GET_ITEM = "SELECT * FROM items WHERE item_id = ";

    public ItemBD(DBWorker worker) {
        this.worker = worker;
    }

    public void loadItemsToDB() {
        Connection conn = null;
        Statement st = null;
        conn = worker.getConnection();
        if (conn != null) {
            try {
                st = conn.createStatement();
                st.execute(CREATE_TABLE_ITEMS);
                st.execute(PATTERN_ADD_ITEMS + "VALUES('Buckler'," + getRandomNumber() + "," + getRandomNumber() + "," + getRandomNumber() + ")");
                st.execute(PATTERN_ADD_ITEMS + "VALUES('Headdress'," + getRandomNumber() + "," + getRandomNumber() + "," + getRandomNumber() + ")");
                st.execute(PATTERN_ADD_ITEMS + "VALUES('Urn of Shadows'," + getRandomNumber() + "," + getRandomNumber() + "," + getRandomNumber() + ")");
                st.execute(PATTERN_ADD_ITEMS + "VALUES('Holy Locket'," + getRandomNumber() + "," + getRandomNumber() + "," + getRandomNumber() + ")");
                st.execute(PATTERN_ADD_ITEMS + "VALUES('Smoke of Deceit'," + getRandomNumber() + "," + getRandomNumber() + "," + getRandomNumber() + ")");
                st.execute(PATTERN_ADD_ITEMS + "VALUES('Enchanted Mango'," + getRandomNumber() + "," + getRandomNumber() + "," + getRandomNumber() + ")");
                st.execute(PATTERN_ADD_ITEMS + "VALUES('Faerie Fire'," + getRandomNumber() + "," + getRandomNumber() + "," + getRandomNumber() + ")");
                st.execute(PATTERN_ADD_ITEMS + "VALUES('Town Portal Scroll'," + getRandomNumber() + "," + getRandomNumber() + "," + getRandomNumber() + ")");
                st.execute(PATTERN_ADD_ITEMS + "VALUES('Tango'," + getRandomNumber() + "," + getRandomNumber() + "," + getRandomNumber() + ")");
                st.execute(PATTERN_ADD_ITEMS + "VALUES('Healing Salve'," + getRandomNumber() + "," + getRandomNumber() + "," + getRandomNumber() + ")");
                st.execute(PATTERN_ADD_ITEMS + "VALUES('Gauntlets of Strength'," + getRandomNumber() + "," + getRandomNumber() + "," + getRandomNumber() + ")");
                st.execute(PATTERN_ADD_ITEMS + "VALUES('Slippers of Agility'," + getRandomNumber() + "," + getRandomNumber() + "," + getRandomNumber() + ")");
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

    public HashSet<Item> getItemsFromBD() {
        ItemBD itemBD = new ItemBD(worker);
        itemBD.loadItemsToDB();
        Set<Item> setItem = new HashSet<>();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        conn = worker.getConnection();
        if (conn != null) {
            try {
                st = conn.createStatement();
                for (int i = 0; i <= maxAmountOfItems; i++) {
                    rs = st.executeQuery(GET_ITEM + i);
                    while (rs.next()) {
                        setItem.add(new Item(rs.getInt("item_intelligence"), rs.getInt("item_agility"),
                                rs.getInt("item_strange"), rs.getString("item_name")));
                    }
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
        return (HashSet<Item>) setItem;
    }

}


