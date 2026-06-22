package com.cfs.BookMyShow.repository;

import com.cfs.BookMyShow.entity.Show;
import com.cfs.BookMyShow.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ShowRepository extends JpaRepository<Show,Long> {

    List<Show> findByMovieId(Long movieId);
    List<Show>findByScreenId(Long screenId);
    List<Show>findByMovieIdAndShowDate(Long movieId, LocalDate showDate);
    List<Show>findByScreenIdAndShowDate(Long screenId, LocalDate showDate);

}
