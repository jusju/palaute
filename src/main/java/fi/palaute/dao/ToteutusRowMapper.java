package fi.palaute.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.palaute.bean.Toteutus;
import fi.palaute.bean.ToteutusImpl;

public class ToteutusRowMapper implements RowMapper<Toteutus> {

	public Toteutus mapRow(ResultSet rs, int rowNum) throws SQLException {
		Toteutus t = new ToteutusImpl();
		t.setToteutusTunnus(rs.getString("toteutusTunnus"));
		t.setToteutusNimi(rs.getString("toteutusNimi"));
		t.setOpettajaNimi(rs.getString("opettajaNimi"));
		t.setToteutusID(rs.getInt("toteutusID"));
		
		return t;
	}

}
