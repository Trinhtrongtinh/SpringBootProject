package com.js.cloneproject.repository;
import com.js.cloneproject.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, String> {
    boolean existsByName(String name);
}
