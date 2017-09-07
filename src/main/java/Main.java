import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Ромашка on 07.09.2017.
 */
public class Main {

    public static void main(String[] args) {
        DBWorker dbWorker = new DBWorker();
        String query = "select * from test";

        try {
            Statement statement = dbWorker.getConnection().createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setUsername(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                System.out.println(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
