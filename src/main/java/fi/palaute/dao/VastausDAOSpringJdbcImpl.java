package fi.palaute.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import fi.palaute.bean.Toteutus;
import fi.palaute.bean.Vastaus;




@Repository

public class VastausDAOSpringJdbcImpl implements VastausDAO {
	
	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	

	public List<Vastaus> haeKaikkiVastaukset() {

		String sql = "select vastausID, kysymysID,vastausteksti from vastaus";
		RowMapper<Vastaus> mapper = new VastausRowMapper();
		List<Vastaus> vastaukset = jdbcTemplate.query(sql, mapper);

		return vastaukset;

	}
}
