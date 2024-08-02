package com.example.identity.client.service;

import com.example.identity.client.exception.EntityDataSaveException;
import com.example.identity.persistence.entity.UserEntity;
import com.example.identity.persistence.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author Max.Jimenez
 */
@Service
public class UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public UserEntity save(UserEntity instance) {
        try {
            return repository.save(instance);
        } catch (EntityDataSaveException e) {
            LOG.error("Error in create", e);
            throw new EntityDataSaveException(instance);
        }
    }

    public UserEntity findByEmail(String email) {
        return repository.findUserEntityByEmail(email);
    }
}
