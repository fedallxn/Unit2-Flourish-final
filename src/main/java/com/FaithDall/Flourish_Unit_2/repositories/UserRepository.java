package com.FaithDall.Flourish_Unit_2.repositories;

import com.FaithDall.Flourish_Unit_2.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
