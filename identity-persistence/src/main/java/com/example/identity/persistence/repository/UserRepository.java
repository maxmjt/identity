package com.example.identity.persistence.repository;

import com.example.identity.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author Max.Jimenez
 */
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    UserEntity findUserEntityByEmail(String email);
}
