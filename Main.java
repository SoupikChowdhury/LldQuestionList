import CommonEnum.ProductCategory;
import ProductReplenishmentStrategies.ConcreteReplenishmentStrategies.BulkInOrderStrategy;
import ProductReplenishmentStrategies.ConcreteReplenishmentStrategies.JustInTimeStrategy;
import ProductReplenishmentStrategies.ReplenishmentStrategy;
import ProductsFactory.Product;
import ProductsFactory.ProductFactory;

public class Main {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("  Inventory Management System Demo");
        System.out.println("========================================\n");

        // Create Product Factory
        ProductFactory productFactory = new ProductFactory();

        // Create Warehouse
        Warehouse warehouse = new Warehouse("Main Warehouse");

        // Create Products using Factory Pattern
        System.out.println("--- Creating Products ---");
        Product laptop = productFactory.createProduct(
                ProductCategory.ELECTRONICS,
                "ELEC-001",
                "Dell Laptop",
                999.99,
                0
        );

        Product phone = productFactory.createProduct(
                ProductCategory.ELECTRONICS,
                "ELEC-002",
                "iPhone 15",
                1299.99,
                0
        );

        Product tshirt = productFactory.createProduct(
                ProductCategory.CLOTHING,
                "CLOTH-001",
                "Cotton T-Shirt",
                29.99,
                0
        );

        Product jeans = productFactory.createProduct(
                ProductCategory.CLOTHING,
                "CLOTH-002",
                "Blue Jeans",
                59.99,
                0
        );

        // Add Products to Warehouse
        System.out.println("\n--- Adding Products to Warehouse ---");
        warehouse.addProduct(laptop, 50);
        warehouse.addProduct(phone, 100);
        warehouse.addProduct(tshirt, 200);
        warehouse.addProduct(jeans, 150);

        // Display Inventory
        warehouse.displayInventory();

        // Test adding more quantity to existing product
        System.out.println("--- Adding More Stock ---");
        warehouse.addProduct(laptop, 25);

        // Display Inventory
        warehouse.displayInventory();

        // Test removing products
        System.out.println("--- Removing Products ---");
        warehouse.removeProduct("ELEC-001", 30);
        warehouse.removeProduct("CLOTH-001", 50);

        // Display Inventory
        warehouse.displayInventory();

        // Test checking available quantity
        System.out.println("--- Checking Available Quantity ---");
        System.out.println("Available laptops: " + warehouse.getAvailableQuantity("ELEC-001"));
        System.out.println("Available phones: " + warehouse.getAvailableQuantity("ELEC-002"));

        // Test Replenishment Strategies (Strategy Pattern)
        System.out.println("\n--- Testing Replenishment Strategies ---");
        ReplenishmentStrategy bulkStrategy = new BulkInOrderStrategy();
        ReplenishmentStrategy jitStrategy = new JustInTimeStrategy();

        Product lowStockProduct = warehouse.getProductBySku("ELEC-001");
        bulkStrategy.replenish(lowStockProduct);
        
        Product justInTimeProduct = warehouse.getProductBySku("CLOTH-002");
        jitStrategy.replenish(justInTimeProduct);

        // Test edge cases
        System.out.println("\n--- Testing Edge Cases ---");
        warehouse.removeProduct("INVALID-SKU", 10);  // Product not found
        warehouse.removeProduct("ELEC-002", 1000);   // Insufficient stock
        warehouse.addProduct(null, 10);              // Invalid product

        // Final Inventory
        warehouse.displayInventory();

        System.out.println("========================================");
        System.out.println("  Demo Completed Successfully!");
        System.out.println("========================================");
    }
}
