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
	
	public void talleta(List<Vastaus> v) {
		final String sql = "insert into vastaus(kysymysID,vastausteksti) values(?,?)";

		/*
		final int kysymysID = v.getKysymysID();
		final String vastausteksti = v.getVastausteksti();

		
		KeyHolder idHolder = new GeneratedKeyHolder();

		
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql,
						new String[] { "id" });
				ps.setInt(1, kysymysID);
				ps.setString(2, vastausteksti);
				return ps;
			}
		}, idHolder);


		v.setVastausID(idHolder.getKey().intValue());
*/
	}
}
