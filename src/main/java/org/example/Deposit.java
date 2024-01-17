package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Deposit {
    private static String customerName;
    private static double amount;
    private static String description;
    private static String date;
    private static String time;
    private static double price;

    public Deposit(String customerName, double amount, String description, String date, String time) {
        this.customerName = customerName;
        this.amount = amount;
        this.description = description;
        this.date = date;
        this.time = time;
    }

    public static void addDeposit(HashMap<String, ArrayList<Transactions>> ledger) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the customer name: ");
        customerName = scanner.nextLine();

        System.out.println("Enter the payment amount: ");
        amount = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Enter Vendors Name: ");
        String vendorName = scanner.nextLine();


        System.out.println("Enter a description: ");
        description = scanner.nextLine();

        System.out.println("Enter a date: (YYYY-MM-DD) ");
        date = scanner.nextLine();

        System.out.println("Enter a time: ");
        time = scanner.nextLine();

        Transactions deposit = new Transactions("Deposit", amount, description, date, time);
        ledger.computeIfAbsent(customerName, k -> new ArrayList<>()).add(deposit);
        System.out.println("Deposit added successfully!");

        String fileName =  "src/main/resources/payment.txt";
        try(FileWriter fileWriter = new FileWriter(fileName, true)){
            String record = (date + "|" + time + "|" + deposit + "|" + vendorName + "|" + price);
            fileWriter.write(record + System.lineSeparator());

        }
    }
}