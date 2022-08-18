package com.example.farmerassistant.Controller;

import com.example.farmerassistant.Entity.Supplier;
import com.example.farmerassistant.Repository.SupplierRepository;
import com.example.farmerassistant.Service.SupplierServiceImpl;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("User")
@CrossOrigin("http://localhost:3000")
public class SupplierController {

    @Autowired
    private SupplierServiceImpl userService;
    @Autowired
    SupplierRepository supplierRepository;

    @ApiOperation("Add a new  User")
    @PostMapping("/register")
    public ResponseEntity<Supplier> regsiterUser(@Valid @RequestBody Supplier supplier) {
        Supplier supplierNew = userService.addUser(supplier);
        log.info("Added a new User");
        return new ResponseEntity<>(supplierNew, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<List<Supplier>> loginUser(@Valid @RequestBody Supplier supplier) {
        List<Supplier> suppliers = supplierRepository.findAll();
        for (Supplier other : suppliers) {
            log.info(String.valueOf(other));
            String name=other.getUsername();
            String pass= other.getPassword();
            if (name.equals(supplier.getUsername()) && pass.equals(supplier.getPassword())) {
                ResponseEntity<List<Supplier>> listResponseEntity = new ResponseEntity<>(suppliers, HttpStatus.ACCEPTED);
                return listResponseEntity;
            }
        }
        return new ResponseEntity<>(suppliers, HttpStatus.FORBIDDEN);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Supplier>> getAllUser()
    {
        return ResponseEntity.ok(this.userService.getAllUser());

    }

    @DeleteMapping("/remove")
    public ResponseEntity<Supplier> removeUser(@RequestBody Supplier supplier) {
        Supplier supplierRemoved = userService.removeUser(supplier);
        if (supplierRemoved != null)
            return new ResponseEntity<>(supplier, HttpStatus.ACCEPTED);
        else
            return new ResponseEntity<>(supplier, HttpStatus.FORBIDDEN);
    }
}