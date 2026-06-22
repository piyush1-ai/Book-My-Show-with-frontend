package com.cfs.BookMyShow.repository;

import com.cfs.BookMyShow.entity.Screen;
import com.cfs.BookMyShow.entity.Seat;
import com.cfs.BookMyShow.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface SeatRepository extends JpaRepository<Seat,Long> {
    List<Seat> findByScreenId(Long screenId);
}
