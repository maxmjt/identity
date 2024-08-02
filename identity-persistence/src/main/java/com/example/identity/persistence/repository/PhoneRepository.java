package com.example.identity.persistence.repository;

import com.example.identity.persistence.entity.PhoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author Max.Jimenez
 */
public interface PhoneRepository extends JpaRepository<PhoneEntity, UUID> {
}
