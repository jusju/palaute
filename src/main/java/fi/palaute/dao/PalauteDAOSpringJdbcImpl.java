package fi.palaute.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;







import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import fi.palaute.bean.Palaute;
import fi.palaute.bean.PalautteenLinkki;
import fi.palaute.bean.PalautteenVastaukset;
import fi.palaute.bean.PalautteenVastauksetImpl;
import fi.palaute.bean.VahvistusLinkki;
import fi.palaute.bean.Vastaus;
import fi.palaute.bean.VastausImpl;
import fi.palaute.dao.HenkiloaEiLoydyPoikkeus;



@Repository
public class PalauteDAOSpringJdbcImpl implements PalauteDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
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
	
	public void insertVastaukset(List<Vastaus> vastaukset) {
	    final String sql = "insert into vastaus (kysymysID, vastausteksti) values(?,?)";
	    getJdbcTemplate().batchUpdate(sql,
	            new BatchPreparedStatementSetter() {
	                @Override
	                public void setValues(PreparedStatement ps, int i)
	                        throws SQLException {
	                    Vastaus vastaus = vastaukset.get(i);
	                    ps.setInt(1, vastaus.getKysymysID());
	                    ps.setString(2, vastaus.getVastausteksti());

	                }

	                @Override
	                public int getBatchSize() {
	                    return vastaukset.size();
	                }
	            });

	}
	
	public void talletaPalautteenVastaukset(int palauteID) {
		
		final String pv = "insert into palautteen_vastaukset(palauteID, vastausID) values(?,?)";
		
	    String lastID = "select MAX(vastausID) FROM vastaus";
	    int lastVastaus = jdbcTemplate.queryForInt(lastID);
	    System.out.println(palauteID +" "+lastVastaus);
	    

	    List<PalautteenVastaukset> palvastaukset = new ArrayList<PalautteenVastaukset>();
	    for(int i=lastVastaus; i>0;i--){
		PalautteenVastaukset palvast = new PalautteenVastauksetImpl();
	    palvast.setPalauteID(palauteID);
	    palvast.setVastausID(i);
	    palvastaukset.add(palvast);
	    }
	    
	    getJdbcTemplate().batchUpdate(pv,
	            new BatchPreparedStatementSetter() {
	                @Override
	                public void setValues(PreparedStatement ps, int i)
	                        throws SQLException {
	                	
	                    ps.setInt(1, palvastaukset.get(i).getPalauteID());
	                    ps.setInt(2, palvastaukset.get(i).getVastausID());

	                }

	                @Override
	                public int getBatchSize() {
	                    return palvastaukset.size();
	                }
	            });


	}
	
	public Palaute etsiPalaute(int id) {
		String sql = "select palauteID,toteutusID,vastaaja,vahvistus,timestamp from palaute where palauteID = ?";
		Object[] parametrit = new Object[] { id };
		RowMapper<Palaute> mapper = new PalauteRowMapper();

		Palaute p;
		try {
			p = jdbcTemplate.queryForObject(sql, parametrit, mapper);
		} catch (IncorrectResultSizeDataAccessException e) {
			throw new HenkiloaEiLoydyPoikkeus(e);
		}
		return p;

	}
	
	public List<Palaute> haeVahvistetut() {
		String sql = "select palauteID,toteutusID,vastaaja,vahvistus,timestamp from palaute where vahvistus=1";
		RowMapper<Palaute> mapper = new PalauteRowMapper();
		List<Palaute> palautteet = jdbcTemplate.query(sql, mapper);
		return palautteet;

	}
	
	public void setVahvistus(Palaute p) {
		final String sql = "update palaute set vahvistus=1 where palauteID=?";
		//Ei mitään parametria päivitetä vahvistu 1 on kovasti kodattu
		final int id = p.getPalauteID();

		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql,
						new String[] { "id" });
				ps.setInt(1, id);
				return ps;
			}
		});
	}
	
	public void talletaVahvistusLinkki(VahvistusLinkki vl) {
		final String sql = "insert into vahvistus_linkki(palauteID, satunnainen) values(?,?)";

		
		final int palauteID = vl.getPalauteID();
		final String satunnainen = vl.getSatunnainen();
	
		KeyHolder idHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql,
						new String[] { "id" });
				ps.setInt(1, palauteID);
				ps.setString(2, satunnainen);
				return ps;
			}
		}, idHolder);


		vl.setVahvistusID(idHolder.getKey().intValue());

	}
	
	public List<VahvistusLinkki> haeKaikkiVahvistukset() {

		String sql = "select vahvistusID, palauteID, satunnainen from vahvistus_linkki";
		RowMapper<VahvistusLinkki> mapper = new VahvistusLinkkiRowMapper();
		List<VahvistusLinkki> vl = jdbcTemplate.query(sql, mapper);

		return vl;

	}
	
	public void poistaVahvistus(String satunnainen){
		final String sql = "DELETE FROM vahvistus_linkki WHERE satunnainen = ?";

		try {
		jdbcTemplate.update(sql, satunnainen);
		} catch (IncorrectResultSizeDataAccessException e) {
			throw new HenkiloaEiLoydyPoikkeus(e);
		}
		
	}
	
	public List<PalautteenVastaukset> haeKaikkiPalautteenVastaukset() {

		String sql = "select palauteID, vastausID from palautteen_vastaukset";
		RowMapper<PalautteenVastaukset> mapper = new PalautteenVastauksetRowMapper();
		List<PalautteenVastaukset> pv = jdbcTemplate.query(sql, mapper);

		return pv;

	}

}
