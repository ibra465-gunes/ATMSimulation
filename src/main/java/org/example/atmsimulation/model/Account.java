package org.example.atmsimulation.model;

import org.example.atmsimulation.utilities.TransactionType;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {
    private String accountId;
    private String name;
    private String surname;
    private double balance;
    private List<Card> card;
    private List<Transaction> transaction;

    public Account(String accountId, String name, String surname) {
        this.accountId = accountId;
        this.name = name;
        this.surname = surname;
        this.card = new ArrayList<>();
        this.transaction = new ArrayList<>();
        this.balance = 0.0;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCardIds(String cardId, String password, int ccv, YearMonth expiryDate, String accountId, String cardType) {
        card.add(new Card(cardId, password, ccv, expiryDate, accountId, cardType));
    }

    public String getAccountId() {
        return accountId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public double getBalance() {
        return balance;
    }

    public List<Card> getCard() {
        return card;
    }

    public List<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(double amount, TransactionType type, Date date, String description, String targetAccount) {
        Transaction newTransaction = new Transaction();
        newTransaction.setAmount(amount);
        newTransaction.setType(type);
        newTransaction.setDate(date);
        newTransaction.setDescription(description);
        newTransaction.setTargetAccount(targetAccount);
        transaction.add(newTransaction);
    }
}
