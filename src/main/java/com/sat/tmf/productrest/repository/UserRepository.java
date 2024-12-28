package com.sat.tmf.productrest.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sat.tmf.productrest.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}

