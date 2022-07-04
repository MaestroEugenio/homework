package com.service.api;

import com.bank.jto.BankCard;
import com.bank.jto.Subscription;
import com.bank.jto.User;
import com.cloud.service.impl.BankException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface Service {
    String getTypeService();
    void subscribe(BankCard bankCard);
    Optional<Subscription> getSubscriptionByBankCardNumber(String number) throws BankException;
    List<User> getAllUsers();

    void addUser(User user);

    List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> predicateSubs);

    public default double getAverageUsersAge(List<User> allUsers){

        LocalDate dateNow = LocalDate.now();
        //long years = 0;
        //List<User> allUsers = getAllUsers();
        List<Long> years = new ArrayList<>();

        for(User user : allUsers){
            long year = ChronoUnit.YEARS.between(user.getBirthday(),dateNow);
            years.add(year);
        }
        return years.stream().mapToDouble(year -> Double.parseDouble(year.toString()))
                .average()
                .orElse(0);

    }

    public static boolean isPayable(User user){
        LocalDate dateNow = LocalDate.now();
        long age = ChronoUnit.YEARS.between(user.getBirthday(),dateNow);
        return (age >= 18) ? true : false;

    }
}
