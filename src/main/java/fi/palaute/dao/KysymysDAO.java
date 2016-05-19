package fi.palaute.dao;

import java.util.List;

import fi.palaute.bean.Kysymys;


public interface KysymysDAO {
	
	public abstract List<Kysymys> haeKaikki();
	
	public abstract Kysymys etsi(int kysymysID);


}
