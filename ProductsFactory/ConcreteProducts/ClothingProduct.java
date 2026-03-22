package ProductsFactory.ConcreteProducts;

import CommonEnum.ProductCategory;
import ProductsFactory.Product;

public class ClothingProduct extends Product {
    private String size;
    private String color;

    public ClothingProduct(String sku,double price,String name,int quantity) {
        super();
        setName(name);
        setPrice(price);
        setSku(sku);
        setQuantity(quantity);
        setProductcategory(ProductCategory.CLOTHING);


    }
    public String getSize(){
        return size;
    }
    public void setSize(String size){
        this.size=size;
    }
    public String getColor(){
        return color;

    }
    public void setColor(String color){
        this.color=color;
    }

}
