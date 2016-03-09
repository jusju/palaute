package fi.tunnit.lila.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;



import fi.tunnit.lila.bean.Projekti;
import fi.tunnit.lila.bean.ProjektiImpl;

public class ProjektiRowMapper implements RowMapper<Projekti>{


	public Projekti mapRow(ResultSet rs, int rowNum) throws SQLException {
		Projekti p = new ProjektiImpl();
		p.setProjnimi(rs.getString("projnimi"));
		p.setProjID(rs.getInt("projID"));
		
		return p;
	}
}