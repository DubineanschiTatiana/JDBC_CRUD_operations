package taskClasses;

import com.microsoft.sqlserver.jdbc.SQLServerBulkCSVFileRecord;
import com.microsoft.sqlserver.jdbc.SQLServerBulkCopy;
import org.apache.commons.dbutils.DbUtils;
import utils.DatabaseConnection;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class BulkInsertSQLserverBulk {
    public static void insertbulk(String tableName, String csvPath) {
        DatabaseConnection connection = null;
        Statement statement = null;
        try {
            connection = DatabaseConnection.getInstance();
            statement = connection.getConnection().createStatement();

            SQLServerBulkCSVFileRecord fileRecord = new SQLServerBulkCSVFileRecord(csvPath, null, ",", true);

            fileRecord.addColumnMetadata(1, null, Types.INTEGER, 0, 0);
            fileRecord.addColumnMetadata(2, null, java.sql.Types.VARCHAR, 255, 0);
            fileRecord.addColumnMetadata(3, null, Types.INTEGER, 0, 0);
            fileRecord.addColumnMetadata(4, null, java.sql.Types.INTEGER, 0, 0);
            fileRecord.addColumnMetadata(5, null, Types.SMALLINT, 0, 0);
            fileRecord.addColumnMetadata(6, null, Types.DECIMAL, 10, 2);

            SQLServerBulkCopy bulkCopy = new SQLServerBulkCopy(connection.getConnection());
            bulkCopy.setDestinationTableName(tableName);
            bulkCopy.writeToServer(fileRecord);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DbUtils.closeQuietly(statement);
            DbUtils.closeQuietly(connection.getConnection());
        }
    }
}

