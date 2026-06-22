package com.cfs.BookMyShow.Controller;


import com.cfs.BookMyShow.dto.SeatRequest;
import com.cfs.BookMyShow.dto.UserRequest;
import com.cfs.BookMyShow.entity.Seat;
import com.cfs.BookMyShow.entity.User;
import com.cfs.BookMyShow.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
@RequiredArgsConstructor
public class SeatController {

    private final SeatService seatService;
    // add seats
    @PostMapping
    private ResponseEntity<Seat> addSeat(@RequestBody SeatRequest request){
        return ResponseEntity.ok(seatService.addSeat(request));
    }

    @GetMapping("/screen/{screenId}")
    public ResponseEntity<List<Seat>> getSeatByScreen(@PathVariable Long screenId){
        return ResponseEntity.ok(seatService.getSeatsByScreen(screenId));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Seat> getSeatById(@PathVariable Long id){
        return ResponseEntity.ok(seatService.getSeatById(id));
    }

}
