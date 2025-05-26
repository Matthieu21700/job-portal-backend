package com.dauphine.job_portal_backend.service;



import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.dauphine.job_portal_backend.model.User;


public interface UserService {
    List<User> getAllUsers();
    User getUserById(UUID id);
    User createUser(User user);
    User updateUser(UUID id, User user);
    boolean deleteUser(UUID id);
    User getUserByEmail(String email);
    boolean emailExists(String email);
    public UUID getUserIdByEmail(String mail) ;
}
