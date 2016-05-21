package fi.palaute.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import fi.palaute.bean.Palaute;
import fi.palaute.bean.PalautteenLinkki;
import fi.palaute.bean.Toteutus;
import fi.palaute.bean.Vastaus;



@Repository
public class PalauteDAOSpringJdbcImpl implements PalauteDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void talletaLinkki(PalautteenLinkki pl) {
		final String sql = "insert into palautteen_linkki(toteutusID, satunnainen) values(?,?)";

		
		final int toteutusID = pl.getToteutusID();
		final String satunnainen = pl.getSatunnainen();
	
		KeyHolder idHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql,
						new String[] { "id" });
				ps.setInt(1, toteutusID);
				ps.setString(2, satunnainen);
				return ps;
			}
		}, idHolder);


		pl.setLinkkiID(idHolder.getKey().intValue());

	}
	
	public List<PalautteenLinkki> haeKaikkiLinkit() {

		String sql = "select linkkiID, toteutusID, satunnainen, timestamp from palautteen_linkki";
		RowMapper<PalautteenLinkki> mapper = new PalautteenLinkkiRowMapper();
		List<PalautteenLinkki> pl = jdbcTemplate.query(sql, mapper);

		return pl;

	}
	
	public void talleta(Palaute palaute) {
		final String p = "insert into palaute(toteutusID, vastaaja) values(?,?)";
		final String v = "insert into vastaus(kysymysID, vastausteksti)values(?,?)";
		final String pv = "insert into palautteen_vastaukset(palauteID, vastausID) values(?,?)";

		
		final int toteutusID = palaute.getToteutusID();
		final String vastaaja = palaute.getVastaaja();
	
		KeyHolder idHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(p,
						new String[] { "id" });
				ps.setInt(1, toteutusID);
				ps.setString(2, vastaaja);
				return ps;
			}
		}, idHolder);


		palaute.setPalauteID(idHolder.getKey().intValue());
		

	}
	
	public void insertVastaukset(ArrayList<Vastaus> vastaukset) {
		final String sql = "insert into vastaus(kysymysID, vastausteksti)values(?,?)";
	    
	    String username = "root";
	    String password = "root";
	    String url = "jdbc:mysql://localhost:3306/palaute";
	   
	    Connection yhteys = null;
	    try {
	    Class.forName("com.mysql.jdbc.Driver");

	    yhteys = DriverManager.getConnection(url, username, password);
	    
	    System.out.println("Listassa " + vastaukset.size() + " kurssia");
	    
	    PreparedStatement ps = yhteys.prepareStatement(sql);
	    
	    for (int i = 0; i < vastaukset.size(); i++) {
	     ps.setInt(1, vastaukset.get(i).getKysymysID());
	     ps.setString(2, vastaukset.get(i).getVastausteksti());
	     ps.addBatch();
	    }
	    
	    ps.executeBatch();
	    
	    int maxVastausID = 0;
	    int maxPalautusID = 0;
        
        try {
        	
            ps = yhteys.prepareStatement("select MAX(vastausID) AS maxV FROM vastaus;");
         
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                maxVastausID = rs.getInt("maxV");
                
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }  
        
        try {
        	
            ps = yhteys.prepareStatement("select MAX(palauteID) AS maxP FROM palaute;");
         
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                maxPalautusID = rs.getInt("maxP");
                
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } 
	    
        talletaPalautteenVastaukset(maxPalautusID, maxVastausID);
	    

	   } catch (Exception e) {
	    // Virheet
	    System.out.println("Tietokantayhteyden avauksessa tapahtui virhe");
	    e.printStackTrace();
	   }
	    
}
	
	public void talletaPalautteenVastaukset(int palauteID, int vastausID) {
		final String pv = "insert into palautteen_vastaukset(palauteID, vastausID) values(?,?)";
		
	    String username = "root";
	    String password = "root";
	    String url = "jdbc:mysql://localhost:3306/palaute";
	   
	    Connection yhteys = null;
	    try {
	    Class.forName("com.mysql.jdbc.Driver");

	    yhteys = DriverManager.getConnection(url, username, password);
	    
	    ArrayList<Integer> vastausIDT = new ArrayList<Integer>();
	    for(int i=vastausID; i>0;i--){
	    vastausIDT.add(i);
	    }
	    PreparedStatement ps = yhteys.prepareStatement(pv);
	    
	    for (int i = 0; i < vastausIDT.size(); i++) {
	     ps.setInt(1, palauteID);
	     ps.setInt(2, vastausIDT.get(i).intValue());
	     ps.addBatch();
	    }
	    
	    ps.executeBatch();
	    
	    yhteys.close();
	    

	   } catch (Exception e) {
	    // Virheet
	    System.out.println("Tietokantayhteyden avauksessa tapahtui virhe");
	    e.printStackTrace();
	   }

	}

}
