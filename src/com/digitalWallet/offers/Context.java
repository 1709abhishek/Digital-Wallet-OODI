package com.digitalWallet.offers;

import com.digitalWallet.dao.WalletDao;

public class Context {
    private WalletDao dao;
    Strategy offerStrategy;

    public Context(int offerNumber, WalletDao dao){
        this.dao=dao;
        if(offerNumber==1){
            this.offerStrategy=new EqualsOffer(dao);
        }else{
            this.offerStrategy=new TopOffer(dao);
        }
    }

    public Strategy getOfferStrategy(){
        return this.offerStrategy;
    }
}
