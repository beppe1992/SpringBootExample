package it.prova.springboot.batchwithprofiles.job;

import it.prova.springboot.batchwithprofiles.tasklet.SysoutTasklet;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersIncrementer;
import org.springframework.batch.core.JobParametersValidator;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Classe che si occupa di configurare il job
 * 
 * @author arx50011
 * 
 */
//VIENE ESCLUSA L'AUTOCONFIGURAZIONE DEL DATASOURCE IN QUANTO QUESTO JOB NON HA ALCUN DATASOURCE
@EnableBatchProcessing
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
@ComponentScan({ "it.prova.springboot.batchwithprofiles.*" })
public class JobConfiguration {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private Tasklet sysoutTasklet;

	@Bean
	public Job createJobEsempio(Step step1) {
		return jobBuilderFactory.get("jobProva1")
				.incrementer(new RunIdIncrementer()).start(step1).build();
	}

	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1").tasklet(sysoutTasklet).build();
	}

}
