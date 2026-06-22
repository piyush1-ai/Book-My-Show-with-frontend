package com.cfs.BookMyShow.service;

import com.cfs.BookMyShow.dto.TheaterRequest;
import com.cfs.BookMyShow.entity.City;
import com.cfs.BookMyShow.entity.Theater;
import com.cfs.BookMyShow.repository.TheaterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TheaterService {

    private final TheaterRepository theaterRepository;
    private final CityService cityService;

    private Theater addTheater(TheaterRequest request) {
        City city = cityService.getCityById(request.getCityId());
        Theater theater = Theater.builder()
                .name(request.getName())
                .address((request.getAddress()))
                .city(city)
                .build();
        return theaterRepository.save(theater);
    }

    public List<Theater> getALlTheaters(){
        return theaterRepository.findAll();
    }
    public Theater getTheaterById(Long id){
        return theaterRepository.findById(id)
                .orElseThrow(()->new RuntimeException("theater is not found with id:"+id));
    }


    public List<Theater> getTheaterByCityId(Long cityId){
        return theaterRepository.findByCityId(cityId);
    }

}
