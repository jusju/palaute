package fi.palaute.dao;

import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;







import fi.palaute.bean.KayttajanAuthority;


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