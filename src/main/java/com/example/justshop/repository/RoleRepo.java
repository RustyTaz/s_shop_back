package com.example.justshop.repository;

import com.example.justshop.entity.Role;
import com.example.justshop.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo extends JpaRepository<RoleEntity,Long> {
    Optional<RoleRepo> findByName(Role name);
}
