package com.cfs.BookMyShow.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum BookingStatus {
  @JsonProperty("CONFIRMED")
  CONFIRMED,
  @JsonProperty("CANCELED")
  CANCELED
}
