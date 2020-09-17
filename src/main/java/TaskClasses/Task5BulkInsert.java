package TaskClasses;

import org.apache.commons.dbutils.DbUtils;
import utils.DatabaseConnection;

import java.sql.SQLException;
import java.sql.Statement;

public class Task5BulkInsert {
    public static Integer bulkInsertQuery(String tableName, String csvPath) {
        DatabaseConnection connection = null;
        Statement statement = null;
        Integer numberOfRows = null;
        try {
            connection = DatabaseConnection.getInstance();
            statement = connection.getConnection().createStatement();
            numberOfRows = statement.executeUpdate(String.format("BULK INSERT %s FROM '%s' WITH ( FIRSTROW=2, FIELDTERMINATOR = ',', ROWTERMINATOR = '\n');", tableName, csvPath));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DbUtils.closeQuietly(statement);
            DbUtils.closeQuietly(connection.getConnection());
        }
        return numberOfRows;
    }
}

