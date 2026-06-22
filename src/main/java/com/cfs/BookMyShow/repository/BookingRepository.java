package com.cfs.BookMyShow.repository;

import com.cfs.BookMyShow.entity.Booking;
import com.cfs.BookMyShow.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,Long> {
    List<Booking> findByUserId(Long userId);
    List<Booking> findByShowId(Long showId);

    // find all seat ids that are already booked for given show
//    @Param is an annotation used to bind a method parameter in your
//    repository interface to a named parameter in your JPQL or native SQL query.

    @Query("SELECT s.id FROM Booking b JOIN b.seats s WHERE b.show.id=:showId AND b.status='CONFIRMED'")
    List<Long> findBookedSeatIdsByShowId(@Param("ShowId")Long showId);
}
