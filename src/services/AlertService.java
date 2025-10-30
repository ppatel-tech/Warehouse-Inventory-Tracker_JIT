package services;

import models.Product;

public interface AlertService {
    void sendRestockAlert(Product product);
}