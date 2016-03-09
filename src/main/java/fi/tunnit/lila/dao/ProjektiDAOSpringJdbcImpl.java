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
import org.springframework.web.client.RestTemplate;

import fi.tunnit.lila.bean.Henkilo;
import fi.tunnit.lila.bean.Projekti;

@Repository

	public class ProjektiDAOSpringJdbcImpl implements ProjektiDAO {

		@Inject
		private JdbcTemplate jdbcTemplate;

		public JdbcTemplate getJdbcTemplate() {
			return jdbcTemplate;
		}

		public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
			this.jdbcTemplate = jdbcTemplate;
		}
		public Projekti etsi(int projID) {
			String sql = "select projID,projnimi from projektit where projID = ?";
			Object[] parametrit = new Object[] { projID };
			RowMapper<Projekti> mapper = new ProjektiRowMapper();

			Projekti p;
			try {
				p = jdbcTemplate.queryForObject(sql, parametrit, mapper);
			} catch (IncorrectResultSizeDataAccessException e) {
				throw new HenkiloaEiLoydyPoikkeus(e);
			}
			return p;

		}
		
		public List<Projekti> haeKaikki() {

			String sql = "select projID,projnimi from projektit";
			RowMapper<Projekti> mapper = new ProjektiRowMapper();
			List<Projekti> projektit = jdbcTemplate.query(sql, mapper);

			return projektit;
			
			
		}
}
