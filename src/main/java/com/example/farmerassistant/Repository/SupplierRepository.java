package com.example.farmerassistant.Repository;

import com.example.farmerassistant.Entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Integer> {

    Supplier findByUsername(String userName);
}