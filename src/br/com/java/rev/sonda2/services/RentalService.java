package br.com.java.rev.sonda2.services;

import br.com.java.rev.sonda2.entities.CarRental;
import br.com.java.rev.sonda2.entities.Invoice;
import br.com.java.rev.sonda2.impl.Tax;

import java.time.Duration;

public class RentalService {

    private Double pricePerHour;
    private Double pricePerDay;
    private Tax tax;

    public RentalService(Double pricePerHour, Double pricePerDay, Tax tax) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.tax = tax;
    }

    public RentalService() {
    }

    public void processInvoice(CarRental carRental)
    {
       long minutos = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
       double hour = (double) minutos / 60;
       double basicPayment;

       if(hour <= 12){
           basicPayment = pricePerHour * Math.ceil(hour);
       } else {
           basicPayment = pricePerDay * Math.ceil(hour / 24);
       }

       carRental.setInvoice(new Invoice(tax.taxPayment(basicPayment), basicPayment));

    }

    public Double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(Double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }
}
