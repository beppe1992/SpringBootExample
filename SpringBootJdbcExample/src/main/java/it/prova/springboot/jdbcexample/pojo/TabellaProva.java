package it.prova.springboot.jdbcexample.pojo;

import java.math.BigDecimal;

public class TabellaProva {

	private BigDecimal id;

	private String descr;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

}
