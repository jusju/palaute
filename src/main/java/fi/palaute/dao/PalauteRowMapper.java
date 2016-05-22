package fi.palaute.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.palaute.bean.Palaute;
import fi.palaute.bean.PalauteImpl;

public class PalauteRowMapper implements RowMapper<Palaute> {

	public Palaute mapRow(ResultSet rs, int rowNum) throws SQLException {
		Palaute p = new PalauteImpl();
		p.setPalauteID(rs.getInt("palauteID"));
		p.setToteutusID(rs.getInt("toteutusID"));
		p.setVastaaja(rs.getString("vastaaja"));
		p.setVahvistettu(rs.getBoolean("vahvistus"));
		p.setTimestamp(rs.getString("timestamp"));
		
		return p;
	}

}