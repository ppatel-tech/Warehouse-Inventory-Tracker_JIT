// src/Main.java
import models.Product;
import services.Warehouse;

public class Main {
    public static void main(String[] args) {
        System.out.println("Warehouse Inventory System Starting...\n");
        
        Warehouse warehouse = new Warehouse();
        
        demoWarehouseOperations(warehouse);
    }
    
    public static void demoWarehouseOperations(Warehouse warehouse) {
        System.out.println(" STEP 1: Adding Products");
        System.out.println("============================");
        warehouse.addProduct("P001", "Laptop", 10, 5);
        warehouse.addProduct("P002", "Mouse", 20, 8);
        warehouse.addProduct("P003", "Keyboard", 15, 6);
        
        warehouse.displayAllProducts();
        
        System.out.println("STEP 2: Receiving Shipments");
        System.out.println("===============================");
        warehouse.receiveShipment("P001", 5);  
        warehouse.receiveShipment("P002", 10);
        
        warehouse.displayAllProducts();
        
        System.out.println("STEP 3: Fulfilling Orders (Normal)");
        System.out.println("======================================");
        warehouse.fulfillOrder("P001", 3); 
        warehouse.fulfillOrder("P002", 5);  
        
        warehouse.displayAllProducts();
        
        System.out.println("STEP 4: Fulfilling Orders (Alert Trigger)");
        System.out.println("============================================");
        warehouse.fulfillOrder("P001", 10); 
        warehouse.fulfillOrder("P003", 12); 
        
        warehouse.displayAllProducts();
        
        System.out.println(" STEP 5: Error Handling Tests");
        System.out.println("================================");
        warehouse.fulfillOrder("P001", 50); 
        warehouse.fulfillOrder("P999", 5);  
        warehouse.receiveShipment("P999", 5); 
        warehouse.addProduct("P001", "Tablet", 10, 3); 
        warehouse.displayAllProducts();
        
        System.out.println("Demo Completed Successfully!");
        System.out.println("Total Products in Warehouse: " + warehouse.getTotalProducts());
    }
}