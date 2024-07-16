package com.vgarg.tutorials.spring.testing.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = UsersController.class)
class UserControllerTest {
	
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetUser() throws Exception {
        mockMvc.perform(get("/app-users"))
               .andExpect(status().isOk())
               .andExpect(content().json("{\r\n"
               		+ "    \"firstName\": \"John\",\r\n"
               		+ "    \"lastName\": \"Doe\"\r\n"
               		+ "}", false));
    }
}
