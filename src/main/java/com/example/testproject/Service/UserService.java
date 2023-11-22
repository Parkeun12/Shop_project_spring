package com.example.testproject.Service;

import com.example.testproject.entity.Users;
import com.example.testproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

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
//    @Override
//    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException{
//        Optional<Users> user = userRepository.findByUserId(userId);
//
//        if (user == null){
//            throw new UsernameNotFoundException(userId);
//        }
//        return Users.builder()
//                .username(user.getUserId())
//                .password(user.getPw())
//                .roles(user.getRole().toString())
//                .build();
//    }

//    @Transactional
//    public Users join(Users user) {
//        userRepository.findByUserId(user.getUserId())
//                .ifPresent( user1 -> {
//                    throw new HospitalReviewAppException(ErrorCode.DUPLICATED_USER_NAME, String.format("UserId : %s",user1.getUserId()));
//                });
//        userRepository.save(user);
//
//        return user;
//    }
//    public Users create(String userId, String pw) {
//        Users user = new Users();
//        user.setUserId(userId);
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        user.setPw(passwordEncoder.encode(pw));
//        this.userRepository.save(user);
//        return user;
//    }



}