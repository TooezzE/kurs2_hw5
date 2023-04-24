import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

public class Main {
    public static void main(String[] args) {
        String login = "A&&Z";
        String password = "123";
        String confirmPassword = "123";
        checkUser(login,password,confirmPassword);
    }

    public static void checkUser(String login, String password, String confirmPassword){
        if(login.length() > 20 || !login.matches("\\w{8,}")){
            try {
                throw new WrongLoginException("Логин не соответствует условию");
            } catch (WrongLoginException e) {
                throw new RuntimeException(e);
            }
        }
        if(password.length() > 20 || !password.matches("\\w{8,}")){
            try {
                throw new WrongPasswordException("Пароль не соответствует условию");
            } catch (WrongPasswordException e) {
                throw new RuntimeException(e);
            }
        }
        if (!password.equals(confirmPassword)){
            try {
                throw new WrongPasswordException("Пароли не совпадают");
            } catch (WrongPasswordException e) {
                throw new RuntimeException(e);
            }
        }
    }
}