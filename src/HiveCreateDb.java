import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class HiveCreateDb {

    /*
    注意 hive 的执行权限问题，root 账户可以执行成功。
    否则需要修改 conf/hdfs-site.xml 配置文件，将 dfs.permissions 属性修改为 false（默认为true）。
     */
    public static String driverName = "org.apache.hive.jdbc.HiveDriver";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Register driver and create driver instance
        Class.forName(driverName);

        // get connection
        Connection con = DriverManager.getConnection("jdbc:hive2://192.168.209.101:10000/default", "root", "root1234");
        Statement stmt = con.createStatement();

        // CREATE DATABASE 创建数据库
        // DROP DATABASE 删除数据库
        stmt.execute("CREATE DATABASE IF NOT EXISTS userdb");
        System.out.println("Database userdb created successfully.");

        con.close();

    }
}
