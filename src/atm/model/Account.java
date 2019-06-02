package atm.model;

import java.util.Objects;

public class Account {

    String login;
    String accNumber;

    public Account() {
    }

    public Account(String login, String accNumber) {
        this.login = login;
        this.accNumber = accNumber;
    }

    public Account(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public String getAccNumber() {
        return accNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return login.equals(account.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }
}
