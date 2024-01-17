package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static org.example.Deposit.addDeposit;
import static org.example.Transactions.makePayment;
import static org.example.Transactions.showLedger;

public class Accounting {
    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, ArrayList<Transactions>> ledger = new HashMap<>();


        while (true) {
            System.out.println("Home Screen:");
            System.out.println("1) Add deposit");
            System.out.println("2) Make payment (Debit)");
            System.out.println("3) Ledger");
            System.out.println("4) Exit");
            System.out.println("Enter your choice:");
            int userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1:
                    addDeposit(ledger);
                    break;
                case 2:
                    makePayment(ledger);
                    break;
                case 3:
                    showLedger(ledger);
                    break;
                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}



// Home screen should have Add Deposit, Make Payment(Debit), Ledger, Exit
        // Under the ledger 1) All, 2) Deposits, 3) Payments, 4) Reports
        // Under 4) Reports, allow user to run a customer search.
        // Customer search 1) Month to Date 2) Previous Month 3) Year to Date 4) previous year 5) Search by Vendor
        // Under 5) Search by Vendor, prompt the user for the vendor name and display all entries for that vendor and add a 1) Back- go back to the report page 2 ) Home- go back to the home page


