package com.cfs.BookMyShow.Controller;

import com.cfs.BookMyShow.dto.ShowRequest;
import com.cfs.BookMyShow.dto.UserRequest;
import com.cfs.BookMyShow.entity.Show;
import com.cfs.BookMyShow.entity.User;
import com.cfs.BookMyShow.service.ShowService;
import com.cfs.BookMyShow.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/shows")
@RequiredArgsConstructor
public class ShowController {
    private final ShowService showService;

    @PostMapping
    public ResponseEntity<Show> addShows(@RequestBody ShowRequest request){
        return ResponseEntity.ok(showService.addShow(request));
    }

    @GetMapping
    public ResponseEntity<List<Show>> getAllShows(){
        return  ResponseEntity.ok(showService.getALlShow());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Show> getShowById(@PathVariable Long id){
        return  ResponseEntity.ok(showService.getShowById(id));
    }
    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<Show>> getShowByMovieId(@PathVariable Long movieId){
        return  ResponseEntity.ok(showService.getShowByMovieId(movieId));
    }

    @GetMapping("/movie/{movieId}/date")
    public ResponseEntity<List<Show>> getShowByMovieAndDate(@PathVariable Long movieId , @RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        return ResponseEntity.ok(showService.getShowByMovieIdAndDate(movieId,date));
    }


}
