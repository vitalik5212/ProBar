package com.lessons.home.springsecurity.repositories;

import com.lessons.home.springsecurity.entity.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {

    @Override
    List<Role> findAll();

    @Query("select r FROM Role r WHERE r.name = :name")
    Role getRoleByName(@Param("name") String name);
}
