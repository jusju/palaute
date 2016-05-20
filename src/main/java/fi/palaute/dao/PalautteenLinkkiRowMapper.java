package fi.palaute.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.palaute.bean.PalautteenLinkki;
import fi.palaute.bean.PalautteenLinkkiImpl;


public class PalautteenLinkkiRowMapper implements RowMapper <PalautteenLinkki> {


	public PalautteenLinkki mapRow(ResultSet rs, int rowNum) throws SQLException {
		PalautteenLinkki p = new PalautteenLinkkiImpl();
		p.setLinkkiID(rs.getInt("linkkiID"));
		p.setToteutusID(rs.getInt("toteutusID"));
		p.setSatunnainen(rs.getString("satunnainen"));
		p.setTimestamp(rs.getString("timestamp"));
		
		return p;
	}

}
