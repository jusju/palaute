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
	@SuppressWarnings("deprecation")
	public void talleta(Henkilo h) {
		final String sql = "insert into kayttaja(etunimi, sukunimi, sahkoposti, salasana) values(?,?,?,?)";
		final String auth = "insert into kayttajan_authority(kayttaja_id, authority_id) values(?, 1)";
		final String maxidsql = "select MAX(kaytID) AS kaytID FROM kayttaja";

		
		// anonyymi sisäluokka tarvitsee vakioina välitettävät arvot,
		// jotta roskien keruu onnistuu tämän metodin suorituksen
		// päättyessä.
		final String etunimi = h.getEtunimi();
		final String sukunimi = h.getSukunimi();
		final String sposti = h.getSposti();
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
				ps.setString(1, etunimi);
				ps.setString(2, sukunimi);
				ps.setString(3, sposti);
				ps.setString(4, salasana);
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
	
	/* TRANSAKTION
	 * 
    TransactionDefinition def = new DefaultTransactionDefinition();
    TransactionStatus status = transactionManager.getTransaction(def);
    
	// anonyymi sisäluokka tarvitsee vakioina välitettävät arvot,
	// jotta roskien keruu onnistuu tämän metodin suorituksen
	// päättyessä.
	final String etunimi = h.getEtunimi();
	final String sukunimi = h.getSukunimi();
	final String sposti = h.getSposti();
	final String salasana = h.getSalasana();

	// jdbc pistää generoidun id:n tänne talteen
	KeyHolder idHolder = new GeneratedKeyHolder();
	
	try {
		
		final String sql = "insert into kayttaja(etunimi, sukunimi, sahkoposti, salasana) values(?,?,?,?)";
		
		// suoritetaan päivitys itse määritellyllä
		// PreparedStatementCreatorilla
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
		
		//etsimme viimmeinen id
		final String maxidsql = "select MAX(kaytID) AS kaytID FROM kayttaja";
		final int i;
		i = jdbcTemplate.queryForInt(maxidsql);
		
		//lisätään auth_rooli viimmeselle käyttäjälle
		final String auth = "insert into kayttajan_authority(kayttaja_id, authority_id) values(?, 1)";
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(auth);
				ps.setInt(1, i);
				return ps;
			}
		});
		transactionManager.commit(status);
	
	} catch (Exception e) {
         System.out.println("Error in creating record, rolling back");
         transactionManager.rollback(status);
         throw e;
	}

	// tallennetaan id takaisin beaniin, koska
	// kutsujalla pitäisi olla viittaus samaiseen olioon
	h.setId(idHolder.getKey().intValue());
	 */
	public void muokkaa(Henkilo h) {
		final String sql = "update kayttaja set etunimi=?, sukunimi=?, sahkoposti=?, salasana=? where kaytID=?";
	

		// anonyymi sisäluokka tarvitsee vakioina välitettävät arvot,
		// jotta roskien keruu onnistuu tämän metodin suorituksen
		// päättyessä.
		final String etunimi = h.getEtunimi();
		final String sukunimi = h.getSukunimi();
		final String sposti = h.getSposti();
		final String salasana = h.getSalasana();
		final int id = h.getId();
		
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
				ps.setString(1, etunimi);
				ps.setString(2, sukunimi);
				ps.setString(3, sposti);
				ps.setString(4, salasana);
				ps.setInt(5, id);
				return ps;
			}
		}, idHolder);

		// tallennetaan id takaisin beaniin, koska
		// kutsujalla pitäisi olla viittaus samaiseen olioon
		//h.setId(idHolder.getKey().intValue()); - Evgenyn korjaus, käyttäjän muokkaus ei toiminut ilman tätä.

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
	
	public Henkilo etsiSposti(String sposti) {
		String sql = "select kaytID,etunimi,sukunimi,sahkoposti,salasana from kayttaja where sahkoposti = ?";
		Object[] parametrit = new Object[] { sposti };
		RowMapper<Henkilo> mapper = new HenkiloRowMapper();

		Henkilo h;
		try {
			h = jdbcTemplate.queryForObject(sql, parametrit, mapper);
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}
		return h;

	}

	public void poistaHenkilo(int id) {
		final String sql = "DELETE FROM kayttaja WHERE kaytID = ?";

		try {
		jdbcTemplate.update(sql, id);
		
				
		} catch (IncorrectResultSizeDataAccessException e) {
			throw new HenkiloaEiLoydyPoikkeus(e);
		}


	}
	
	public void poistaHenkilonAuth(int id) {
		final String sqlAuth ="DELETE FROM kayttajan_authority WHERE kayttaja_id = ?";

		try {
		jdbcTemplate.update(sqlAuth, id);
				
		} catch (IncorrectResultSizeDataAccessException e) {
			throw new HenkiloaEiLoydyPoikkeus(e);
		}


	}
	
	public void poistaHenkilonPoletti(int id) {
		final String sql ="DELETE FROM poletti WHERE kaytID = ?";

		try {
		jdbcTemplate.update(sql, id);
				
		} catch (IncorrectResultSizeDataAccessException e) {
			throw new HenkiloaEiLoydyPoikkeus(e);
		}


	}
	
	

	public List<Henkilo> haeKaikki() {

		String sql = "select kaytID,etunimi,sukunimi,sahkoposti,salasana from kayttaja";
		RowMapper<Henkilo> mapper = new HenkiloRowMapper();
		List<Henkilo> henkilot = jdbcTemplate.query(sql, mapper);

		return henkilot;

	}

}
