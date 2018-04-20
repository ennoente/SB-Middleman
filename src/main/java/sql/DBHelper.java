package sql;

import java.sql.Connection;
import java.sql.ResultSet;

public class DBHelper {
    private static Connection connection;

    public static void setConnection(Connection connection) {
        DBHelper.connection = connection;
    }

    //public static synchronized ResultSet
}
