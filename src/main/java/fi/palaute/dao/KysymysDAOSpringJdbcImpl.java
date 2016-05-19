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

import fi.palaute.bean.Kysymys;
import fi.palaute.dao.KysymysRowMapper;
import fi.palaute.dao.HenkiloaEiLoydyPoikkeus;




@Repository

public class KysymysDAOSpringJdbcImpl implements KysymysDAO {
	
	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Kysymys> haeKaikki() {

		String sql = "select kysymysID, kysymysteksti from kysymys";
		RowMapper<Kysymys> mapper = new KysymysRowMapper();
		List<Kysymys> kysymykset = jdbcTemplate.query(sql, mapper);

		return kysymykset;
		
		
	}
	
	public Kysymys etsi(int kysymysID) {
		String sql = "select kysymysID, kysymysteksti from kayttaja where kysymysID = ?";
		Object[] parametrit = new Object[] { kysymysID };
		RowMapper<Kysymys> mapper = new KysymysRowMapper();

		Kysymys k;
		try {
			k = jdbcTemplate.queryForObject(sql, parametrit, mapper);
		} catch (IncorrectResultSizeDataAccessException e) {
			throw new HenkiloaEiLoydyPoikkeus(e);
		}
		return k;

	}
	
	

}
