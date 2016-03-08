package fi.tunnit.lila.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.tunnit.lila.bean.Tunnit;
import fi.tunnit.lila.bean.TunnitImpl;



	
	public class TunnitRowMapper implements RowMapper<Tunnit> {

		public Tunnit mapRow(ResultSet rs, int rowNum) throws SQLException {
			Tunnit t = new TunnitImpl();
			t.setDate(rs.getString("date"));
			t.setAloitusaika(rs.getString("aloitusaika"));
			t.setLopetusaika(rs.getString("lopetusaika"));
			t.setKuvaus(rs.getString("kuvaus"));
			t.setTuntiID(rs.getInt("tuntiID"));
			t.setKaytID(rs.getInt("kaytID"));
			t.setProjID(rs.getInt("projID"));
			
			return t;
		}
	

}