package com.cfs.BookMyShow.service;

import com.cfs.BookMyShow.dto.ScreenRequest;
import com.cfs.BookMyShow.entity.Screen;
import com.cfs.BookMyShow.entity.Theater;
import com.cfs.BookMyShow.repository.ScreenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScreenService {

    private final ScreenRepository screenRepository;
    private final TheaterService theaterService;

    // H.W addScreen
    public Screen addScreen(ScreenRequest request){
        Theater theater = theaterService.getTheaterById(request.getTheaterId());
        if (theater == null) {
            throw new RuntimeException("Theater not found with id: " + request.getTheaterId());
        }

        if (request.getTotalSeats() <= 0) {
            throw new RuntimeException("Total seats must be greater than zero");
        }

        Screen screen = Screen.builder()
                .name(request.getName())
                .theater(theater)
                .totalSeats(request.getTotalSeats())
                .build();
        return screenRepository.save(screen);

    }

    public List<Screen> getALlScreen(){
        return screenRepository.findAll();
    }

    public Screen getScreenById(Long id){
        return screenRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Screen is not found with id: "+id));
    }

    public List<Screen> getScreenByTheaterId(Long TheaterId){
        return screenRepository.findByTheaterId(TheaterId);
    }
}
