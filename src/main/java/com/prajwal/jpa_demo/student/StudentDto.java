package com.prajwal.jpa_demo.student;

public record StudentDto(
        String firstName,
        String lastName,
        String email,
        Integer schoolId
) {
}
