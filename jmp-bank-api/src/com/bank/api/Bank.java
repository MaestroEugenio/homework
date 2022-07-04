package com.bank.api;

import com.bank.jto.BankCard;
import com.bank.jto.BankCardType;
import com.bank.jto.User;

public interface Bank {
    BankCard createBankCard(User user);
}
