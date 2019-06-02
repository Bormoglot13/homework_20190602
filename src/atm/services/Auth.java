package atm.services;

import atm.exceptions.AuthException;
import atm.exceptions.MissingAccountException;
import atm.model.Account;

public interface Auth {
    Account login(String login, String password) throws AuthException, MissingAccountException;
}
