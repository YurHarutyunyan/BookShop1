package pocket;

public class User {
    String username;
    String password;
    Long id;
    public User(String username,String password ,Long id){
        this.username=username;
        this.password=password;
        this.id=id;
    }
    public User(){}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    @Override
    public String toString(){
        return username+" "+password+" "+id;
    }
}
