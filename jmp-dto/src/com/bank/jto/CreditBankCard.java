package com.bank.jto;


public class CreditBankCard extends BankCard{

    public CreditBankCard(String number, User user) {
        super(number, user);
    }

    public CreditBankCard(User user) {
        super(user);
    }
}
