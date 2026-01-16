package br.com.java.rev.sonda2.entities;

public class Invoice {

    public Double tax;
    public Double basicPayment;

    public Invoice(Double tax, Double basicPayment) {
        this.tax = tax;
        this.basicPayment = basicPayment;
    }

    public Invoice() {
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getBasicPayment() {
        return basicPayment;
    }

    public void setBasicPayment(Double basicPayment) {
        this.basicPayment = basicPayment;
    }

    public Double getTotalPayment(){
        return this.getBasicPayment() + this.getTax();
    }
    @Override
    public String toString() {
        return "Invoice{" +
                "tax=" + tax +
                ", basicPayment=" + basicPayment +
                '}';
    }
}

