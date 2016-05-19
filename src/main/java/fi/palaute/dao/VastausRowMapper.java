package fi.palaute.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import fi.palaute.bean.Vastaus;
import fi.palaute.bean.VastausImpl;

public class VastausRowMapper implements RowMapper<Vastaus>{
	
	public Vastaus mapRow(ResultSet rs, int rowNum) throws SQLException {
		Vastaus v = new VastausImpl();
		v.setVastausID(rs.getInt("vastausID"));
		v.setKysymysID(rs.getInt("kysymysID"));
		v.setVastausteksti(rs.getString("vastausteksti"));
		
		
		return v;
	}

}

