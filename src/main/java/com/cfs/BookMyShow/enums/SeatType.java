package com.cfs.BookMyShow.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum SeatType {
    @JsonProperty("REGULAR")
    Regular,

    @JsonProperty("VIP")
    VIP,

    @JsonProperty("PREMIUM")
    Premium

}

