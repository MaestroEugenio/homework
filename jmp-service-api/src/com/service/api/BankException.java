package com.service.api;

public class BankException {

    public class BankException extends Exception {
        public static final String CARD_NOT_FOUND = "404 Card not found";

        public BankException(){
            super(CARD_NOT_FOUND);
        }
        public BankException(String error){
            super(error);
            //throw new RuntimeException();
        }
    }

}
