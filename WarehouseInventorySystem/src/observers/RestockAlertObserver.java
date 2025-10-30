package observers;

import models.Product;
import services.AlertService;

public class RestockAlertObserver implements AlertService {
    
    @Override
    public void sendRestockAlert(Product product) {
        System.out.println("ALERT: Low stock for " + product.getName() + 
                         " - only " + product.getQuantity() + " left!");
        System.out.println("   Please reorder immediately!");
        System.out.println("----------------------------------------");
    }
    
    public void sendCriticalAlert(Product product) {
        System.out.println(" CRITICAL: " + product.getName() + 
                         " is OUT OF STOCK! Emergency order needed!");
    }
}