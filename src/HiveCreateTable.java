import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class HiveCreateTable {
    public static String driverName = "org.apache.hive.jdbc.HiveDriver";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Register driver and create driver instance
        Class.forName(driverName);

        // get connection
        Connection con = DriverManager.getConnection("jdbc:hive2://192.168.209.101:10000/userdb", "root", "root1234");
        Statement stmt = con.createStatement();

        // CREATE TABLE 创建表
        String sql = "CREATE TABLE IF NOT EXISTS"
                + " employee (eid int, name String, "
                + " salary String, destignation String)"
                + " COMMENT 'Employee details'"
                + " ROW FORMAT DELIMITED"
                + " FIELDS TERMINATED BY '\\t'"
                + " LINES TERMINATED BY '\\n'"
                + " STORED AS TEXTFILE";
        stmt.execute(sql);
        System.out.println("Table employee created successfully.");

        con.close();
    }
}
