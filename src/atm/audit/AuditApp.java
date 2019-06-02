package atm.audit;

import java.util.Scanner;

public class AuditApp {

    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        System.out.println("Введите логин \n");
        String login = scanner.nextLine();
        Audit.findMatchByLine(login);
    }
}
