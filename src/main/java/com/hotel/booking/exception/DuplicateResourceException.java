package com.hotel.booking.exception;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class DuplicateResourceException extends RuntimeException {
    public DuplicateResourceException(String message) {
    }
}
