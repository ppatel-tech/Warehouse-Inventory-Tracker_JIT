package models;
//prodect class
public class Product {
    private String productId;
    private String name;
    private int quantity;
    private int reorderThreshold;
    
    public Product(String productId, String name, int quantity, int reorderThreshold) {
        this.productId = productId;
        this.name = name;
        this.quantity = quantity;
        this.reorderThreshold = reorderThreshold;
    }
    
    public String getProductId() { return productId; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public int getReorderThreshold() { return reorderThreshold; }
    
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setName(String name) { this.name = name; }
    
    @Override
    public String toString() {
        return "Product [ID=" + productId + ", Name=" + name + 
               ", Quantity=" + quantity + ", Threshold=" + reorderThreshold + "]";
    }
}