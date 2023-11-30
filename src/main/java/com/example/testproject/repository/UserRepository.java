
package com.example.testproject.repository;

import com.example.testproject.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
//    유저이름을 찾는 기능 추가
    Optional<Users> findByUsername(String username);

}