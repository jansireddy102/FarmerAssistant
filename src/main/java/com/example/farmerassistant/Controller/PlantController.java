package com.example.farmerassistant.Controller;
import com.example.farmerassistant.Entity.Plant;
import com.example.farmerassistant.Service.PlantServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/plant")
@CrossOrigin("http://localhost:3000")
public class PlantController {
    @Autowired
    private PlantServiceImpl plantServiceimpl;

    @PostMapping("/add")
    public ResponseEntity<Plant> addPlant(@RequestBody Plant plant){
        Plant plant1 =plantServiceimpl.addPlant(plant);
        log.info("Added a new Plant ");
        log.info(String.valueOf(plant1));
        return new ResponseEntity<>(plant1, HttpStatus.CREATED);
    }
    @GetMapping("/view")
    public ResponseEntity<Plant> viewPlant(@RequestParam Long plantId){
        Plant plant = plantServiceimpl.viewPlant(plantId);
        return new ResponseEntity<>(plant,HttpStatus.ACCEPTED);
    }
    @GetMapping("/viewall")
    public List<Plant> viewAllPlants(){
        return plantServiceimpl.viewAllPlants();
    }
    @PutMapping("/update")
    public void modifyplant(@RequestParam(value="id")Long id1, @RequestBody Plant plant) {
        plantServiceimpl.updatePlant(id1,plant);}
    @DeleteMapping("/delete/{plantId}")
    public void removePlant(@PathVariable Long plantId){
        plantServiceimpl.deletePlant(plantId);
    }
    @GetMapping("/viewByCommonName")
    public Optional<Plant> ViewByCommonName(@RequestParam String commonName){
        return plantServiceimpl.viewPlant(commonName);
    }
    @GetMapping("/viewByTypeOfPlant")
    public List<Plant> ViewByTypeOfPlant(@RequestParam String typeOfPlant){
        return plantServiceimpl.viewAllPlants(typeOfPlant);
    }
}
