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




@Repository
public class HenkiloDAOSpringJdbcImpl implements HenkiloDAO {

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
	public void talleta(Henkilo h) {
		final String sql = "insert into henkilo(etunimi, sukunimi, sahkoposti, salasana) values(?,?,?,?)";

		// anonyymi sisäluokka tarvitsee vakioina välitettävät arvot,
		// jotta roskien keruu onnistuu tämän metodin suorituksen päättyessä.
		final String etunimi = h.getEtunimi();
		final String sukunimi = h.getSukunimi();
		final String sposti = h.getSposti();
		final String salasana = h.getSalasana();

		// jdbc pistää generoidun id:n tänne talteen
		KeyHolder idHolder = new GeneratedKeyHolder();

		// suoritetaan päivitys itse määritellyllä PreparedStatementCreatorilla
		// ja KeyHolderilla
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql,
						new String[] { "id" });
				ps.setString(1, etunimi);
				ps.setString(2, sukunimi);
				ps.setString(3, sposti);
				ps.setString(4, salasana);
				return ps;
			}
		}, idHolder);

		// tallennetaan id takaisin beaniin, koska
		// kutsujalla pitäisi olla viittaus samaiseen olioon
		h.setId(idHolder.getKey().intValue());

	}

	public Henkilo etsi(int id) {
		String sql = "select kaytID,etunimi,sukunimi,sahkoposti,salasana from kayttaja where kaytID = ?";
		Object[] parametrit = new Object[] { id };
		RowMapper<Henkilo> mapper = new HenkiloRowMapper();

		Henkilo h;
		try {
			h = jdbcTemplate.queryForObject(sql, parametrit, mapper);
		} catch (IncorrectResultSizeDataAccessException e) {
			throw new HenkiloaEiLoydyPoikkeus(e);
		}
		return h;

	}
	

	
	/* DELETE RESTILL� 
    private static void poistaHenkilo(int id) {
        System.out.println("Testing delete User API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/user/3");
    }
    */
	
	public List<Henkilo> haeKaikki() {

		String sql = "select kaytID,etunimi,sukunimi,sahkoposti,salasana from kayttaja";
		RowMapper<Henkilo> mapper = new HenkiloRowMapper();
		List<Henkilo> henkilot = jdbcTemplate.query(sql, mapper);

		return henkilot;
		
		
	}
	
	

}
