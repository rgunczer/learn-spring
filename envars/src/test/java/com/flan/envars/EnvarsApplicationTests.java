package com.flan.envars;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.yml")
class EnvarsApplicationTests {

	@Test
	void contextLoads() {
	}

}
