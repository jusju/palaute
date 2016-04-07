package fi.tunnit.lila.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.tunnit.lila.bean.Poletti;
import fi.tunnit.lila.bean.PolettiImpl;

public class PolettiRowMapper implements RowMapper <Poletti> {


	public Poletti mapRow(ResultSet rs, int rowNum) throws SQLException {
		Poletti p = new PolettiImpl();
		p.setId(rs.getInt("polettiID"));
		p.setKaytID(rs.getInt("kaytID"));
		p.setSatunnainen(rs.getString("satunnainen"));
		p.setPvm(rs.getDate("vanhenemispvm"));
		
		return p;
	}

}
