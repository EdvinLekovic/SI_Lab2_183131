import java.util.ArrayList;
import java.util.List;

class User {
    String username;
    String password;
    String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}

public class SILab2 {

    public boolean function (User user, List<String> allUsers) { //A //User("Edvin","SuperSum123","edvin.lekovikj@students.finki.ukim.mk") [Sarko,Marko,Farko]
        if (user!=null) { //A
            if (user.getUsername()!=null && user.getEmail()!=null && !allUsers.contains(user.getUsername())) { //B
                boolean atChar = false, dotChar = false; //C1
                for (int i=0;i<user.getEmail().length();i++) { //int i=0 -> C1 ; i<user.getEmail().length() -> C2 ; i++ -> C3
                    if (user.getEmail().charAt(i)=='@') //D
                        atChar = true; //E
                    if (atChar && user.getEmail().charAt(i)=='.') { //F
                        dotChar = true;//G
                    }
                } //H
                if (atChar && dotChar) { //atChar -> I1 ; dotChar -> I2
                    return true; //J
                }
            }
        }
        return false; //K
    }




}