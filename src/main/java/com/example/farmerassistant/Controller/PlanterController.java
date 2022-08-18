package com.example.farmerassistant.Controller;

import com.example.farmerassistant.Entity.Plant;
import com.example.farmerassistant.Entity.Planter;
import com.example.farmerassistant.Service.PlanterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planter")
@CrossOrigin("http://localhost:3000")
public class PlanterController {

    @Autowired
    PlanterService planterService;

    @PostMapping(path = "/add")
    public ResponseEntity<Planter> addPlanter(@RequestBody Planter planter){
        return new ResponseEntity<>(planterService.addPlanter(planter), HttpStatus.CREATED);
    }

    @GetMapping("/viewall")
    public List<Planter> getAllPlanter(){
        return planterService.getAllPlanter();
    }

    @GetMapping("/viewPlanter")
    public ResponseEntity<Planter> getPlanterDetails(@RequestParam(value="id") long id){
        return ResponseEntity.ok().body(planterService.getPlanter(id));
    }

    @DeleteMapping("/delete")
    public void deletePlanter(@RequestParam Long id){
        planterService.removePlanter(id);
    }

    @PutMapping(path = "/update")
    public void modifyplanter(@RequestParam(value = "id") Long id1, @RequestBody Planter planter){
        planterService.updatePlanter(id1 ,planter);
    }

    @PostMapping("/addPlant")
    public ResponseEntity<Plant> addPlant(@RequestParam Long planterId, @RequestParam Long plantId)
    {
        return ResponseEntity.ok(this.planterService.addPlant(planterId,plantId));
    }

}