package pocket;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class LoginActions {
    List<User> users = new ArrayList<User>();
    @PostConstruct
    public void init() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ignored) {
        }
    }

    public PreparedStatement getConnection(String insertion) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5434/postgres", "postgres", "root");
        PreparedStatement statement = connection.prepareStatement(insertion);
        return statement;
    }

    public String addUser(User user) throws SQLException {
        PreparedStatement statement = getConnection("insert into users values(?,?)");
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getPassword());
        statement.executeUpdate();
        return "user is added"+user.toString();
    }
    public String login(User user)throws SQLException{
        PreparedStatement preparedStatement=getConnection("select * from users where username=? and password=?");
        preparedStatement.setString(1,user.getUsername());
        preparedStatement.setString(2,user.getPassword());
        preparedStatement.execute();
        return "you are in";
    }
}
