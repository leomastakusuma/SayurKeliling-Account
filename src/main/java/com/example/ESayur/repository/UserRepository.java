package com.example.ESayur.repository;

import com.example.ESayur.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>,UserRepositoryCustom {

}

