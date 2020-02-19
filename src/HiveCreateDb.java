import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class HiveCreateDb {

    /*
    这个例子无法执行成功，hive 创建库的权限将被拒绝。
    需要修改 conf/hdfs-site.xml 配置文件，将 dfs.permissions 属性修改为 false（默认为true）。
     */
    public static String driverName = "org.apache.hive.jdbc.HiveDriver";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Register driver and create driver instance
        Class.forName(driverName);

        // get connection
        Connection con = DriverManager.getConnection("jdbc:hive2://192.168.209.101:10000/default", "", "");
        Statement stmt = con.createStatement();

        stmt.executeQuery("CREATE DATABASE userdb");
        System.out.println("Database userdb created successfully!");

        con.close();

    }
}
