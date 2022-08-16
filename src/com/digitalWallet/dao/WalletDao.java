package com.digitalWallet.dao;

import com.digitalWallet.entity.Account;
import com.digitalWallet.entity.Transaction;

import java.util.ArrayList;
import java.util.HashMap;

public class WalletDao {
    private HashMap<Integer, Account> accountMap;
    private HashMap<Integer, ArrayList<Transaction>> transactionMap;

    public WalletDao(){
        this.accountMap = new HashMap<>();
        this.transactionMap = new HashMap<>();
    }

    public HashMap<Integer, Account> getAccountMap() {
        return accountMap;
    }

    public void setAccountMap(HashMap<Integer, Account> accountMap) {
        this.accountMap = accountMap;
    }

    public HashMap<Integer, ArrayList<Transaction>> getTransactionMap() {
        return transactionMap;
    }

    public void setTransactionMap(HashMap<Integer, ArrayList<Transaction>> transactionMap) {
        this.transactionMap = transactionMap;
    }
}
