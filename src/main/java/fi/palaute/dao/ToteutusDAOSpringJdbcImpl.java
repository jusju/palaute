package fi.palaute.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import fi.palaute.bean.Toteutus;

@Repository

public class ToteutusDAOSpringJdbcImpl implements ToteutusDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void insertBatch(ArrayList<Toteutus> toteutukset) {
		final String sql = "insert into toteutus(toteutusTunnus, toteutusNimi, opettajaNimi) values(?,?,?)";
	    
	    String username = "root";
	    String password = "root";
	    String url = "jdbc:mysql://localhost:3306/palaute";
	   
	    Connection yhteys = null;
	    try {
	    Class.forName("com.mysql.jdbc.Driver");

	    yhteys = DriverManager.getConnection(url, username, password);
	    
	    System.out.println("Listassa " + toteutukset.size() + " kurssia");
	    
	    PreparedStatement ps = yhteys.prepareStatement(sql);
	    
	    for (int i = 0; i < toteutukset.size(); i++) {
	     ps.setString(1, toteutukset.get(i).getToteutusTunnus());
	     ps.setString(2, toteutukset.get(i).getToteutusNimi());
	     ps.setString(3, toteutukset.get(i).getOpettajaNimi());
	     ps.addBatch();
	    }
	    
	    ps.executeBatch();
	    
	    yhteys.commit();
	    
	    yhteys.close();
	    

	   } catch (Exception e) {
	    // Virheet
	    System.out.println("Tietokantayhteyden avauksessa tapahtui virhe");
	    e.printStackTrace();
	   }

	 }


	public List<Toteutus> haeKaikki() {

		String sql = "select toteutusID, toteutusTunnus,toteutusNimi,opettajaNimi from toteutus";
		RowMapper<Toteutus> mapper = new ToteutusRowMapper();
		List<Toteutus> toteutukset = jdbcTemplate.query(sql, mapper);

		return toteutukset;

	}
	
	public Toteutus etsi(int id) {
		String sql = "select toteutusID, toteutusTunnus,toteutusNimi,opettajaNimi from toteutus where toteutusID = ?";
		Object[] parametrit = new Object[] { id };
		RowMapper<Toteutus> mapper = new ToteutusRowMapper();

		Toteutus t;
		try {
			t = jdbcTemplate.queryForObject(sql, parametrit, mapper);
		} catch (IncorrectResultSizeDataAccessException e) {
			throw new HenkiloaEiLoydyPoikkeus(e);
		}
		return t;

	}
	
	
}
