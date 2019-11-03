import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

public class Transaction {
    private Scanner sc = new Scanner(System.in);
    private Scanner scString = new Scanner(System.in);

    public Transaction() { }

    public void runTransaction() {
        boolean run = true;
        while (run) {
            float summaryPrice;
            float payment;
            List<Float> changeValues;
            List<Float> denominations = new ArrayList<>();

            System.out.println("Type (coma separated) denominations from: 200, 100, 50, 20, 10, 5, 2, 1, 0.5, 0.2, 0.1, 0.05, 0.02, 0.01 " +
                    "(eg. 5,2,1,0.5,0.2,0.1)");

            for (String el : Arrays.asList(scString.nextLine().split(","))) {     //rozdziel nominały do listy
                denominations.add(Float.parseFloat(el));
            }

            System.out.println("Accept products: ");
            summaryPrice = new CashRegister().scanProducts();

            System.out.println("Type your payment:");
            payment = sc.nextFloat();

            changeValues = Checkout.countChange(denominations, summaryPrice, payment);
            System.out.println("Your change are " + changeValues);

            System.out.println("Continue? (y/n)");

            if (scString.nextLine().charAt(0) == 'n')
                run = false;
            else {
                summaryPrice = 0;
                payment = 0;
                changeValues = null;
                denominations = null;
            }
        }
        sc.close();
        scString.close();
        System.exit(1);
    }
}
