import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class HiveLoadData {
    public static String driverName = "org.apache.hive.jdbc.HiveDriver";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Register driver and create driver instance
        Class.forName(driverName);

        // get connection
        Connection con = DriverManager.getConnection("jdbc:hive2://192.168.209.101:10000/userdb", "root", "root1234");
        Statement stmt = con.createStatement();

        // LOAD DATA 加载数据
        // LOCAL 从本地加载数据
        String sql = "LOAD DATA LOCAL INPATH '/root/code/myhive/sample.txt' OVERWRITE INTO TABLE employee";
        stmt.execute(sql);
        System.out.println("Load data into employee successfully from local file.");

        con.close();
    }
}
