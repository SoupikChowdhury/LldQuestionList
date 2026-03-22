package ProductsFactory;

import CommonEnum.ProductCategory;
import ProductsFactory.ConcreteProducts.ClothingProduct;
import ProductsFactory.ConcreteProducts.ElectronicProduct;


// Product Factory class implementing Factory Pattern
public class ProductFactory {
    public Product createProduct(ProductCategory category, String sku, String name, double price, int quantity) {
        switch (category) {
            case ELECTRONICS:
                return new ElectronicProduct(sku, price,name,  quantity);
            case CLOTHING:
                return new ClothingProduct(sku, price,name,  quantity);
            default:
                throw new IllegalArgumentException(
                        "Unsupported product category: " + category);
        }
    }
}