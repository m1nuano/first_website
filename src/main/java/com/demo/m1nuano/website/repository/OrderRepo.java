package com.demo.m1nuano.website.repository;

import com.demo.m1nuano.website.model.Order;
import com.demo.m1nuano.website.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
    List<Order> findAllByUser(User user);
}
