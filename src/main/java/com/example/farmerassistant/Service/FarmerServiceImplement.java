package com.example.farmerassistant.Service;

import com.example.farmerassistant.Entity.Farmer;
import com.example.farmerassistant.Exception.UserNotFoundException;
import com.example.farmerassistant.Repository.FarmerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class FarmerServiceImplement implements FarmerService {
    @Autowired
    private FarmerRepository farmerRepository;
    private Farmer farmer;
    @Override
    public Farmer validateCustomer(Integer customerId, String username, String password, String customerName, String customerEmail) {
        Farmer farmer =new Farmer();
        farmer.setCustomerId(customerId);
        farmer.setUsername(username);
        farmer.setPassword(password);
        farmer.setCustomerName(customerName);
        farmer.setCustomerEmail(customerEmail);
        try {
            if (farmerRepository.exists(Example.of(farmer)))
                return farmer;
            else
                throw new UserNotFoundException("User not found");
        } catch (UserNotFoundException e) {
            log.info(e.getMessage());
            return null;
        }
    }

    @Override
    public Farmer addCustomer(Farmer farmer) {
        farmerRepository.save(farmer);
        return farmer;
    }

    @Override
    public Farmer removeCustomer(Integer customerId) {
        Optional<Farmer> userTemp = farmerRepository.findById(customerId);
        if (userTemp.isPresent()) {
            farmerRepository.deleteById(customerId);
            return farmer;
        } else
            return null;
    }
    @Override
    public List<Farmer> viewAllCustomers() {
        return farmerRepository.findAll();
    }

    @Override
    public Farmer viewCustomer(Integer customerId) {
        return farmerRepository.findById(customerId).get();
    }



}