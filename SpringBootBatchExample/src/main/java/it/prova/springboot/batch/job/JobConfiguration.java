package it.prova.springboot.batch.job;

import it.prova.springboot.batch.listener.BaseStepEsecutionListener;
import it.prova.springboot.batch.reader.BaseReader;
import it.prova.springboot.batch.tasklet.SysoutTasklet;
import it.prova.springboot.batch.writer.BaseWriter;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersIncrementer;
import org.springframework.batch.core.JobParametersValidator;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
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

@EnableBatchProcessing
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
@ComponentScan
public class JobConfiguration {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	public Job createJobEsempio(Step step1, Step step2) {
		return jobBuilderFactory.get("jobProva1")
				.incrementer(new RunIdIncrementer()).start(step1).next(step2)
				.build();
	}

	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1")
				.tasklet(new SysoutTasklet())
				.listener(new BaseStepEsecutionListener())
				.build();
	}

	@Bean
	public Step step2() {
		return stepBuilderFactory.get("step2")
				.chunk(100)
				.reader(new BaseReader())
				.writer(new BaseWriter())
				.listener(new BaseStepEsecutionListener())
				.build();
	}
}
