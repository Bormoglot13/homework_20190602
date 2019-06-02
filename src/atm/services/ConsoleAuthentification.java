package atm.services;

import atm.exceptions.AuthException;
import atm.exceptions.MissingAccountException;
import atm.model.Account;
import atm.model.Credentials;
import atm.storage.AtmStorage;

import java.util.Iterator;

public class ConsoleAuthentification implements Auth {

    @Override
    public Account login(String login, String password) throws AuthException, MissingAccountException {
        Integer  check = AtmStorage.credentialsAccount.get(new Credentials(login,password));
        if (check != null && check.equals(1)){
            for (Iterator<Account> it = AtmStorage.list.iterator(); it.hasNext(); ) {
                Account acc = it.next();
                if (acc.equals(new Account(login)))
                    return acc;
            }
            throw new MissingAccountException();
        } else {
            throw new AuthException();
        }
    }
}
