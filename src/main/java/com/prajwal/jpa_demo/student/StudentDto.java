package com.prajwal.jpa_demo.student;

import jakarta.validation.constraints.NotEmpty;

public record StudentDto(
        @NotEmpty
        String firstName,
        @NotEmpty
        String lastName,
        String email,
        Integer schoolId
) {
}
