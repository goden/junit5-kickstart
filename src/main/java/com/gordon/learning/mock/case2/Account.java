package com.gordon.learning.mock.case2;

public class Account {

    private String accountId;
    private long balance;

    public  Account(String accountId, long balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public void debit(long amount) {
        this.balance -= amount;
    }

    public void withdraw(long amount) {
        this.balance += amount;
    }

    public long getBalance() {
        return balance;
    }

}
