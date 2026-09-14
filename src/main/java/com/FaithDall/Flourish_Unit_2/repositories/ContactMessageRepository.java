package com.FaithDall.Flourish_Unit_2.repositories;

import com.FaithDall.Flourish_Unit_2.models.ContactMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactMessageRepository extends JpaRepository<ContactMessage, Integer> {
}
