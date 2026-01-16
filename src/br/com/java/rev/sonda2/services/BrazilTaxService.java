package br.com.java.rev.sonda2.services;

import br.com.java.rev.sonda2.impl.Tax;

public class BrazilTaxService implements Tax {

    @Override
    public double taxPayment(double amount) {
        if(amount <= 100.00){
            return amount * 0.2;
        } else {
            return amount * 0.15;
        }
    }
}
