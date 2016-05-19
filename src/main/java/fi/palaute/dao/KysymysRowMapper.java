package fi.palaute.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.palaute.bean.Kysymys;
import fi.palaute.bean.KysymysImpl;

public class KysymysRowMapper implements RowMapper<Kysymys>{
	
	public Kysymys mapRow(ResultSet rs, int rowNum) throws SQLException {
		Kysymys k = new KysymysImpl();
		k.setKysymysID(rs.getInt("kysymysID"));
		k.setKysymysteksti(rs.getString("kysymysteksti"));
		
		
		return k;
	}

}
