package com.cfs.BookMyShow.Controller;

import com.cfs.BookMyShow.entity.Screen;
import com.cfs.BookMyShow.service.ScreenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/screens")
@RequiredArgsConstructor
public class ScreenController {
    private final ScreenService screenService;
    // add screen


    @GetMapping
    public ResponseEntity<List<Screen>> getAllScreens(){
        return ResponseEntity.ok(screenService.getALlScreen());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Screen> getScreenById(@PathVariable Long id){
        return ResponseEntity.ok(screenService.getScreenById(id));
    }
    @GetMapping("/theater/{theaterId}")
    public ResponseEntity<List<Screen>> getScreenByTheaterId(@PathVariable Long theaterId){
        return ResponseEntity.ok(screenService.getScreenByTheaterId(theaterId));
    }


}
