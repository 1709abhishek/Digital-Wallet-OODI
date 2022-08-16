package com.digitalWallet.offers;

import com.digitalWallet.dao.WalletDao;
import com.digitalWallet.entity.Account;

import java.math.BigDecimal;

public class EqualsOffer implements Strategy {

    private WalletDao dao;

    public EqualsOffer(WalletDao dao){
        this.dao=dao;
    }

    @Override
    public void executeOffer(int from, int to) {
        Account fromAcc = dao.getAccountMap().get(from);
        Account toAcc = dao.getAccountMap().get(to);
        fromAcc.setBalance(fromAcc.getBalance().add((new BigDecimal(10))));
        toAcc.setBalance(toAcc.getBalance().add(new BigDecimal(10)));
        System.out.println("added 10 rupees to both ");
    }
}
