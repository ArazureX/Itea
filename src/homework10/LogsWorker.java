package homework10;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class LogsWorker {

    private DBWorker worker;
    private static final String FIGHT_LOGS = "CREATE TABLE IF NOT EXISTS fight_logs(id INT PRIMARY KEY AUTO_INCREMENT,time DATETIME, logs TEXT)";
    private static final String PATTERN_ADD_LOGS = "INSERT INTO fight_logs(time,logs)";
    public LogsWorker(DBWorker worker) {
        this.worker = worker;
    }


    public void createTableLogs() {
        Connection conn = null;
        Statement st = null;
        conn = worker.getConnection();
        if (conn != null) {
            try {
                st = conn.createStatement();
                st.execute(FIGHT_LOGS);
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

    public void createLogs(String str) {
        Connection conn = null;
        Statement st = null;
        conn = worker.getConnection();
        if (conn != null) {
            try {
                st = conn.createStatement();
                st.execute(PATTERN_ADD_LOGS+"VALUES(NOW(),"+"'"+str+"')");
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
