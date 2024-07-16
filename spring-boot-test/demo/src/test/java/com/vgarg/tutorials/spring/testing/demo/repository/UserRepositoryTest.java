package com.vgarg.tutorials.spring.testing.demo.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.vgarg.tutorials.spring.testing.demo.entity.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.ANY, connection = EmbeddedDatabaseConnection.H2)
@ActiveProfiles("test")
class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;

	@Test
	void testSaveUser() {
		User user = User.builder().firstName("John").lastName("Doe").build();
		userRepository.save(user);
		User found = userRepository.findById(user.getId()).orElse(null);
		assertThat(found).isNotNull();
		assertThat(found.getFirstName()).isEqualTo("John");
	}
}
