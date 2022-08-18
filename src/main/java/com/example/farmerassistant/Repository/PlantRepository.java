package com.example.farmerassistant.Repository;

import com.example.farmerassistant.Entity.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlantRepository extends JpaRepository<Plant,Long> {
    List<Plant> findByTypeOfPlant(String typeOfPlant);
    Optional<Plant> findByCommonName(String commonName);
    Optional<Plant> findById(Long plantId);
}
