package com.cfs.BookMyShow.repository;

import com.cfs.BookMyShow.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    /*
    - Optional<User> is a container object that may or may not hold a User instance.
    - Avoids NullPointerException: You don’t have to deal with raw null values.
    -  Optional has methods like .isPresent(), .orElse(), .orElseThrow(), .map()

     */
    Optional<User>findByEmail(String email);
    boolean existsByEmail(String email);
}

