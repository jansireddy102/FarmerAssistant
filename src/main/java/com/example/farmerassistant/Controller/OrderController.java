package com.example.farmerassistant.Controller;

import java.util.List;
import com.example.farmerassistant.Entity.Order;
import com.example.farmerassistant.Service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("Order")
@CrossOrigin("http://localhost:3000")

public class OrderController {
//    @Qualifier("orderService")
    @Autowired
    private OrderService orderservice;
    @PostMapping("/addOrder")
    public ResponseEntity<Order> addOrder(@RequestBody Order order){
        Order order1 =orderservice.addOrder(order);
        log.info("Added a new order ");
        log.info(String.valueOf(order1));
        return new ResponseEntity<>(order1, HttpStatus.CREATED);
    }

    @PutMapping("/updateOrder")
    public Order updateOrder(@RequestParam(value = "id") Integer id1,@RequestBody Order order) {
        return orderservice.updateOrder(id1,order);
    }

    @PostMapping("/deletePlant")
    public void deleteOrder(@RequestParam Integer bookingOrderId){
        orderservice.deleteOrder(bookingOrderId);
    }

    @GetMapping("/viewOrder")
    public ResponseEntity<Order> viewOrder(@RequestParam Integer bookingOrderId){
        Order order2 = orderservice.viewOrder(bookingOrderId);
        return new ResponseEntity<>(order2, HttpStatus.ACCEPTED);
    }

    @GetMapping("/viewAllOrders")
    public List<Order> viewAllOrders(){
        return orderservice.viewAllOrders();
    }
}
