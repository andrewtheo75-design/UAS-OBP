package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // 🟢 Ambil semua user
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    // 🟢 Tambah user
    public void save(User user) {
        userRepository.save(user);
    }

    // 🟢 Update user
    public void update(User user) {
        userRepository.save(user);
    }

    // 🟢 Hapus user berdasarkan ID
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
