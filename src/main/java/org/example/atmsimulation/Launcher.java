package org.example.atmsimulation;

import javafx.application.Application;
import org.example.atmsimulation.model.Account;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class Launcher {
    public static List<Account> accounts = new ArrayList<>();

    public static void main(String[] args) {

        Account acc1 = new Account("123456789", "Hasan", "Kaya");
        acc1.setCardIds("123456789", "1234", 123, YearMonth.of(2028, 12), acc1.getAccountId(), "Premium");
        accounts.add(acc1);

        Account acc2 = new Account("987654321", "Ayşe", "Yılmaz");
        acc2.setCardIds("987654321", "4321", 456, YearMonth.of(2027, 6), acc2.getAccountId(), "Student");
        accounts.add(acc2);

        Account acc3 = new Account("456123789", "Mehmet", "Demir");
        acc3.setCardIds("456123789", "5678", 789, YearMonth.of(2029, 3), acc3.getAccountId(), "Premium");
        accounts.add(acc3);

        Account acc4 = new Account("321654987", "Zeynep", "Çelik");
        acc4.setCardIds("321654987", "8765", 321, YearMonth.of(2030, 9), acc4.getAccountId(), "Standart");
        accounts.add(acc4);
        Application.launch(ATMApplication.class, args);
    }
}
