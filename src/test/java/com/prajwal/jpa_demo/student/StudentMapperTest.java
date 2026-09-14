package com.prajwal.jpa_demo.student;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {
    @BeforeAll
    static void beforeAll() {
        System.out.println("Inside beforeAll method with @BeforeAll annotation");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Inside setup method with @BeforeEach annotation");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Inside tearDown method with @AfterEach annotation");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Inside afterAll method with @AfterAll annotation");
    }

    @Test
    public void testMethod1(){
        System.out.println("My first test method");
    }
    @Test
    public void testMethod2(){
        System.out.println("My Second test method");
    }
}