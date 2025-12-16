package org.example.atmsimulation.model;

import java.time.YearMonth;

public class Card {
    private String cardId;
    private String password;
    private int ccv;
    private YearMonth expiryDate;
    private String accountId;
    private String cardType;

    public Card(String cardId, String password, int ccv, YearMonth expiryDate, String accountId, String cardType) {
        this.cardId = cardId;
        this.password = password;
        this.ccv = ccv;
        this.expiryDate = expiryDate;
        this.accountId = accountId;
        this.cardType = cardType;
    }

    public String getCardType() {
        return cardType;
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

    public String getPassword() {
        return password;
    }
}
