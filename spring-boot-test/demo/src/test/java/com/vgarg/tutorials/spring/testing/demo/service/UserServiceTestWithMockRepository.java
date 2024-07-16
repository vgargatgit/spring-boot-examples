package com.vgarg.tutorials.spring.testing.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.vgarg.tutorials.spring.testing.demo.entity.User;
import com.vgarg.tutorials.spring.testing.demo.repository.UserRepository;

@SpringBootTest
class UserServiceWithMockRepositoryTest {

    @Autowired
    private UserService userService;

    @MockBean // Instead of userRepository bean from context, use a mock one
    private UserRepository userRepository;

    @Test
    void testFindUserById() {
        // Arrange
        User mockUser = new User();
        UUID id = UUID.randomUUID();

        mockUser.setId(id);
        mockUser.setFirstName("John");
        mockUser.setLastName("Doe");
        when(userRepository.findById(id)).thenReturn(Optional.of(mockUser));

        // Act
        User foundUser = userService.findUserById(id);

        // Assert
        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getFirstName()).isEqualTo("John");
    }
}
