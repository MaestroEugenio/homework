package com.bank.jto;

public class BankCard {
    private String number;
    private User user;

    public BankCard(User user){
        this.user = user;
    }

    public BankCard(String number, User user) {
        this.number = number;
        this.user = user;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public User getUser() {
        return new User(user);
    }

    public void setUser(User user) {
        this.user = user;
    }
}
