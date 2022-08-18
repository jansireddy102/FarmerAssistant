package com.example.farmerassistant.Repository;

import com.example.farmerassistant.Entity.Seed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SeedRepository extends JpaRepository<Seed,Long> {
    List<Seed> findByTypeOfSeed(String typeOfSeed);
    Optional<Seed> findByCommonName(String commonName);
    Optional<Seed> findById(Long seedId);
}
