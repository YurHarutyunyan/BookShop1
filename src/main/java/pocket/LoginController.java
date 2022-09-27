package pocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping (value = "/user")
public class LoginController {
    LoginActions actions = new LoginActions();
@Autowired
    public LoginController(LoginActions actions) {
        this.actions = actions;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody User user)throws SQLException {
        return actions.login(user);

    }

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public void signIn(@RequestBody User user)throws SQLException {
        actions.addUser(user);
    }
}
