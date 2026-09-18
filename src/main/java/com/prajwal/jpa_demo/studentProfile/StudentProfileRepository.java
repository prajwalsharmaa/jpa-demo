package com.prajwal.jpa_demo.studentProfile;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentProfileRepository extends JpaRepository<StudentProfile,Integer> {
}
