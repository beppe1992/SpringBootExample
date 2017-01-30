package it.prova.springboot.rest.service;

import it.prova.springboot.rest.pojo.ResponseExample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestService {

	@Value("${PROPERTIES.LETTA}")
	private String propertiesLetta;

	@RequestMapping("/helloworld")
	ResponseExample helloWorld() {
		ResponseExample resp = new ResponseExample();
		resp.setExitBody("HO LETTO CORRETTAMENTE LA PROPERTY");
		resp.setExitCode("OK");
		resp.setPropertyLetta(propertiesLetta);
		return resp;
	}

	public String getPropertiesLetta() {
		return propertiesLetta;
	}

	public void setPropertiesLetta(String propertiesLetta) {
		this.propertiesLetta = propertiesLetta;
	}

}
