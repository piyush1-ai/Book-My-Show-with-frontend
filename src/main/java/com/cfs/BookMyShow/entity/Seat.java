package com.cfs.BookMyShow.entity;

import com.cfs.BookMyShow.enums.SeatType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "seats")
@Getter // getter and setters are automatically generated
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String seatNumber;

    @Column(name = "seat_row")
    private String row; // A,B,C

    @Column(name = "seat_column")
    private Integer column; // 1,2,3

    @Enumerated(EnumType.STRING)
    private SeatType seatType; // REGULAR

    @ManyToOne
    @JoinColumn(name = "screen_id",nullable = false)
    private Screen screen;

}
