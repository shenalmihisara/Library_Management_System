package Controllers.Login;

public class LoginController {
    public boolean CheckUserNameAndPassword(String name, String password) {
        if (name.equals("Shenal") && password.equals("1234")){
            return true;
        }
        return false;
    }
}
