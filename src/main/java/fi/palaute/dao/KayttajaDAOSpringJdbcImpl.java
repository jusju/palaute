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

import fi.palaute.bean.Kayttaja;


@Repository
public class KayttajaDAOSpringJdbcImpl implements KayttajaDAO {

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
	@SuppressWarnings("deprecation")
	public void talleta(Kayttaja h) {
		final String sql = "insert into kayttaja(sahkoposti, salasana) values(?,?)";
		final String auth = "insert into kayttajan_authority(kayttaja_id, authority_id) values(?, 1)";
		final String maxidsql = "select MAX(kaytID) AS kaytID FROM kayttaja";

		
		// anonyymi sisäluokka tarvitsee vakioina välitettävät arvot,
		// jotta roskien keruu onnistuu tämän metodin suorituksen
		// päättyessä.
		final String tunnus = h.getTunnus();
		final String salasana = h.getSalasana();

		// jdbc pistää generoidun id:n tänne talteen
		KeyHolder idHolder = new GeneratedKeyHolder();

		// suoritetaan päivitys itse määritellyllä
		// PreparedStatementCreatorilla
		// ja KeyHolderilla
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql,
						new String[] { "id" });
				ps.setString(1, tunnus);
				ps.setString(2, salasana);
				return ps;
			}
		}, idHolder);
		
		//etsimme viimmeinen id
		final int i;
		i = jdbcTemplate.queryForInt(maxidsql);
		
		//lisätään auth_rooli viimmeselle käyttäjälle
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(auth);
				ps.setInt(1, i);
				return ps;
			}
		});

		// tallennetaan id takaisin beaniin, koska
		// kutsujalla pitäisi olla viittaus samaiseen olioon
		h.setId(idHolder.getKey().intValue());

	}

	public Kayttaja etsi(int id) {
		String sql = "select kaytID,sahkoposti, salasana from kayttaja where kaytID = ?";
		Object[] parametrit = new Object[] { id };
		RowMapper<Kayttaja> mapper = new KayttajaRowMapper();

		Kayttaja h;
		try {
			h = jdbcTemplate.queryForObject(sql, parametrit, mapper);
		} catch (IncorrectResultSizeDataAccessException e) {
			throw new KayttajaaEiLoydyPoikkeus(e);
		}
		return h;

	}
	
	public Kayttaja etsiSposti(String sposti) {
		String sql = "select kaytID,sahkoposti, salasana from kayttaja where sahkoposti = ?";
		Object[] parametrit = new Object[] { sposti };
		RowMapper<Kayttaja> mapper = new KayttajaRowMapper();

		Kayttaja h;
		try {
			h = jdbcTemplate.queryForObject(sql, parametrit, mapper);
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}
		return h;

	}	

	public List<Kayttaja> haeKaikki() {

		String sql = "select kaytID,sahkoposti, salasana from kayttaja";
		RowMapper<Kayttaja> mapper = new KayttajaRowMapper();
		List<Kayttaja> henkilot = jdbcTemplate.query(sql, mapper);

		return henkilot;

	}

	public void uusiSalasana(Kayttaja k) {
		final String sql = "update kayttaja set salasana=? where kaytID=?";
	

		// anonyymi sisäluokka tarvitsee vakioina välitettävät arvot,
		// jotta roskien keruu onnistuu tämän metodin suorituksen
		// päättyessä.
		final String salasana = k.getSalasana();
		final int id = k.getId();
		
		// jdbc pistää generoidun id:n tänne talteen
		KeyHolder idHolder = new GeneratedKeyHolder();

		// suoritetaan päivitys itse määritellyllä
		// PreparedStatementCreatorilla
		// ja KeyHolderilla
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql,
						new String[] { "id" });
				ps.setString(1, salasana);
				ps.setInt(2, id);
				return ps;
			}
		}, idHolder);

		// tallennetaan id takaisin beaniin, koska
		// kutsujalla pitäisi olla viittaus samaiseen olioon
		//h.setId(idHolder.getKey().intValue()); - Evgenyn korjaus, käyttäjän muokkaus ei toiminut ilman tätä.

	}

}
