package services;

import models.Product;
import observers.RestockAlertObserver;
import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private Map<String, Product> products;
    private AlertService alertService;
    
    public Warehouse() {
        this.products = new HashMap<>();
        this.alertService = new RestockAlertObserver();
    }
    
    public void addProduct(String productId, String name, int initialQuantity, int reorderThreshold) {
        if (products.containsKey(productId)) {
            System.out.println(" Product with ID " + productId + " already exists!");
            return;
        }
        
        Product newProduct = new Product(productId, name, initialQuantity, reorderThreshold);
        products.put(productId, newProduct);
        System.out.println(" Product added: " + newProduct);
    }
    
    public void receiveShipment(String productId, int quantity) {
        Product product = products.get(productId);
        if (product == null) {
            System.out.println(" Product not found with ID: " + productId);
            return;
        }
        
        if (quantity <= 0) {
            System.out.println(" Invalid shipment quantity!");
            return;
        }
        
        int newQuantity = product.getQuantity() + quantity;
        product.setQuantity(newQuantity);
        System.out.println(" Shipment received: " + quantity + " units of " + product.getName());
        System.out.println("   Updated stock: " + newQuantity + " units");
    }
    
    public void fulfillOrder(String productId, int quantity) {
        Product product = products.get(productId);
        if (product == null) {
            System.out.println(" Product not found with ID: " + productId);
            return;
        }
        
        if (quantity <= 0) {
            System.out.println(" Invalid order quantity!");
            return;
        }
        
        if (product.getQuantity() < quantity) {
            System.out.println("Insufficient stock! Available: " + product.getQuantity() + 
                             ", Requested: " + quantity);
            return;
        }
        
        int newQuantity = product.getQuantity() - quantity;
        product.setQuantity(newQuantity);
        System.out.println(" Order fulfilled: " + quantity + " units of " + product.getName());
        System.out.println("   Remaining stock: " + newQuantity + " units");
        
        if (newQuantity < product.getReorderThreshold()) {
            alertService.sendRestockAlert(product);
        }
    }
    
    public void displayAllProducts() {
        System.out.println("\n CURRENT INVENTORY:");
        System.out.println("========================================");
        if (products.isEmpty()) {
            System.out.println("No products in warehouse.");
        } else {
            for (Product product : products.values()) {
                System.out.println(product);
            }
        }
        System.out.println("========================================\n");
    }
    
    public Product getProduct(String productId) {
        return products.get(productId);
    }
    
    public int getTotalProducts() {
        return products.size();
    }
}