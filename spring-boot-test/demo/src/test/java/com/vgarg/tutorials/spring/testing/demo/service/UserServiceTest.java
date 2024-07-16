package com.vgarg.tutorials.spring.testing.demo.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.vgarg.tutorials.spring.testing.demo.entity.User;
import com.vgarg.tutorials.spring.testing.demo.repository.UserRepository;

class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository UserRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initializes fields annotated with @Mock and @InjectMocks
    }
    
    @Test
    void testFindEntityById() {
        // Arrange
        User mockEntity = new User();        
        UUID id = UUID.randomUUID();
        
        mockEntity.setId(id);
        when(UserRepository.findById(id)).thenReturn(Optional.of(mockEntity));

        // Act
        User foundEntity = userService.findUserById(id);

        // Assert
        assertNotNull(foundEntity);
    }
}
