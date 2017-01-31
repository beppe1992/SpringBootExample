package it.prova.springboot.jdbcexample.dao;

import it.prova.springboot.jdbcexample.pojo.TabellaProva;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TabellaProvaDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional(readOnly = true)
	public List<TabellaProva> findAll() {
		return jdbcTemplate.query("select * from TABELLA_PROVA",
				new BeanPropertyRowMapper(TabellaProva.class));
	}

	@Transactional(readOnly = true)
	public TabellaProva findById(BigDecimal id) {
		return jdbcTemplate.queryForObject(
				"select * from TABELLA_PROVA where ID=?", new Object[] { id },
				new BeanPropertyRowMapper(TabellaProva.class));
	}

	public TabellaProva create(final TabellaProva toInsert) {

		final String sql = "insert into TABELLA_PROVA(ID,DESCR) values(?,?)";

		jdbcTemplate.update(new PreparedStatementCreator() {

			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql);

				ps.setBigDecimal(1, toInsert.getId());
				ps.setString(2, toInsert.getDescr());

				return ps;
			};
		});

		return toInsert;
	}
}
