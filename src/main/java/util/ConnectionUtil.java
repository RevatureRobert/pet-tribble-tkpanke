package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    static Connection conn = null;

    /**
     * Connect to the db and store the Connection instance.
     *
     * @return
     * @throws SQLException
     */
    public static Connection initializeConnection() throws SQLException, ClassNotFoundException {
        //Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection(
                "jdbc:postgresql://db2102.cofn08xsx6st.us-west-2.rds.amazonaws.com:5432/postgres?currentSchema=tribble",
                "postgres", "eyeofthevoid");
        return conn;
    }

    /**
     * Used by our other methods once the driver initializes the connection.
     *
     * @return
     */
    public static Connection getConnection() {
        return conn;
    }
}
