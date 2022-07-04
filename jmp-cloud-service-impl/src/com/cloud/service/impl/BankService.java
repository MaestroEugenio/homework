package com.cloud.service.impl;


import com.bank.jto.BankCard;
import com.bank.jto.Subscription;
import com.bank.jto.User;
import com.service.api.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BankService implements Service {

    List<User> allUsers = new ArrayList<>();
    List<Subscription> subscriptions = new ArrayList<>();

    public String getTypeService(){
        return "BankService";
    }
    @Override
    public void subscribe(BankCard bankCard) {
        Subscription subs = new Subscription(bankCard.getNumber(), LocalDateTime.now().toLocalDate());
        subscriptions.add(subs);
        subscriptions.forEach(System.out::println);
    }

    @Override
    public Optional<Subscription> getSubscriptionByBankCardNumber(String number) throws BankException {
        return Optional.ofNullable(Optional.ofNullable(findSubscriptionByCard(number)).orElseThrow(() -> new BankException()));
    }

    private Subscription findSubscriptionByCard(String number){
        subscriptions.add(new Subscription());
        subscriptions.add(new Subscription());
        subscriptions.add(new Subscription("334123441233313", LocalDate.now()));
        subscriptions.add(new Subscription("3324412331", LocalDate.now()));
        subscriptions.add(new Subscription("2233155123", LocalDate.now()));
        subscriptions.add(new Subscription("3341223", LocalDate.now()));
        for(Subscription subscription : subscriptions){
            if(subscription.getBankcard().equals(number)) return subscription;
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        allUsers.add(new User("User1", "Us", LocalDate.of(1990, 6, 23)));
        allUsers.add(new User("User2", "Us2", LocalDate.of(1979, 3, 28)));
        allUsers.add(new User("Karla", "krl", LocalDate.of(2012, 9, 22)));
        allUsers.add(new User("Ricardo", "rch", LocalDate.of(2003, 11, 20)));
        allUsers.add(new User("Donovan", "don", LocalDate.of(1980, 9, 8)));
        return (List<User>) allUsers.stream().collect(Collectors.toUnmodifiableList());
    }

    @Override
    public List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> predicateSubs) {
        subscriptions.add(new Subscription());
        subscriptions.add(new Subscription());
        subscriptions.add(new Subscription("334123441233313", LocalDate.now()));
        subscriptions.add(new Subscription("5534412", LocalDate.now()));
        subscriptions.add(new Subscription("4441231", LocalDate.now()));
        subscriptions.add(new Subscription("22334414", LocalDate.now()));
        return subscriptions.stream()
                .filter(predicateSubs)
                .collect(Collectors.toList());
    }

    public void addUser(User user){
        allUsers.add(user);
        allUsers.forEach(System.out::println);
    }

}
