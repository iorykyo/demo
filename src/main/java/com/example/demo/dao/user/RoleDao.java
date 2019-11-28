package com.example.demo.dao.user;

import com.example.demo.entitys.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Integer> {
}
