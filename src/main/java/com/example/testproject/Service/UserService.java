package com.example.testproject.Service;

import com.example.testproject.entity.Users;
import com.example.testproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
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

    public Users saveUsers(Users user) {
        validateDuplicateMember(user);
        return userRepository.save(user);
    }
    //이미 가입된 회원의 경우 IllegalStateException 예외를 발생시킨다.
    private void validateDuplicateMember(Users user) {
        Optional<Users> findUsers = userRepository.findByUserId(user.getUserId());
        if (findUsers != null) {
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }
}