package org.example.atmsimulation.model;

import java.time.YearMonth;

public class Card {
    private String cardId;
    private String password;
    private int ccv;
    private YearMonth expiryDate;
    private String accountId;

    public Card(String cardId, String password, int ccv, YearMonth expiryDate, String accountId) {
        this.cardId = cardId;
        this.password = password;
        this.ccv = ccv;
        this.expiryDate = expiryDate;
        this.accountId = accountId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCcv() {
        return ccv;
    }

    public YearMonth getExpiryDate() {
        return expiryDate;
    }

    public String getAccountId() {
        return accountId;
    }
}
