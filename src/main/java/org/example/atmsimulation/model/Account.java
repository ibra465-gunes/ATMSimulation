package org.example.atmsimulation.model;

import java.util.List;

public class Account {
    private String accountId;
    private String name;
    private String Surname;
    private double balance;
    private List<Card> cardIds;

    public Account(String accountId, String name, String surname) {
        this.accountId = accountId;
        this.name = name;
        Surname = surname;
        this.balance = 0.0;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCardIds(List<Card> cardIds) {
        this.cardIds = cardIds;
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

    public List<Card> getCardIds() {
        return cardIds;
    }
}
