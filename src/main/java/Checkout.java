import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Checkout {

    public static List <Float> countChange(List <Float> denominations, float summaryPrice, float payment) {
        float change = payment - summaryPrice;
        List<Float> resultValues = new ArrayList<>();

        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMinimumFractionDigits(2);
        formatter.setMaximumFractionDigits(2);

        while (change > 0) {                                        // dopóki kwota do oddania większa od zera
            float n = 0;                                            // n – maksymalny nominał mniejszy lub równy kwocie
            for (Float value : denominations) {                     // wśród wszystkich nominałów...
                if ((value <= change) && (value > n)) {             // ...znajdź n
                    n = value.floatValue();
                }
            }
            if (n != 0) {
                resultValues.add(n);                                //dodaj do reszty nominał n
                change -= n;                                        // pomniejsz kwotę o n
                change = Float.valueOf(formatter.format(change));   //popraw do 2 miejsc po przecinku
            } else {
                System.out.println("Mogę być winna " + change + "? :)");
                change = 0;
            }
        }
    return resultValues;
    }
}
