package com.application;

import com.bank.api.Bank;
import com.bank.jto.*;

import com.cloud.bank.impl.BankCardFactory;
import com.cloud.service.impl.BankService;
import com.service.api.BankException;

import javax.swing.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class BankApp extends JFrame {

    private JLabel lblUser;
    private JButton btnGenCreCard;
    private JButton btnGenDebCard;
    private JTextField txtUsrName;
    private JTextField txtSUsrName;
    private JLabel lblUsrName;
    private JLabel lblSUsrName;
    private JButton btnRegister;
    private JLabel lblBirthday;
    private JTextField txtBirthday;
    private JLabel lblCards;
    private JPanel pnlBankApp;
    private JButton btnGetSubsByCondition;
    private JButton btnGetSubsDebit;
    private JButton btnFinCard;
    private JTextField txtCardNumber;
    private JLabel lblFinCard;

    public BankApp() {

        btnGenCreCard.addActionListener(e -> {
            BankCardFactory factory = new BankCardFactory();
            BankService serv = new BankService();
            User user = new User("Fernanda", "FFer", LocalDate.of(1990, 01, 19));

            //Old method
            //var credit = factory.createBankCard(user, BankCardType.CREDIT);

            //Method reference implementation
            Bank bank = CreditBankCard::new;
            BankCard bankCard = bank.createBankCard(user);

            System.out.println(bankCard.getNumber());
            int input = JOptionPane.showConfirmDialog(null, "Do you want to subscribe?");
            if(input==0)serv.subscribe(bankCard);
        });

        btnGenDebCard.addActionListener(e -> {
            BankCardFactory factory = new BankCardFactory();
            BankService serv = new BankService();
            LocalDate birthday = LocalDate.of(2004, 11, 19);
            User user = new User("Oscar", "OMaestro", birthday );

            //Old method
            //var debit = factory.createBankCard(user, BankCardType.DEBIT);

            //Method reference implementation
            Bank bank = DebitBankCard::new;
            BankCard debit = bank.createBankCard(user);

            System.out.println(debit.getNumber());
            int input = JOptionPane.showConfirmDialog(null, "Do you want to subscribe?");
            if(input==0)serv.subscribe(debit);

        });

        btnRegister.addActionListener(e -> {
            String name = txtUsrName.getText();
            String surName = txtSUsrName.getText();
            LocalDate birthday= LocalDate.parse(txtBirthday.getText());
            User user = new User(name, surName, birthday);
            System.out.println("User registered");
        });


        btnGetSubsByCondition.addActionListener(e -> {
            BankService bankService = new BankService();
            //Predicate<Subscription> predicate = ;
            List<Subscription> subsWithCredit = bankService.getAllSubscriptionsByCondition(sub -> sub.getBankcard().startsWith("5233"));
            System.out.println(subsWithCredit.toString());
        });
        btnFinCard.addActionListener(e-> {
           BankService bankService = new BankService();
            Optional<Subscription> sub = null;
            try {
                sub = bankService.getSubscriptionByBankCardNumber(txtCardNumber.getText());
            } catch (BankException ex) {
                throw new RuntimeException(ex);
            }
            if(sub.isPresent()) System.out.println(sub);

        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("BankApp");
        frame.setContentPane(new BankApp().pnlBankApp);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
