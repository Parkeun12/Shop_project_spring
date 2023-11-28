package com.example.testproject.Service;

import com.example.testproject.entity.Users;
import com.example.testproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
<<<<<<< Updated upstream
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
=======
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
>>>>>>> Stashed changes
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder; //시큐리티 설정에 Bean BCryptPasswordEncoder 주입

<<<<<<< Updated upstream
    public Users create(String username,String password) {
        Users user = new Users();
        user.setUsername(username);
        //비밀번호 암호화
        user.setPassword(passwordEncoder.encode(password));
        //저장
        this.userRepository.save(user);
        return null;
=======
    private final UserRepository userRepository;

    public Users saveUsers(Users user) {
        validateDuplicateMember(user);
        return userRepository.save(user);
    }

//    이미 가입된 회원의 경우 IllegalStateException 예외를 발생시킨다.
    private void validateDuplicateMember(Users user) {
        Users findByUsers = userRepository.findByUserId(user.getUserId());
        if (findByUsers != null) {
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
>>>>>>> Stashed changes
    }

}