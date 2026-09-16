package com.prajwal.jpa_demo.student;

public record StudentResponseDto(
        String firstName,
        String lastName,
        String email
) {
}
