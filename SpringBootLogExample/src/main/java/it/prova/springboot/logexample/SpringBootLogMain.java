package it.prova.springboot.logexample;

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

public class SpringBootLogMain {

	private static final Logger logger = LoggerFactory
			.getLogger(SpringBootLogMain.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLogMain.class, args);

		logger.error("Message logged at ERROR level");
		logger.warn("Message logged at WARN level");
		logger.info("Message logged at INFO level");
		
		// SE NON CONFIGURASSIMO IL FILE logback.xml, SPRING BOOT NON FAREBBE VEDERE QUESTO
		// LOG, IN QUANTO DI DEFAULT LOGGA I LIVELLI DEBUG
		
		// IL FRAMEWORK RICERCA AUTOMATICAMENTE I SEGUENTI FILE XML DI CONFIGURAZIONE:
		// Logback -> logback-spring.xml, logback-spring.groovy, logback.xml or logback.groovy
		// Log4j2 -> log4j2-spring.xml or log4j2.xml
		// JDK (Java Util Logging) -> logging.properties
		
		logger.debug("Message logged at DEBUG level");

		System.exit(0);
	}
}
