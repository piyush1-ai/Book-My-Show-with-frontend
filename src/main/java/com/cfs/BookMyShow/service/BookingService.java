package com.cfs.BookMyShow.service;

import com.cfs.BookMyShow.dto.BookingRequest;
import com.cfs.BookMyShow.entity.*;
import com.cfs.BookMyShow.enums.BookingStatus;
import com.cfs.BookMyShow.repository.BookingRepository;
import com.cfs.BookMyShow.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final SeatRepository seatRepository;
    private final UserService userService;
    private final ShowService showService;

    @Transactional
    public Booking createBooking(BookingRequest request){
        User user = userService.getUserById(request.getUserId());
        Show show = showService.getShowById(request.getShowId());

        // check if any of requested seat are already booked
        List<Long> alreadyBookedSeats = bookingRepository.findBookedSeatIdsByShowId(show.getId());

        for (Long seatID : request.getSeatIds()){
            if (alreadyBookedSeats.contains(seatID)){
                throw  new RuntimeException("seat with id "+seatID+"is already Booked");
            }
        }
        List<Seat> seats = seatRepository.findAllById(request.getSeatIds());
        if (seats.size()!= request.getSeatIds().size()){
            throw new RuntimeException("Some seats are Invalid");
        }
        double totalPRice = seats.size()* show.getTicketPrice();
        Booking booking = Booking.builder()
                .user(user)
                .show(show)
                .seats(seats)
                .totalPrice(totalPRice)
                .status(BookingStatus.CONFIRMED)
                .build();
        return bookingRepository.save(booking);
    }
    public Booking getBookingById(Long id){
        return  bookingRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Booking is not found with id: "+id));
    }

    public List<Booking> getBookingByUser(Long userId){
        return bookingRepository.findByUserId(userId);
    }

    @Transactional
    public Booking cancelBooking(Long bookingId){
        Booking booking = getBookingById(bookingId);
        booking.setStatus(BookingStatus.CANCELED);
        return bookingRepository.save(booking);
    }
    public List<Seat> getAvailableSeats(Long showId){
        Show show = showService.getShowById(showId);
        List<Seat> allSeats =seatRepository.findByScreenId(show.getScreen().getId());
        List<Long> bookingSeatIds =  bookingRepository.findBookedSeatIdsByShowId(showId);
        return allSeats.stream()
                .filter(seat -> !bookingSeatIds.contains(seat.getId()))
                .toList();
    }
}
