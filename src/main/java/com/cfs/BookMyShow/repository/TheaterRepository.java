package com.cfs.BookMyShow.repository;

import com.cfs.BookMyShow.entity.Theater;
import com.cfs.BookMyShow.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TheaterRepository extends JpaRepository<Theater,Long> {

    List<Theater> findByCityId(Long cityId);
}
