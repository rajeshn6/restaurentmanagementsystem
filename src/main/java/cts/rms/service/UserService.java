package cts.rms.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cts.rms.dto.Users;
import cts.rms.repository.UsersRepository;

@Service
public class UserService {
	@Autowired
	PasswordEncoder passwordEncoder;

    @Autowired
    private UsersRepository userRepository;

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }
    public Users getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    public Optional<Users> getUserById(int id) {
        return userRepository.findById(id);
    }

    public Users createUser(Users user) {
    	System.out.println(user.getPassword());
    	user.setPassword(passwordEncoder.encode(user.getPassword()));
    	System.out.println(user.getPassword());
        return userRepository.save(user);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}