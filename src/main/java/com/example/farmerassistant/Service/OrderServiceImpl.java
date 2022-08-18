package com.example.farmerassistant.Service;

import java.util.List;
import com.example.farmerassistant.Entity.Order;
import com.example.farmerassistant.Repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderRepository orderRepository;
    @Override
    public Order addOrder(Order order){
        return  orderRepository.save(order);
    }

    @Override
    public List<Order> viewAllOrders(){
        return orderRepository.findAll();
    }

    @Override
    public Order viewOrder(Integer bookingOrderId) {
        Optional<Order> OrderService =orderRepository.findById(bookingOrderId);
        if(OrderService.isPresent()) return OrderService.get();
        else throw new IllegalStateException("Planter doesnt exists!!!");
    }

    public void deleteOrder(Integer bookingOrderId){
        orderRepository.deleteById(bookingOrderId);
    }

    @Transactional
    public Order updateOrder(Integer id, Order order){
        Optional<Order> order1 =orderRepository.findById(id);
        if(order1.isPresent()){
            order1.get().setOrderDate(order.getOrderDate());
            order1.get().setTransactionMode(order.getTransactionMode());
            order1.get().setQuantity(order.getQuantity());
            order1.get().setTotalCost(order.getTotalCost());
//            order1.get().setPlanters(order.getPlanters());
        }
        else throw new IllegalStateException("Order: "+id+ " doesnt exists!");
        return order;
    }

}