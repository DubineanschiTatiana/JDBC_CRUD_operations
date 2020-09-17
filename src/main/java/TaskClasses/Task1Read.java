package TaskClasses;

import org.apache.commons.dbutils.DbUtils;
import utils.DatabaseConnection;
import utils.ExportCsv;
import utils.PrintQuery;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Task1Read {
    public static void readQuery(String query) {
        DatabaseConnection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DatabaseConnection.getInstance();
            statement = connection.getConnection().createStatement();
            resultSet = statement.executeQuery(query);
            ExportCsv.toCSV(resultSet);
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        } finally {
            DbUtils.closeQuietly(statement);
            DbUtils.closeQuietly(resultSet);
            DbUtils.closeQuietly(connection.getConnection());
        }
    }
}


