package com.cfs.BookMyShow.Controller;

import com.cfs.BookMyShow.entity.Theater;
import com.cfs.BookMyShow.service.TheaterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/theaters")
@RequiredArgsConstructor
public class TheaterController {
    private final TheaterService theaterService;

    // post add

    @GetMapping
    public ResponseEntity<List<Theater>> getAllTheater(){
        return ResponseEntity.ok(theaterService.getALlTheaters());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Theater> getTheaterById(@PathVariable Long id){
        return ResponseEntity.ok(theaterService.getTheaterById(id));
    }
    @GetMapping("/city/{cityId}")
    public ResponseEntity<List<Theater>> getTheaterByCity(@PathVariable Long cityId){
        return ResponseEntity.ok(theaterService.getTheaterByCityId(cityId));
    }

}
