package com.demo.m1nuano.website.service;

import com.demo.m1nuano.website.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.m1nuano.website.model.*;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private OrderRepo orderRepo;

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setOrderRepo(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public Order createOrderFromItems(User user, List<OrderItem> orderItems) {
        Order order = new Order();
        order.setOrderItems(new ArrayList<>());
        order.setUser(user);
        orderItems.stream().forEach(orderItem -> {
            order.getOrderItems().add(orderItem);
            orderItem.setOrder(order);
        });
        orderItems.clear();
        return orderRepo.save(order);
    }

    public Order getOrderById(Long id) {
        return orderRepo.getOne(id);
    }

    public List<Order> getOrderByUser(User user) {
        return orderRepo.findAllByUser(user);
    }

    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    public void deleteOrderById(Long id) {
        orderRepo.deleteById(id);
    }

    public List<Order> getCustomOrders(Principal principal) {
        User user = userService.findByUsername(principal.getName());

        List<Authority> authorities = user.getAuthorities();
        for (Authority authority : authorities) {
            if (authority.getAuthority().equals("ROLE_SELLER")) {
                return getAllOrders();
            }
        }
        return getOrderByUser(user);
    }


}
