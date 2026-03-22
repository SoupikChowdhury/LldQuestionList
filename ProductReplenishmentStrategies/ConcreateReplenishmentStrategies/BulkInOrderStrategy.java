package ProductReplenishmentStrategies.ConcreateReplenishmentStrategies;

import ProductReplenishmentStrategies.ReplenishmentStrategy;
import ProductsFactory.Product;

public class BulkInOrderStrategy implements ReplenishmentStrategy {
    public void replenish(Product product) {
        System.out.println("Bulk In Time" + product.getName());
    }
}
