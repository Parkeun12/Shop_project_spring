package com.example.testproject.Service;

import com.example.testproject.entity.Users;
import com.example.testproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Users create(String userId, String pw) {
        Users user = new Users();
        user.setUserId(userId);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPw(passwordEncoder.encode(pw));
        this.userRepository.save(user);
        return user;
    }
}