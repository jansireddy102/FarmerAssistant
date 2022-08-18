package com.example.farmerassistant.Repository;

import com.example.farmerassistant.Entity.Planter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlanterRepository extends JpaRepository<Planter,Long> {
    Optional<Planter> findById(Long planterId);
}
