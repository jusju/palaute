package fi.palaute.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

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
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void insertBatch(List<Toteutus> toteutukset) {
		final String sql = "insert into toteutus(toteutusTunnus, toteutusNimi, opettajaNimi) values(?,?,?)";
		
	    getJdbcTemplate().batchUpdate(sql,
	            new BatchPreparedStatementSetter() {
	                @Override
	                public void setValues(PreparedStatement ps, int i)
	                        throws SQLException {
	                    Toteutus toteutus = toteutukset.get(i);
	                    ps.setString(1, toteutus.getToteutusTunnus());
	                    ps.setString(2, toteutus.getToteutusNimi());
	                    ps.setString(3, toteutus.getOpettajaNimi());

	                }

	                @Override
	                public int getBatchSize() {
	                    return toteutukset.size();
	                }
	            });

	 }


	public List<Toteutus> haeKaikki() {

		String sql = "select toteutusID, toteutusTunnus,toteutusNimi,opettajaNimi from toteutus";
		RowMapper<Toteutus> mapper = new ToteutusRowMapper();
		List<Toteutus> toteutukset = jdbcTemplate.query(sql, mapper);

		return toteutukset;

	}
	
	public Toteutus etsi(int id) {
		String sql = "select toteutusID, toteutusTunnus,toteutusNimi,opettajaNimi from toteutus where toteutusID = ?";
		Object[] parametrit = new Object[] { id };
		RowMapper<Toteutus> mapper = new ToteutusRowMapper();

		Toteutus t;
		try {
			t = jdbcTemplate.queryForObject(sql, parametrit, mapper);
		} catch (IncorrectResultSizeDataAccessException e) {
			throw new HenkiloaEiLoydyPoikkeus(e);
		}
		return t;

	}
	
	
}
