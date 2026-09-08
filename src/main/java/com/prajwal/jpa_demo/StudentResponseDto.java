package com.prajwal.jpa_demo;

public record StudentResponseDto(
        String firstName,
        String lastName,
        String email,
        Integer schoolId
) {
}
