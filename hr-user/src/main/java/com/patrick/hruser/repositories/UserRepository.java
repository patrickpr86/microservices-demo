package com.patrick.hruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patrick.hruser.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
