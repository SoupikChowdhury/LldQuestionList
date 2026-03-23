import ProductsFactory.Product;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private int id;
    private String name;
    private String location;
    private Map<String, Product> products; // SKU -> Product

    public Warehouse(String name){
        this.name=name;
        this.products=new HashMap<>();
    }
    
    public void addProduct(Product product, int quantity){
        if(product==null||quantity<=0){
            System.out.println("Invalid product or quantity.");
            return;
        }
        String sku=product.getSku();
        Product existingProduct=products.get(sku);

        if(existingProduct!=null){
            existingProduct.setQuantity(existingProduct.getQuantity()+quantity);
            System.out.println("Product updated: " + existingProduct.getName() + " | New Quantity: " + existingProduct.getQuantity());
        }
        else{
            product.setQuantity(quantity);
            products.put(sku, product);
            System.out.println("Product added: " + product.getName() + " | Quantity: " + quantity);
        }
    }
    public boolean removeProduct(String sku, int quantity) {

        if (quantity <= 0) {
            System.out.println("Invalid quantity");
            return false;
        }

        Product product = products.get(sku);

        if (product == null) {
            System.out.println("Product not found: " + sku);
            return false;
        }

        if (product.getQuantity() < quantity) {
            System.out.println("Insufficient stock for " + product.getName());
            return false;
        }

        int remaining = product.getQuantity() - quantity;
        product.setQuantity(remaining);
        System.out.println("Removed " + quantity + " units of " + product.getName() + " | Remaining: " + remaining);

        if (remaining == 0) {
            products.remove(sku);
            System.out.println("Product " + product.getName() + " removed from inventory (0 stock)");
        }

        return true;
    }

    public int getAvailableQuantity(String sku) {
        Product product = products.get(sku);
        return product != null ? product.getQuantity() : 0;
    }

    public Product getProductBySku(String sku) {
        return products.get(sku);
    }

    public Collection<Product> getAllProducts() {
        return products.values();
    }
    
    public String getName() {
        return name;
    }

    public void displayInventory() {
        System.out.println("\n========== Warehouse: " + name + " ==========");
        if (products.isEmpty()) {
            System.out.println("No products in inventory.");
        } else {
            System.out.println("SKU\t\tName\t\t\tCategory\t\tPrice\t\tQuantity");
            System.out.println("-------------------------------------------------------------------------");
            for (Product product : products.values()) {
                System.out.printf("%s\t\t%s\t\t%s\t\t$%.2f\t\t%d%n",
                        product.getSku(),
                        product.getName(),
                        product.getProductcategory(),
                        product.getPrice(),
                        product.getQuantity());
            }
        }
        System.out.println("========================================\n");
    }
}
