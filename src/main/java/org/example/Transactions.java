package org.example;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static org.example.Time.*;

public class Transactions {
   String type;
   double amount;
   String description;
   String date;
   String time;


   public Transactions(String type, double amount, String description, String date, String time) {
      this.type = type;
      this.amount = amount;
      this.description = description;
      this.date = date;
      this.time = time;
   }

   public Transactions(String type, double amount, String description) {
      this.type = type;
      this.amount = amount;
      this.description = description;
      this.date = LocalDate.now().toString(); // initialize date with current date
      this.time = LocalTime.now().toString(); // initialize time with current time
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   public double getAmount() {
      return amount;
   }

   public void setAmount(double amount) {
      this.amount = amount;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public String getDate() {
      return date;
   }

   public void setDate(String date) {
      this.date = date;
   }

   public String getTime() {
      return time;
   }

   public void setTime(String time) {
      this.time = time;
   }

   public static void showLedger(HashMap<String, ArrayList<Transactions>> ledger) {
      Scanner scanner = new Scanner(System.in);
      while (true) {
         System.out.println("Ledger:");
         System.out.println("1. All");
         System.out.println("2. Deposits");
         System.out.println("3. Payments");
         System.out.println("4. Reports");
         System.out.println("5. Back to Home");
         System.out.print("Enter your choice: ");
         int choice = scanner.nextInt();
         scanner.nextLine();


         switch (choice) {
            case 1:
               printTransactions(ledger);
               break;
            case 2:
               printTransactionsOfType(ledger, "Deposit");
               break;
            case 3:
               printTransactionsOfType(ledger, "Payment");
               break;
            case 4:
               showReportsMenu(ledger);
               break;
            case 5:
               return;
            default:
               System.out.println("Invalid choice. Please try again.");
         }

      }
   }

   public static void showReportsMenu(HashMap<String, ArrayList<Transactions>> ledger) {
      while (true) {
         Scanner scanner = new Scanner(System.in);
         System.out.println("Reports:");
         System.out.println("1) Month to Date");
         System.out.println("2) Previous Month");
         System.out.println("3) Year to Date");
         System.out.println("4) Previous Year");
         System.out.println("5) Search by Vendor");
         System.out.println("6) Back");

         int choice = scanner.nextInt();
         scanner.nextLine();
         switch (choice) {
            case 1:
               monthToDate(ledger);
               break;
            case 2:
               previousMonth(ledger);
               break;
            case 3:
               yearToDate(ledger);
               break;
            case 4:
               previousYear(ledger);
               break;
            case 5:
               searchByVendor(ledger);
               break;
            case 6:
               return;
            default:
               System.out.println("Invalid choice. Please try again.");
         }
      }
   }

   public static void searchByVendor(HashMap<String, ArrayList<Transactions>> sbv) {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter Vendor Name: ");
      String vendorName = scanner.nextLine();

      if (sbv.containsKey(vendorName)) {
         System.out.println("Transactions for Vendor " + vendorName + ":");
         for (Transactions transaction : sbv.get(vendorName)) {
            System.out.println("Type: " + transaction.type + ", Amount: $" + transaction.amount +
                    ", Description: " + transaction.description);
         }
      } else {
         System.out.println("No transactions found for Vendor " + vendorName);
      }
   }

   public static void makePayment(HashMap<String, ArrayList<Transactions>> ledger) {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter the customer name: ");
      String customerName = scanner.nextLine();

      System.out.print("Enter the payment amount: ");
      double amount = scanner.nextDouble();
      scanner.nextLine();

      System.out.print("Enter a description: ");
      String description = scanner.nextLine();

      Transactions payment = new Transactions("Payment", amount, description);
      ledger.computeIfAbsent(customerName, k -> new ArrayList<>()).add(payment);
      System.out.println("Payment made successfully!");
   }

   public static void printTransactions(HashMap<String, ArrayList<Transactions>> ledger) {
      for (String customer : ledger.keySet()) {
         System.out.println("Transactions for " + customer + ":");
         for (Transactions transaction : ledger.get(customer)) {
            System.out.println(transaction.type + ": $" + transaction.amount + " - " + transaction.description);
         }
      }
   }

   public static void printTransactionsOfType(HashMap<String, ArrayList<Transactions>> ledger, String type) {
      for (String customer : ledger.keySet()) {
         System.out.println(type + "s for " + customer + ":");
         for (Transactions transaction : ledger.get(customer)) {
            if (transaction.type.equals(type)) {
               System.out.println("$" + transaction.amount + " - " + transaction.description);
            }
         }
      }
   }
}