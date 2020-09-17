package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ExportCsv {
    public static void toCSV(ResultSet resultSet) throws IOException, SQLException {
        FileWriter csvWriter = new FileWriter("new.csv");
        ResultSetMetaData rsmd = resultSet.getMetaData();
        int columnsNumber = rsmd.getColumnCount();

        for (int i = 1; i <= columnsNumber; i++) {
            if (i > 1) csvWriter.append(",");
            csvWriter.append(rsmd.getColumnName(i));
        }
        csvWriter.append("\n");
        while (resultSet.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) csvWriter.append(",");
                String columnValue = resultSet.getString(i);
                csvWriter.append(columnValue);
            }
            csvWriter.append("\n");
        }
        csvWriter.flush();
        csvWriter.close();
    }
}

