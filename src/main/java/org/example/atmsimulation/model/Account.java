package org.example.atmsimulation.model;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountId;
    private String name;
    private String Surname;
    private double balance;
    private List<Card> card;

    public Account(String accountId, String name, String surname) {
        this.accountId = accountId;
        this.name = name;
        Surname = surname;
        this.card = new ArrayList<>();
        this.balance = 0.0;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCardIds(String cardId, String password, int ccv, YearMonth expiryDate, String accountId) {
        card.add(new Card(cardId, password, ccv, expiryDate, accountId));
    }

    public String getAccountId() {
        return accountId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return Surname;
    }

    public double getBalance() {
        return balance;
    }

    public List<Card> getCard() {
        return card;
    }
}
