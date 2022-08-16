package com.digitalWallet.service;

import com.digitalWallet.dao.WalletDao;
import com.digitalWallet.entity.Account;
import com.digitalWallet.entity.Transaction;
import com.digitalWallet.offers.Context;
import com.digitalWallet.offers.EqualsOffer;
import com.digitalWallet.offers.Strategy;
import jdk.internal.platform.cgroupv1.SubSystem;

import java.math.BigDecimal;
import java.util.Date;

public class WalletService {
    private WalletDao dao;

    public WalletService(){
        this.dao=new WalletDao();
    }

    public void createWallet(String name, BigDecimal amount){
        Account account = new Account(name,amount);
        dao.getAccountMap().put(account.getAccountNumber(),account);
        System.out.println("Account created for user"+name+" account number="+account.getAccountNumber());
    }

    public void transfer(int from, int to, BigDecimal amount){
        if(!validate(from, to, amount)){
            return;
        }
        Transaction transaction = new Transaction(from,to,amount,new Date());
        Account fromAcc = dao.getAccountMap().get(from);
        Account toAcc = dao.getAccountMap().get(to);
        if(fromAcc.getBalance().compareTo(amount)<0){
            System.out.println("insufficient Balance");
            return;
        }
        fromAcc.setBalance(fromAcc.getBalance().subtract(amount));
        toAcc.setBalance(toAcc.getBalance().add(amount));
        fromAcc.getTransactions().add(transaction);
        toAcc.getTransactions().add(transaction);
//        dao.getTransactionMap().get(from).add(transaction);
//        dao.getTransactionMap().get(to).add(transaction);
        System.out.println("Transfer Successful");
    }

    private boolean validate(int from, int to, BigDecimal amount){
        if(from==to){
            System.out.println("sender and receiver cannot be same");
            return false;
        }

        if(amount.compareTo(new BigDecimal(0.0001))<0){
            System.out.println("Amount too low");
            return false;
        }

        if (!dao.getAccountMap().containsKey(from)) {
            System.out.println("Invalid Sender account number");
            return false;
        }
        if (!dao.getAccountMap().containsKey(to)) {
            System.out.println("Invalid Receiver account number");
            return false;
        }
        return true;
    }

    public void statement(int accNumber){
        Account account = dao.getAccountMap().get(accNumber);
        if(account==null){
            System.out.println("Invalid account number");
            return;
        }
        System.out.println("Summary for account"+account.getAccountNumber());
        System.out.println("Current balance"+account.getBalance());
        System.out.println("Your Transaction history");
        System.out.println(account.getTransactions());
    }

    public void overview(){
        for(int accNum : dao.getAccountMap().keySet()){
            System.out.print("Balance for acc number" + accNum + ":");
            System.out.println(dao.getAccountMap().get(accNum).getBalance());
        }
    }

    public void offers(int from, int to){
        Account fromAcc = dao.getAccountMap().get(from);
        Account toAcc = dao.getAccountMap().get(to);
        if(fromAcc.getBalance().compareTo(toAcc.getBalance())!=0){
            System.out.println("balance not equal");
            return;
        }
        int offer=1;
        Strategy offerFinal = new Context(offer, dao).getOfferStrategy();
        offerFinal.executeOffer(from,to);
    }
}
