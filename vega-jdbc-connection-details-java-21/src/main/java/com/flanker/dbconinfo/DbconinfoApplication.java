package com.flanker.dbconinfo;

import static java.lang.StringTemplate.STR;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.JdbcConnectionDetails;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DbconinfoApplication {

	// Dan Vega: print out the JdbcConnectionDetails
	// https://x.com/therealdanvega/status/1707097081960129013?s=20

	public static void main(String[] args) {
		SpringApplication.run(DbconinfoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(JdbcConnectionDetails jdbc) {
		return runner -> {
			var details = STR."""
					Details: \{jdbc.getClass().getName()}
					JDBC URL: \{jdbc.getJdbcUrl()}
					Username: \{jdbc.getUsername()}
					Password: \{jdbc.getPassword()}
				""";
			System.out.println(details);
		};
	}

}
