package com.example.farmerassistant.Service;

import com.example.farmerassistant.Entity.Farmer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FarmerService {
    public Farmer validateCustomer(Integer customerId, String username, String password, String customerName, String customerEmail);
    public Farmer addCustomer(Farmer farmer);
    public Farmer removeCustomer(Integer customerId);
    List<Farmer> viewAllCustomers();
    Farmer viewCustomer(Integer customerId);
}
