package com.example.farmerassistant.Service;

import com.example.farmerassistant.Entity.Plant;
import com.example.farmerassistant.Entity.Planter;
import com.example.farmerassistant.Repository.PlantRepository;
import com.example.farmerassistant.Repository.PlanterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PlanterService {

    @Autowired
    PlanterRepository planterRepository;
    @Autowired
    PlantRepository plantRepository;

    public Planter addPlanter(Planter planter) {
        return planterRepository.save(planter);
    }

    public List<Planter> getAllPlanter() {
        return planterRepository.findAll();
    }

    public Planter getPlanter(long id) {
        Optional<Planter> planterService = planterRepository.findById(id);
        if (planterService.isPresent()) return planterService.get();
        else throw new IllegalStateException("Planter doesnt exists!!!");
    }

    public void removePlanter(Long id) {
        planterRepository.deleteById(id);
    }

    @Transactional
    public void updatePlanter(Long id, Planter planter) {
        Optional<Planter> planter1 = planterRepository.findById(id);
        if (planter1.isPresent()) {
            planter1.get().setPlanterHeight(planter.getPlanterHeight());
            planter1.get().setPlanterCapacity(planter.getPlanterCapacity());
            planter1.get().setDrainageHoles(planter.getDrainageHoles());
            planter1.get().setPlanterColor(planter.getPlanterColor());
            planter1.get().setPlanterShaper(planter.getPlanterShaper());
            planter1.get().setPlanterStock(planter.getPlanterStock());
            planter1.get().setPlanterCost(planter.getPlanterCost());
            planter1.get().setPlants(planter.getPlants());
        } else throw new IllegalStateException("Planter: " + id + " doesnt exists!");
    }

    public Plant addPlant(Long planterId, Long plantId) {
        Plant t = plantRepository.findById(plantId).get();
        Planter c = planterRepository.findById(planterId).get();
        Planter c1 = planterRepository.findById(planterId).get();
        List<Plant> newTests = c.getPlants();
        newTests.add(t);
        c.setPlants(newTests);

        plantRepository.saveAndFlush(t);
        planterRepository.saveAndFlush(c);
        return t;

    }
}
