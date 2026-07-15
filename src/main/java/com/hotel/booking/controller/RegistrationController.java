package com.hotel.booking.controller;

import com.hotel.booking.domain.Guest;
import com.hotel.booking.dto.request.RegisterRequest;
import com.hotel.booking.dto.response.GuestResponse;
import com.hotel.booking.service.RegistrationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/register")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    public ResponseEntity<GuestResponse> register(
            @Valid @RequestBody RegisterRequest request
            ) {

        Guest guest = registrationService.register(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(GuestResponse.from(guest));
    }
}
