package com.prajwal.jpa_demo;

public record StudentDto(
        String firstName,
        String lastName,
        String email,
        Integer schoolId
) {
}
