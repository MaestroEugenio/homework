package com.cloud.bank.impl;

import com.bank.api.Bank;
import com.bank.jto.BankCard;
import com.bank.jto.User;
import com.bank.jto.BankCardType;
import com.bank.jto.CreditBankCard;
import com.bank.jto.DebitBankCard;

import java.util.Random;

public class BankCardFactory implements Bank {
    private static final String CREDIT_INIT = "5233";
    private static final String DEBIT_INIT = "6431";

    public BankCard createBankCardWithType(User user, BankCardType bankType) {

        if(bankType.name().equals("CREDIT")){
            Random numGen = new Random();
            long numberCard = (long) numGen.nextDouble(10_000_000_000_000.0, 99_000_000_000_000.0);
            String numCard = CREDIT_INIT + "33323144123";
            CreditBankCard creditCard = new CreditBankCard(numCard, user);
            System.out.println("Credit card created!");
            System.out.println("Number: " +numCard);
            System.out.println("Owner: " +user.getName());
            return creditCard;
        } else {
            Random numGen = new Random();
            long numberCard = (long) numGen.nextDouble(10_000_000_000_000.0, 99_000_000_000_000.0);
            String numCard = DEBIT_INIT + "233441423312";
            DebitBankCard debitCard = new DebitBankCard(numCard, user);
            System.out.println("Debit card created!");
            System.out.println("Number: " +numCard);
            System.out.println("Owner: " +user.getName());
            return debitCard;
        }
    }

    @Override
    public BankCard createBankCard(User user) {
        return new BankCard(user);
    }
}
