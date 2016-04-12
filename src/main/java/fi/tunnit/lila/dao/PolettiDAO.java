package fi.tunnit.lila.dao;

import java.util.List;

import fi.tunnit.lila.bean.Henkilo;
import fi.tunnit.lila.bean.Poletti;

public interface PolettiDAO {
	
	public abstract void tallenna (Poletti poletti);
	
	public abstract Poletti etsi (int kaytID);
	
	public abstract Poletti etsiSatunnainen (String satunnainen);
	
	public abstract List<Poletti> etsiS (String satunnainen);
	
	public abstract List<Poletti> haeKaikki();
	
	public void poistaSatunnainen(String satunnainen);
	public void poistaPoletti(int kaytID);

}
