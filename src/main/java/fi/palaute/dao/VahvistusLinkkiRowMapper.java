package fi.palaute.dao;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.palaute.bean.VahvistusLinkki;
import fi.palaute.bean.VahvistusLinkkiImpl;


public class VahvistusLinkkiRowMapper implements RowMapper <VahvistusLinkki> {


	public VahvistusLinkki mapRow(ResultSet rs, int rowNum) throws SQLException {
		VahvistusLinkki v = new VahvistusLinkkiImpl();
		v.setVahvistusID(rs.getInt("vahvistusID"));
		v.setPalauteID(rs.getInt("palauteID"));
		v.setSatunnainen(rs.getString("satunnainen"));
		
		return v;
	}

}