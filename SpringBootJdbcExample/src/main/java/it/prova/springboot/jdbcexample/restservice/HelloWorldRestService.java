package it.prova.springboot.jdbcexample.restservice;

import java.math.BigDecimal;
import java.util.List;

import it.prova.springboot.jdbcexample.pojo.TabellaProva;
import it.prova.springboot.jdbcexample.service.TabellaProvaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestService {

	@Autowired
	TabellaProvaService service;

	@RequestMapping("/selectAll")
	List<TabellaProva> helloWorld() {

		return service.findAll();
	}

	@RequestMapping("/selectById")
	TabellaProva helloWorld(@RequestParam BigDecimal id) {

		return service.findById(id);
	}

}
