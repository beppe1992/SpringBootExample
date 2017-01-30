package it.prova.springboot.batchwithprofiles.pojo;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import javax.sql.DataSource;

public class CustomDataSource {

	private String nomeDataSource;

	public String getNomeDataSource() {
		return nomeDataSource;
	}

	public void setNomeDataSource(String nomeDataSource) {
		this.nomeDataSource = nomeDataSource;
	}

}
