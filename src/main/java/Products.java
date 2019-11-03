import java.util.HashMap;
import java.util.Map;

public class Products {
    private Map <Product,Float> products = new HashMap<Product, Float>();

    public void addProduct(Product product, float price) {
        this.products.put(product, Float.valueOf(price));
    }

    public Map<Product, Float> getProducts() {
        return products;
    }
}
