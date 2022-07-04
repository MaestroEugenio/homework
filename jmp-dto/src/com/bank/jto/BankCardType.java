package com.bank.jto;

public enum BankCardType {
    CREDIT("Credit"), DEBIT("Debit");

    private final String type;
    BankCardType(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }
}
