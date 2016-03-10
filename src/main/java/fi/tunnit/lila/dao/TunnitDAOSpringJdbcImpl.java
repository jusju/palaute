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




import fi.tunnit.lila.bean.Henkilo;
import fi.tunnit.lila.bean.Tunnit;



@Repository
public class TunnitDAOSpringJdbcImpl implements TunnitDAO {

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
	public void talleta(Tunnit t) {
		final String sql = "insert into tunnit(kaytID, projID, date, aloitusaika, lopetusaika, kuvaus) values(?,?,?,?,?,?)";

		
		final int kaytID = t.getKaytID();
		final int projID = t.getProjID();
		final String date = t.getDate();
		final String aloitusaika = t.getAloitusaika();
		final String lopetusaika = t.getLopetusaika();
		final String kuvaus = t.getKuvaus();

		
		KeyHolder idHolder = new GeneratedKeyHolder();

		
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql,
						new String[] { "id" });
				ps.setInt(1, kaytID);
				ps.setInt(2, projID);
				ps.setString(3, date);
				ps.setString(4, aloitusaika);
				ps.setString(5, lopetusaika);
				ps.setString(6, kuvaus);
				return ps;
			}
		}, idHolder);


		t.setTuntiID(idHolder.getKey().intValue());

	}
	
	

	public List<Tunnit> etsi(int kaytID) {
		String sql = "select tuntiID,kaytID,projID,date,aloitusaika,lopetusaika,kuvaus from tunnit where kaytID = ?";
		Object[] parametrit = new Object[] { kaytID };
		RowMapper<Tunnit> mapper = new TunnitRowMapper();
		List<Tunnit> tunnit = jdbcTemplate.query(sql,parametrit, mapper);

		return tunnit;

	}

	
	public Tunnit etsiTunnit(int id) {
		String sql = "select tuntiID,kaytID,projID,date,aloitusaika,lopetusaika,kuvaus from tunnit where kaytID = ?";
		Object[] parametrit = new Object[] { id };
		RowMapper<Tunnit> mapper = new TunnitRowMapper();
		
		Tunnit t;
		try {
			t = jdbcTemplate.queryForObject(sql, parametrit, mapper);
		} catch (IncorrectResultSizeDataAccessException e) {
			throw new HenkiloaEiLoydyPoikkeus(e);
		}
		return t;

	}
	
	public List<Tunnit> haeTunnit() {

		String sql = "select tuntiID,kaytID,projID,date,aloitusaika,lopetusaika,kuvaus from tunnit";
		RowMapper<Tunnit> mapper = new TunnitRowMapper();
		List<Tunnit> tunnit = jdbcTemplate.query(sql, mapper);

		return tunnit;
		
		
	}
	
	public Tunnit etsiTunti(int tuntiID) {
		String sql = "select tuntiID,kaytID,projID,date,aloitusaika,lopetusaika,kuvaus from tunnit where tuntiID = ?";
		Object[] parametrit = new Object[] { tuntiID };
		RowMapper<Tunnit> mapper = new TunnitRowMapper();
		
		Tunnit t;
		try {
			t = jdbcTemplate.queryForObject(sql, parametrit, mapper);
		} catch (IncorrectResultSizeDataAccessException e) {
			throw new HenkiloaEiLoydyPoikkeus(e);
		}
		return t;

	}
	
	public Tunnit poistaTunti(int tuntiID){
		final String sql = "DELETE FROM tunnit WHERE tuntiID = ?";
		Object[] parametrit = new Object[] { tuntiID };
		RowMapper<Tunnit> mapper = new TunnitRowMapper();

		Tunnit t;
		try {
			t = jdbcTemplate.queryForObject(sql, parametrit, mapper);
		} catch (IncorrectResultSizeDataAccessException e) {
			throw new HenkiloaEiLoydyPoikkeus(e);
		}
		return t;


		
	}
	
	
	
}