package it.prova.springboot.jdbcexample.service;

import java.math.BigDecimal;
import java.util.List;

import it.prova.springboot.jdbcexample.dao.TabellaProvaDao;
import it.prova.springboot.jdbcexample.pojo.TabellaProva;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@Controller
public class JdbcExampleService {

	@Autowired
	TabellaProvaDao service;

	public List<TabellaProva> helloWorld() {

		return service.findAll();
	}

	public TabellaProva helloWorld(BigDecimal id) {

		return service.findById(id);
	}

}
