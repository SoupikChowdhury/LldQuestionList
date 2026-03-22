package ProductReplenishmentStrategies;

import ProductsFactory.Product;

public interface ReplenishmentStrategy {
    void replenish(Product product);
}
