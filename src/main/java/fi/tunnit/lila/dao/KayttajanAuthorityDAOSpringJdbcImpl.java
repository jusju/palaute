package fi.tunnit.lila.dao;

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






import fi.tunnit.lila.bean.KayttajanAuthority;
import fi.tunnit.lila.bean.Tunnit;


@Repository
public class KayttajanAuthorityDAOSpringJdbcImpl implements KayttajanAuthorityDAO {

	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * Tallettaa parametrina annetun henkilön tietokantaan. Tietokannan
	 * generoima id asetetaan parametrina annettuun olioon.
	 */
	

	public List<KayttajanAuthority> etsiK() {
		String sql = "select kayttaja_id, authority_id from kayttajan_authority";
		RowMapper<KayttajanAuthority> mapper = new KayttajanAuthorityRowMapper();
		List<KayttajanAuthority> auth = jdbcTemplate.query(sql, mapper);

		return auth;

	}

	
}