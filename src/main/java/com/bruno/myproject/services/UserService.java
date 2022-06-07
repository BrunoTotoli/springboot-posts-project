package com.bruno.myproject.services;

import com.bruno.myproject.entities.User;
import com.bruno.myproject.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {


    private UserRepository userRepository;

    public User insert(User user) {
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

}
