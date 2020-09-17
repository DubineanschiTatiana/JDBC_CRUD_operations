package TaskClasses;

import org.apache.commons.dbutils.DbUtils;
import utils.DatabaseConnection;

import java.sql.SQLException;
import java.sql.Statement;

public class Task3Delete {
    public static Integer deleteQuery(String query) {
        DatabaseConnection connection = null;
        Statement statement=null;
        Integer numberOfRows=null;
        try {
        connection= DatabaseConnection.getInstance();
        statement=connection.getConnection().createStatement();
        numberOfRows=statement.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DbUtils.closeQuietly(statement);
            DbUtils.closeQuietly(connection.getConnection());
        }
        return numberOfRows;
    }
}
