import java.text.NumberFormat;
import java.util.Map;
import java.util.Scanner;

public class CashRegister {
    private Products products = new Products();

    public float scanProducts() {
        boolean keepScan = true;
        String currentProduct = "";
        float currentPrice = 0;
        float currentQuantity = 0;

        while (keepScan) {
            Scanner sc = new Scanner(System.in);
            Scanner scNumber = new Scanner(System.in);

            System.out.println("product name:");
            currentProduct = sc.nextLine();

            System.out.println("product price:");
            currentPrice = scNumber.nextFloat();

            System.out.println("Quantity:");
            currentQuantity = scNumber.nextFloat();

            products.addProduct(new Product(currentProduct, currentPrice), currentQuantity);

            System.out.println("Are you done? (y/n)");

            if (sc.nextLine().charAt(0) == 'y')
                keepScan = false;
        }
        System.out.println("Summary price is " + countSummaryPrice());
        return countSummaryPrice();
    }

    private float countSummaryPrice() {
        float summaryPrice = 0;

        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMinimumFractionDigits(2);
        formatter.setMaximumFractionDigits(2);

        for (Map.Entry<Product, Float> entry : products.getProducts().entrySet()) {
            summaryPrice += entry.getKey().getPrice() * entry.getValue();
        }

        return Float.valueOf(formatter.format(summaryPrice));
    }

    public Products getProducts() {
        return products;
    }
}
