package dev.dotmatthew.booking.controller;

import dev.dotmatthew.booking.model.Booking;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.UUID;

/**
 * @created by @dotMatthew
 * @created on 16.12.21
 */
@RequestMapping(value = "api/v1/booking")
@RestController
public class BookingController {

    private final HashMap<UUID, Booking> bookings = new HashMap<>();

    @GetMapping(path = "/{uuid}")
    public ResponseEntity<?> getBooking(@PathVariable UUID uuid) {
        if(bookings.isEmpty() || bookings.containsKey(uuid)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }

        return ResponseEntity.ok(bookings.get(uuid));
    }

    @PostMapping
    public ResponseEntity<?> createBooking(@RequestBody Booking booking) {
        if (bookings.containsKey(booking.getUuid())) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Booking was already saved");
        }
        return ResponseEntity.ok().body("Ok");
    }

}
