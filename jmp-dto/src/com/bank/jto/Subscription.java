package com.bank.jto;

import java.time.LocalDate;
import java.util.Random;

public class Subscription {
    String bankcard;
    LocalDate startDate;
    Random ran = new Random();
    public Subscription(){
        this.bankcard = "5233" + ran.ints(1999, 99999)
                .toString();
        this.startDate = LocalDate.now();
    }

    public Subscription(String bankcard, LocalDate startDate) {
        this.bankcard = bankcard;
        this.startDate = startDate;
    }

    public String getBankcard() {
        return bankcard;
    }

    public void setBankcard(String bankcard) {
        this.bankcard = bankcard;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "bankcard='" + bankcard + '\'' +
                ", startDate=" + startDate +
                '}';
    }
}
