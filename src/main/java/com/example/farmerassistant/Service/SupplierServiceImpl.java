package com.example.farmerassistant.Service;

import com.example.farmerassistant.Entity.Supplier;
import com.example.farmerassistant.Exception.UserNotFoundException;
import com.example.farmerassistant.Repository.SupplierRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;
    private Supplier supplier;

    @Override
    public Supplier validateUser(String username, String password) {
        Supplier supplier = new Supplier();
        supplier.setUsername(username);
        supplier.setPassword(password);
        try {
            if (supplierRepository.exists(Example.of(supplier))){
                return supplier;
            }
            else
                throw new UserNotFoundException("User not found");
        } catch (UserNotFoundException e) {
            log.info(e.getMessage());
            return null;
        }
    }

    @Override
    public Supplier addUser(Supplier supplier) {
        supplierRepository.save(supplier);
        return supplier;
    }
    public String listUsers(){
        return String.valueOf(supplierRepository.findAll());
    }

    @Override
    public Supplier removeUser(Supplier supplier) {
        Optional<Supplier> userTemp = supplierRepository.findById(supplier.getId());
        if (userTemp.isPresent()) {
            supplierRepository.deleteById(supplier.getId());
            return supplier;
        } else
            return null;
    }

    @Override
    public List<Supplier> getAllUser() {
        return supplierRepository.findAll();
    }
}
