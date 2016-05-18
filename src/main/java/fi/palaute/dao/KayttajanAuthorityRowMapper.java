package fi.palaute.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.palaute.bean.KayttajanAuthority;
import fi.palaute.bean.KayttajanAuthorityImpl;



	
	public class KayttajanAuthorityRowMapper implements RowMapper<KayttajanAuthority> {

		public KayttajanAuthority mapRow(ResultSet rs, int rowNum) throws SQLException {
			KayttajanAuthority k = new KayttajanAuthorityImpl();

			k.setKaytID(rs.getInt("kayttaja_id"));
			k.setAuthID(rs.getInt("authority_id"));
			
			return k;
		}
	

}