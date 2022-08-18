package com.example.farmerassistant.Service;

import com.example.farmerassistant.Entity.Supplier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SupplierService {

    public Supplier validateUser(String username, String password);
    public Supplier addUser(Supplier supplier);
    public Supplier removeUser(Supplier supplier);

    public List<Supplier> getAllUser();
}
