package ProductReplenishmentStrategies.ConcreateReplenishmentStrategies;

import ProductReplenishmentStrategies.ReplenishmentStrategy;
import ProductsFactory.Product;

public class JustInTimeStrategy implements ReplenishmentStrategy {


    @Override
    public void replenish(Product product) {
        System.out.println("Just In Time" + product.getName());
    }
}
