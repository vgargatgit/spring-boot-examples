package com.vgarg.tutorials.spring.testing.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AddServiceTest {

    @Autowired
    private AddService myService;

    @Test
    void testAddition() {
        int result = myService.add(1, 2);
        assertEquals(3, result);
    }
}
