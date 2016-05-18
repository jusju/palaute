package fi.palaute.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.palaute.bean.Kayttaja;
import fi.palaute.bean.KayttajaImpl;



public class KayttajaRowMapper implements RowMapper<Kayttaja> {

	public Kayttaja mapRow(ResultSet rs, int rowNum) throws SQLException {
		Kayttaja h = new KayttajaImpl();
		h.setTunnus(rs.getString("sahkoposti"));
		h.setSalasana(rs.getString("salasana"));
		h.setId(rs.getInt("kaytID"));
		
		return h;
	}

}
