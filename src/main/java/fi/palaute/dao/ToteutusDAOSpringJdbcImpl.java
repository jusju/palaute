package fi.palaute.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;



import fi.palaute.bean.Toteutus;


@Repository

public class ToteutusDAOSpringJdbcImpl implements ToteutusDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;


	
	public void insertBatch(final List<Toteutus> toteutukset) {
		final String sql = "insert into toteutus(toteutusTunnus, toteutusNimi, opettajaNimi) values(?,?,?)";

		for(int i=0; i<toteutukset.size();i++){
			System.out.println(toteutukset.get(i).getToteutusTunnus());
		}
		
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter(){

	        @Override
	        public void setValues(PreparedStatement ps, int i)
	            throws SQLException {

	            Toteutus t = toteutukset.get(i);
	            ps.setString(1, t.getToteutusTunnus());
	            ps.setString(2, t.getToteutusNimi());
	            ps.setString(3, t.getOpettajaNimi());

	        }

	        @Override
	        public int getBatchSize() {
	            return toteutukset.size();
	        }
	    });


	}
}
