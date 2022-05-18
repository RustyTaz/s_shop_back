package com.example.justshop.repository;

import com.example.justshop.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo  extends CrudRepository<UserEntity,Long> {
    UserEntity findByName(String name);
}
