package com.js.cloneproject.repository;
import com.js.cloneproject.entity.Permission;
import com.js.cloneproject.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
    boolean existsByName(String name);
}
