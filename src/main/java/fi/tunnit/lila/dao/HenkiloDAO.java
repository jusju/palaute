package fi.tunnit.lila.dao;

import java.util.List;

import fi.tunnit.lila.bean.Henkilo;



public interface HenkiloDAO {

	public abstract void talleta(Henkilo henkilo);
	
	public abstract void muokkaa(Henkilo henkilo);

	public abstract Henkilo etsi(int id);

	public abstract List<Henkilo> haeKaikki();

	public void poistaHenkilo(int id);
}