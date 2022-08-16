package com.digitalWallet.offers;

import com.digitalWallet.dao.WalletDao;
import com.digitalWallet.entity.Transaction;

import java.util.ArrayList;

import java.util.*;

public class TopOffer implements Strategy {
    private WalletDao dao;

    public TopOffer(WalletDao dao){
        this.dao=dao;
    }

    @Override
    public void executeOffer(int from, int to) {
        PriorityQueue<ArrayList<Transaction>> pQueue = new PriorityQueue<>();
        for(Integer arr : dao.getTransactionMap().keySet()){
            int size = dao.getTransactionMap().get(arr).size();
            pQueue.add(dao.getTransactionMap().get(arr));
            if(pQueue.size()>3){
                pQueue.poll();
            }
        }
        for(int i=0;i<pQueue.size();i++){
            System.out.println("xxx");
        }
    }
}

class TransactionComparator implements Comparator<ArrayList<Transaction>>{

    // Overriding compare()method of Comparator
    // for descending order of cgpa
    public int compare(ArrayList s1, ArrayList s2) {
        if (s1.size() < s2.size())
            return -1;
        else if (s1.size() > s2.size())
            return 1;
        return 0;
    }
}
