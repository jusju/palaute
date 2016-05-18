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



import fi.palaute.bean.Poletti;


@Repository
public class PolettiDAOSpringJdbcImpl implements PolettiDAO {


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
		public void tallenna(Poletti p) {
			final String sql = "insert into poletti(kaytID, satunnainen, vanhenemispvm) values(?,?,?)";

			
			final int kaytID = p.getKaytID();
			final String satunnainen = p.getSatunnainen();
			final String pvm = p.getPvm();
	
			KeyHolder idHolder = new GeneratedKeyHolder();

			
			jdbcTemplate.update(new PreparedStatementCreator() {
				public PreparedStatement createPreparedStatement(
						Connection connection) throws SQLException {
					PreparedStatement ps = connection.prepareStatement(sql,
							new String[] { "id" });
					ps.setInt(1, kaytID);
					ps.setString(2, satunnainen);
					ps.setString(3, pvm);

					return ps;
				}
			}, idHolder);


			p.setPolettiID(idHolder.getKey().intValue());

		}



		//hae kaikki poletit vertailua varten
		public List<Poletti> haeKaikki() {

			String sql = "select polettiID, satunnainen,kaytID,vanhenemispvm from poletti";
			RowMapper<Poletti> mapper = new PolettiRowMapper();
			List<Poletti> poletti = jdbcTemplate.query(sql, mapper);

			return poletti;

		}
		

		
		public void poistaSatunnainen(String satunnainen){
			final String sql = "DELETE FROM poletti WHERE satunnainen = ?";

			try {
			jdbcTemplate.update(sql, satunnainen);
			} catch (IncorrectResultSizeDataAccessException e) {
				throw new KayttajaaEiLoydyPoikkeus(e);
			}
			
		}
		
		public void poistaPoletti(int kaytID){
			final String sql = "DELETE FROM poletti WHERE kaytID = ?";

			try {
			jdbcTemplate.update(sql, kaytID);
			} catch (IncorrectResultSizeDataAccessException e) {
				throw new KayttajaaEiLoydyPoikkeus(e);
			}
			
		}
	

}
