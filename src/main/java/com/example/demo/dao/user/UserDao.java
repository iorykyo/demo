package com.example.demo.dao.user;

import com.example.demo.entitys.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, String> {
}
