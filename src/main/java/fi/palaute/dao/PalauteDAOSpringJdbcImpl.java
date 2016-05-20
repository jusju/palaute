package fi.palaute.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import fi.palaute.bean.PalautteenLinkki;



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

}
