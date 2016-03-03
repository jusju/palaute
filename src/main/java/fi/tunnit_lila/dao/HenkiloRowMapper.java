package fi.tunnit_lila.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.tunnit_lila.bean.Henkilo;
import fi.tunnit_lila.bean.HenkiloImpl;



public class HenkiloRowMapper implements RowMapper<Henkilo> {

	public Henkilo mapRow(ResultSet rs, int rowNum) throws SQLException {
		Henkilo h = new HenkiloImpl();
		h.setEtunimi(rs.getString("etunimi"));
		h.setSukunimi(rs.getString("sukunimi"));
		h.setSposti(rs.getString("sposti"));
		h.setSalasana(rs.getString("salasana"));
		h.setId(rs.getInt("id"));
		
		return h;
	}

}
