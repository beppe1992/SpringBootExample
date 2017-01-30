package it.prova.springboot.jdbcexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;

/**
 * Hello world!
 * 
 */
@SpringBootApplication
public class SpringBootJdbcMain {

	private static final Logger logger = LoggerFactory
			.getLogger(SpringBootJdbcMain.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcMain.class, args);

		
	}
}
