package dev.dotmatthew.booking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * @created by @dotMatthew
 * @created on 16.12.21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    private UUID uuid;
    private String bookingTitle;

}
