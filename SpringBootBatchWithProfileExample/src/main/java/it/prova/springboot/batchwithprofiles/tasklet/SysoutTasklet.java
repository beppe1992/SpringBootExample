package it.prova.springboot.batchwithprofiles.tasklet;

import javax.sql.DataSource;

import it.prova.springboot.batchwithprofiles.pojo.CustomDataSource;
import it.prova.springboot.batchwithprofiles.service.JobDataSource;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class SysoutTasklet implements Tasklet {

	@Autowired
	private CustomDataSource datasource;

	@Value("${PROPERTIES.LETTA}")
	private String propertiesLetta;

	@Override
	public RepeatStatus execute(StepContribution contribution,
			ChunkContext chunkContext) throws Exception {
		System.out
				.println("CIAO SONO UNA TASKLET, E QUESTO E' IL MIO DATASOURCE: "
						+ datasource.getNomeDataSource());

		System.out
				.println("INOLTRE, HO LETTO IL SEGUENTE VALORE DAL FILE DI PROPERTIES: "
						+ propertiesLetta);
		return null;
	}

	public CustomDataSource getDatasource() {
		return datasource;
	}

	public void setDatasource(CustomDataSource datasource) {
		this.datasource = datasource;
	}

}
