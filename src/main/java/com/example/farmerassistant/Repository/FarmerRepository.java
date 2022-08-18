package com.example.farmerassistant.Repository;

import com.example.farmerassistant.Entity.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface FarmerRepository extends JpaRepository<Farmer,Integer> {
    Optional<Farmer> findByUsername(String userName);
}
