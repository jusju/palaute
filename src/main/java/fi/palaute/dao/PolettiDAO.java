package fi.palaute.dao;

import java.util.List;

import fi.palaute.bean.Poletti;

public interface PolettiDAO {
	
	public abstract void tallenna (Poletti poletti);
	
	public abstract List<Poletti> haeKaikki();
	
	public void poistaSatunnainen(String satunnainen);
	
	public void poistaPoletti(int kaytID);

}
