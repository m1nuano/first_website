package com.demo.m1nuano.website.repository;

import com.demo.m1nuano.website.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

}
