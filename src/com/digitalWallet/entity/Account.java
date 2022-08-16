package com.digitalWallet.entity;

import com.digitalWallet.util.AccountNumberGenerator;

import java.math.BigDecimal;
import java.util.Set;
import java.util.TreeSet;

public class Account {
    private int accountNumber;
    private User user;
    private BigDecimal balance;
    private Set<Transaction> transactions;

    public Account(String name, BigDecimal amount){
        this.user=new User(name);
        this.balance=amount;
        this.transactions=new TreeSet<>((a,b) -> a.getDate().compareTo(b.getDate()));
        this.accountNumber= AccountNumberGenerator.getNextAccountNumber();
    }

    @Override
    public String toString() {
        return "Account [accountNumber=" + accountNumber + ", name=" + this.user.getUsername() + ", balance=" + balance + ", transactions=" + transactions + "]";
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }
}
