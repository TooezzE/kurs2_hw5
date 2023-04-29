import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

public class Main {
    public static void main(String[] args) {
        String login = "A_z";
        String password = "11_1";
        String confirmPassword = "11_1";
        try{
            checkUser(login,password,confirmPassword);
        } catch (WrongLoginException e){
            e.printStackTrace();
            System.out.print("Проверьте правильно ли введен логин");
        } catch (WrongPasswordException e){
            e.printStackTrace();
            System.out.print("Проверьте ли введены пароли");
        } finally {
            System.out.println(" | Проверка завершена |");
        }
    }

    public static void checkUser(String login, String password, String confirmPassword){
        if(login.length() > 20 || !login.matches("^[a-zA-Z0-9_]*$")){
                throw new WrongLoginException("Логин не соответствует условию");
        } else if(password.length() > 20 || !password.matches("^[a-zA-Z0-9_]*$")){
                throw new WrongPasswordException("Пароль не соответствует условию");
        } else  if (!password.equals(confirmPassword)){
                throw new WrongPasswordException("Пароли не совпадают");
        }
    }
}