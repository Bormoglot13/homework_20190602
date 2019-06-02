package atm.storage;

import atm.exceptions.AuthException;
import atm.exceptions.MissingAccountException;
import atm.log.Logger;
import atm.model.Account;
import atm.model.Credentials;
import atm.services.ConsoleAuthentification;

import java.util.*;

public class AtmStorage {
    public static Set<Account> list;
    public static Map<Credentials,Integer> credentialsAccount;

    static {
        //Список счетов
        list = new HashSet<>();
        list.add(new Account("vova1","1234567"));
        list.add(new Account("petya","454685468569"));
        list.add(new Account("vova1","5745484"));
        list.add(new Account("sasha2","786e557"));
        list.add(new Account("lipa","64657588"));


        //Соответствие пинкодам и аккаунтам
        credentialsAccount = new HashMap<>();
        credentialsAccount.put(new Credentials("vova1","3456"),1);
        credentialsAccount.put(new Credentials("petya","3456"),1);
        credentialsAccount.put(new Credentials("sasha2","3456"),1);
        credentialsAccount.put(new Credentials("lipa","3456"),1);

    }

    public static void main(String[] args) {
        ConsoleAuthentification consoleAuth = new ConsoleAuthentification();
        Scanner scanner  = new Scanner(System.in);
        String login = "start";
        String pass;
        try {
            while (!login.equals("stop")) {
                System.out.println("Введите логин \n");
                login = scanner.nextLine();
                System.out.println("Введите пароль \n");
                pass = scanner.nextLine();

                try {
                    consoleAuth.login(login,pass);
                    Logger.log(login, "INFO");
                    // делаем какие-то операции  со счетом
                } catch (AuthException e) {
                    Logger.log(login + " AuthException" , "ERROR");
                } catch (MissingAccountException e) {
                    Logger.log(login+ " MissingAccountException" , "ERROR");
                }
            }
        } finally {
            Logger.close();
        }
    }

}
