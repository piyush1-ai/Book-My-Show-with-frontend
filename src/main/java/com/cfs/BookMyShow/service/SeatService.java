package com.cfs.BookMyShow.service;

import com.cfs.BookMyShow.dto.SeatRequest;
import com.cfs.BookMyShow.entity.Screen;
import com.cfs.BookMyShow.entity.Seat;
import com.cfs.BookMyShow.entity.Theater;
import com.cfs.BookMyShow.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatService {
    private final SeatRepository seatRepository;
    private final ScreenService screenService;


    // add seat
    public Seat addSeat(SeatRequest request){
        Screen screen = screenService.getScreenById(request.getScreenId());

        Seat seat = Seat.builder()
                .seatNumber(request.getSeatNumber())
                .seatType(request.getSeatType())
                .row(request.getSeatRow())
                .column(request.getSeatColumn())
                .screen(screen)
                .build();
        return seatRepository.save(seat);
    }

    public List<Seat> getSeatsByScreen(Long screenId){
        return seatRepository.findByScreenId(screenId);
    }
    public Seat getSeatById(Long id){
        return seatRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Seat not found with id:"+id));
    }

}
