package com.hotel.booking.dto.response;

import com.hotel.booking.domain.Guest;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Builder
public class GuestResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private LocalDateTime createdAt;

    public static GuestResponse from(Guest guest) {
        return GuestResponse.builder()
                .id(guest.getId())
                .firstName(guest.getFirstName())
                .lastName(guest.getLastname())
                .email(guest.getEmail())
                .phone(guest.getPhone())
                .createdAt(guest.getCreatedAt())
                .build();
    }
}
