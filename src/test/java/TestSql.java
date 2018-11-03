import com.mysql.jdbc.Driver;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSql {
    @Test
    public void TestSql(){
        Statement statement = null;
        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://132.232.9.41:3306/sancaijia?useUnicode=true&characterEncoding=UTF8&useSSL=true";
            String user = "root";
            String password = "123456";
            Connection connection = DriverManager.getConnection(url, user, password);

            statement = connection.createStatement();
            String sql = "INSERT INTO `sancaijia`.`User` (`id`, `username`, `password`, `company`, `age`, `sex`) VALUES ('5', 'fff', '123', '1', '12', 'asdf')";
            boolean execute = statement.execute(sql);
            System.out.println(execute);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



    }
}
