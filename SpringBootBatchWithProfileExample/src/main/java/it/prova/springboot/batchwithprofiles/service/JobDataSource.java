package it.prova.springboot.batchwithprofiles.service;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import it.prova.springboot.batchwithprofiles.annotation.ProdProfile;
import it.prova.springboot.batchwithprofiles.annotation.TestProfile;
import it.prova.springboot.batchwithprofiles.pojo.CustomDataSource;

@ProdProfile
@Configuration
public class JobDataSource {

	@Bean
	public CustomDataSource getDataSouceProd(){
		CustomDataSource dataSouce = new CustomDataSource();
		dataSouce.setNomeDataSource("Restituisco un datasource di PROD");
		return dataSouce;
	}
}
