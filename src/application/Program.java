package application;

import model.entities.Account;
import model.exceptions.WithdrawErrorException;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);
        Account account = new Account();

        try {
            System.out.println("Enter account data");
            System.out.print("Number: ");
            int number = scan.nextInt();
            System.out.print("Holder: ");
            scan.nextLine();
            String holder = scan.nextLine();
            System.out.print("Initial balance: ");
            double balance = scan.nextDouble();
            System.out.print("Withdraw limit: ");
            double withdrawLimit = scan.nextDouble();

            account = new Account(number, holder, balance, withdrawLimit);

            System.out.println();
            System.out.print("Enter amount for withdraw: ");
            double amount = scan.nextDouble();
            account.withdraw(amount);
        }
        catch (WithdrawErrorException e){
            System.out.println("Withdraw error: "+e.getMessage());
        }
        catch (InputMismatchException e){
            System.out.println("Unexpected error!");
        }

        System.out.printf("Updated balance: %.2f%n",account.getBalance());

    }
}
