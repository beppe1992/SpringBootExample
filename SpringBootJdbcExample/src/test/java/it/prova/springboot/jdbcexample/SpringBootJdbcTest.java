package it.prova.springboot.jdbcexample;

import java.math.BigDecimal;

import it.prova.springboot.jdbcexample.pojo.TabellaProva;
import it.prova.springboot.jdbcexample.service.JdbcExampleService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
public class SpringBootJdbcTest {

	@Autowired
	private JdbcExampleService service;

	@Test
	public void testFreeMarkerTemplate() throws Exception {
		for (TabellaProva tabellaProva : service.helloWorld()) {
			System.out.println(tabellaProva);
		}
	}

	@Test
	public void testFreeMarkerTemplateAltroMetodo() throws Exception {

		System.out.println(service.helloWorld(new BigDecimal(1)));

	}
}
