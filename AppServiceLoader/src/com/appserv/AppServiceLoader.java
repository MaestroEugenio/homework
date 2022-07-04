package com.appserv;

import com.bank.api.Bank;
import com.bank.jto.*;
import com.cloud.service.impl.BankException;
import com.service.api.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ServiceLoader;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class AppServiceLoader {



    public static void main(String[] args) {
        ServiceLoader<Service> loader = ServiceLoader.load(Service.class);
        Iterable<Service> iterable = ()-> loader.iterator();
        Service serviceI = iterable.iterator().next();
        System.out.println();

        //GetAllUsers function
        System.out.println("---Get all users");
        List<User> users = serviceI.getAllUsers();
        users.forEach(System.out::println);
        System.out.println();

        //Find Card by condition
        System.out.println("---Find Card by Subscription");
        Optional<Subscription> subs = null;
        try {
            subs = serviceI.getSubscriptionByBankCardNumber("3341223");
        } catch (BankException e) {
            throw new RuntimeException(e);
        }
        if(subs.isPresent())System.out.println(subs);
        System.out.println();

        //Add user to list
        System.out.println("---Add user");
        User user = new User("Rafael", "Rfa", LocalDate.of(2022, 06, 11));
        serviceI.addUser(user);

        System.out.println();

        //Get All subs by condition
        System.out.println("---Get all subs by condition");
        List<Subscription> listSub = serviceI.getAllSubscriptionsByCondition(n -> n.getBankcard().startsWith("334"));
        listSub.forEach(System.out::println);
        System.out.println();

        //Subscribe a bankcard
        System.out.println("---Subscribe a bankcard");
        Bank bank = CreditBankCard::new;
        BankCard bankCard = bank.createBankCard(user);
        bankCard.setNumber("33321");
        serviceI.subscribe(bankCard);
        System.out.println();

        //User is payable
        System.out.println("---Is payable");
        User younger = new User("David", "david12", LocalDate.of(2008, 9, 04));
        boolean isPayable = Service.isPayable(younger);
        System.out.println(isPayable);
        System.out.println();

        //Average
        System.out.println("---Age average");
        List<User> usersAv = serviceI.getAllUsers();
        double ave = serviceI.getAverageUsersAge(usersAv);
        System.out.println(ave);
    }
}
