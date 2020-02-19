import java.sql.*;

public class HiveQLWhere {
    public static String driverName = "org.apache.hive.jdbc.HiveDriver";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Register driver and create driver instance
        Class.forName(driverName);

        // get connection
        Connection con = DriverManager.getConnection("jdbc:hive2://192.168.209.101:10000/userdb", "root", "root1234");
        Statement stmt = con.createStatement();

        // WHERE 条件查询
        String sql = "SELECT * FROM employee WHERE salary>40000";
        ResultSet res = stmt.executeQuery(sql);

        System.out.println("Result:");
        System.out.println(" ID \t Name \t Salary \t Designation ");
        while (res.next()){
            System.out.print(res.getInt(1) + "\t" + res.getString(2) + "\t" + res.getDouble(3) + "\t" + res.getString(4) + "\n");
        }

        con.close();
    }
}
