package br.com.java.rev.sonda2.application;

import br.com.java.rev.sonda2.entities.Vehicle;
import br.com.java.rev.sonda2.entities.CarRental;
import br.com.java.rev.sonda2.services.BrazilTaxService;
import br.com.java.rev.sonda2.services.RentalService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Entre com os dados do Alueguel:");
        System.out.print("Modelo do carro: ");
        String model = scanner.nextLine();
        System.out.print("Retirada (dd/MM/yyyy HH:mm): ");
        LocalDateTime data01 = LocalDateTime.parse(scanner.nextLine(), dateTimeFormatter);
        System.out.print("Retorno (dd/MM/yyyy HH:mm): ");
        LocalDateTime data02 = LocalDateTime.parse(scanner.nextLine(), dateTimeFormatter);
        CarRental carRental = new CarRental(new Vehicle(model), data01, data02);
        System.out.print("Entre com o preço por hora: ");
        Double valuePerHour = scanner.nextDouble();
        System.out.print("Entre com o preco por dia: ");
        Double valuePerDay = scanner.nextDouble();

        RentalService rentalService = new RentalService(valuePerHour, valuePerDay, new BrazilTaxService());
        rentalService.processInvoice(carRental);

        System.out.println("FATURA: ");
        System.out.println("Pagamento basico: " + String.format("%.2f", carRental.getInvoice().getBasicPayment()));
        System.out.println("Imposto: " + String.format("%.2f", carRental.getInvoice().getTax()));
        System.out.println("Pagamento total: " + String.format("%.2f", carRental.getInvoice().getTotalPayment()));

    }
}
