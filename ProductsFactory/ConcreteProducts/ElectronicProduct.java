package ProductsFactory.ConcreteProducts;

import CommonEnum.ProductCategory;
import ProductsFactory.Product;

public class ElectronicProduct extends Product {
    private String brand;
    private String WarrentyPeriod;

    public ElectronicProduct(String sku,double price,String name,int quantity) {
        super();
        setName(name);
        setPrice(price);
        setSku(sku);
        setQuantity(quantity);
        setProductcategory(ProductCategory.ELECTRONICS);


    }
    public String getBrand(){
        return brand;
    }
    public void setBrand(String brand){
        this.brand=brand;
    }
    public String getWarrentyPeriod(){
        return WarrentyPeriod;

    }
    public void setWarrentyPeriod(String WarrentyPeriod){
        this.WarrentyPeriod=WarrentyPeriod;
    }
}
