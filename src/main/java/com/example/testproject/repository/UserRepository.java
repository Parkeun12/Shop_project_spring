//package com.example.testproject.repository;
//
//import com.example.testproject.entity.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface UserRepository extends JpaRepository<User, Long> {
//    //회원가입시 중복된 회원이 있는지 검사하기 위해서 아이디로 회원을 검사할 수 있도록 쿼리 메서드를 작성
//    User findByUsers_id(Long users_id);
//}

package com.example.testproject.repository;

import com.example.testproject.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    //회원가입시 중복된 회원이 있는지 검사하기 위해서 아이디로 회원을 검사할 수 있도록 쿼리 메서드를 작성

//    User findByUserId(String userId);
//    User findByUsers_id(Long users_id);
}