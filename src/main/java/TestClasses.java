import TaskClasses.*;
import org.junit.jupiter.api.Test;

public class TestClasses {
    @Test
    public void testTask1() {
        String queryTask1 = "SELECT first_name, last_name, email FROM sales.customers";
        Task1Read.readQuery(queryTask1);
    }

    @Test
    public void testTask2()  {
        String queryTask2 = "UPDATE production.products SET list_price = '111.11' WHERE product_id = '1'";
        System.out.printf("Number of records updated {%d}", Task2Update.updateQuery(queryTask2));
    }

    @Test
    public void testTask3() {
        String queryTask3 = "DELETE FROM production.stocks WHERE quantity = '1'";
        System.out.printf("Number of records deleted {%d}", Task3Delete.deleteQuery(queryTask3));
    }

    @Test
    public void testTask4(){
        String queryTask4 = "INSERT INTO sales.staffs VALUES('Test2','Test2','test2@emai.bikes.shop','(111) 111-1111','1','1','1')";
        System.out.printf("Number of records inserted {%d}", Task4Insert.insertQuery(queryTask4));
    }

    @Test
    public void testTask5() {
        String csvPath = ("C:\\Users\\tdubineaschi\\IdeaProjects\\JDBCTest\\src\\main\\resources\\bikeProducts.csv");
        String tableName = ("BikeStores.production.products");
        System.out.printf("Number of records inserted {%d}", Task5BulkInsert.bulkInsertQuery(tableName, csvPath));
    }

}
