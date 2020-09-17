import taskClasses.*;
import org.junit.jupiter.api.Test;
import utils.RelativePathTransformer;

public class TestTasks {
    @Test
    public void testTask1() {
        String queryTask1 = "SELECT last_name, email FROM sales.customers";
        Read.readQuery(queryTask1);
    }

    @Test
    public void testTask2()  {
        String queryTask2 = "UPDATE production.products SET list_price = '111.11' WHERE product_id = '1'";
        System.out.printf("Number of records updated {%d}", Update.updateQuery(queryTask2));
    }

    @Test
    public void testTask3() {
        String queryTask3 = "DELETE FROM production.stocks WHERE quantity = '1'";
        System.out.printf("Number of records deleted {%d}", Update.updateQuery(queryTask3));
    }

    @Test
    public void testTask4(){
        String queryTask4 = "INSERT INTO sales.staffs VALUES('Test2','Test2','test2@emai.bikes.shop','(111) 111-1111','1','1','1')";
        System.out.printf("Number of records inserted {%d}", Update.updateQuery(queryTask4));
    }

    @Test
    public void testTask5(){
        String tableName = ("BikeStores.production.products");
        String csvPath= RelativePathTransformer.getRelativePath("bikeProducts.csv");
        long startTime = System.nanoTime();
        BulkInsertTSQL.bulkInsertQuery(tableName, csvPath);
        long stopTime = System.nanoTime();
        System.out.println("Time Bulk insert using T-SQL:"+(stopTime - startTime));
    }
    @Test
    public void testTask5_2(){
        String tableName = ("BikeStores.production.products");
        String csvPath= RelativePathTransformer.getRelativePath("bikeProducts.csv");
        long startTime = System.nanoTime();
        BulkInsertSQLserverBulk.insertbulk(tableName,csvPath);
        long stopTime = System.nanoTime();
        System.out.println("Time Bulk insert using SQLServerBulkCSVFileRecord:"+(stopTime - startTime));
    }

}
