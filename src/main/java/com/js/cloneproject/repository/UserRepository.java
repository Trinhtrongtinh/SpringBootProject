package com.js.cloneproject.repository;

import com.js.cloneproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    boolean existsByUsername(String username);//Java sẽ tự động nhận diện Username column sau existsByUsername và query theo tham số truyền vào
    Optional<User> findByUsername(String username);
}
