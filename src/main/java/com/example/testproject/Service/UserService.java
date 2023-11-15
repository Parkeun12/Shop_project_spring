////package com.example.testproject.Service;
////
////import com.example.testproject.entity.User;
////import com.example.testproject.repository.UserRepository;
////import lombok.RequiredArgsConstructor;
////import org.springframework.stereotype.Service;
////import org.springframework.transaction.annotation.Transactional;
////
////@Service
////@Transactional
////@RequiredArgsConstructor
////public class UserService  {
////
////    private final UserRepository userRepository;
////
////    public User saveUser(User user) {
////        validateDuplicateUser(user);
////        return userRepository.save(user);
////    }
////
////    //이미 가입된 회원일 경우 예외처리
////    private void validateDuplicateUser(User user) {
////        User findUser = userRepository.findByUsers_id(user.getUsers_id());
////
////        if(findUser != null) {
////
////            throw new IllegalStateException("이미 가입된 회원입니다.");
////        }
////    }
////
////}
//
//package com.example.testproject.Service;
//
//import com.example.testproject.entity.User;
//import com.example.testproject.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//@Transactional
//@RequiredArgsConstructor
////public class UserService  {
//////
////    private final UserRepository userRepository;
////
////    public User saveUser(User user) {
////        validateDuplicateUser(user);
////        return userRepository.save(user);
////    }
////
//////    이미 가입된 회원일 경우 예외처리
////    private void validateDuplicateUser(User user) {
////
////        User findUser = userRepository.findByUserId(user.getUserId());
////
//////        User findUser = userRepository.findByUsers_id(user.getUsers_id());
////
////        if(findUser != null) {
////
////            throw new IllegalStateException("이미 가입된 회원입니다.");
////        }
////    }
////
////}