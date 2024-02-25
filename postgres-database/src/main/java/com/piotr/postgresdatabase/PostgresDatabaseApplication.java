package com.piotr.postgresdatabase;

//import lombok.extern.java.Log;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//@Log
//public class PostgresDatabaseApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(PostgresDatabaseApplication.class, args);
//	}
//}

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
@Log
public class PostgresDatabaseApplication implements CommandLineRunner {

	private final DataSource dataSource; // database object for interacting with the DB

	// constructor for the DataSource object
	public PostgresDatabaseApplication(final DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public static void main(String[] args) {
		SpringApplication.run(PostgresDatabaseApplication.class, args);
	}

	@Override
	public void run(final String... args) {
		log.info("Datasource: " + dataSource.toString());
		final JdbcTemplate restTemplate = new JdbcTemplate(dataSource);
		restTemplate.execute("select 1");
	}

}