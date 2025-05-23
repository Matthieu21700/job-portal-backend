package com.dauphine.job_portal_backend.service.impl;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.dauphine.job_portal_backend.model.User;
import com.dauphine.job_portal_backend.repository.UserRepository;
import com.dauphine.job_portal_backend.service.UserService;



@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(UUID id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User createUser(User user) {
    	User userToSave = new User(
    		    user.getFirstName(),
    		    user.getLastName(),
    		    user.getEmail(),
    		    user.getPhone(),
    		    user.getRole()
    		);

    		return userRepository.save(userToSave);
    }

    @Override
    public User updateUser(UUID id, User updatedUser) {
        return userRepository.findById(id)
            .map(user -> {
                user.setFirstName(updatedUser.getFirstName());
                user.setLastName(updatedUser.getLastName());
                user.setEmail(updatedUser.getEmail());
                user.setPhone(updatedUser.getPhone());
                return userRepository.save(user);
            }).orElse(null);
    }

    @Override
    public boolean deleteUser(UUID id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    @Override
    public boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }
    @Override
    public Optional<UUID> getIdByEmail(String mail) {
    	return userRepository.findIdByEmail(mail);
    }
}
