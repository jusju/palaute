package fi.palaute.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.palaute.bean.PalautteenVastaukset;
import fi.palaute.bean.PalautteenVastauksetImpl;



public class PalautteenVastauksetRowMapper implements RowMapper <PalautteenVastaukset> {


	public PalautteenVastaukset mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		PalautteenVastaukset pv = new PalautteenVastauksetImpl();
		pv.setPalauteID(rs.getInt("palauteID"));
		pv.setVastausID(rs.getInt("vastausID"));
		
		return pv;
	}

}