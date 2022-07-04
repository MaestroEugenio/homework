package com.bank.jto;

public class DebitBankCard extends BankCard{
    public DebitBankCard(String number, User user) {
        super(number, user);
    }
    public DebitBankCard(User user){
        super(user);
    };
}
