package it.prova.springboot.batchwithprofiles;


import it.prova.springboot.batchwithprofiles.job.JobConfiguration;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;

/**
 * Hello world!
 * 
 */

public class SpringBootBatchWithProfileMain {
	public static void main(String[] args) {
		System.exit(SpringApplication.exit(SpringApplication.run(
				JobConfiguration.class, args)));
	}
}
