package com.example.demo.dao;

import com.example.demo.entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, String> {
}
