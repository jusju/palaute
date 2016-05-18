package fi.palaute.dao;

import java.util.List;

import fi.palaute.bean.Kayttaja;



public interface KayttajaDAO {

	public abstract void talleta(Kayttaja kayttaja);
	
	public abstract void uusiSalasana(Kayttaja kayttaja);
	
	public abstract Kayttaja etsi(int id);
	
	public abstract Kayttaja etsiSposti(String sposti);

	public abstract List<Kayttaja> haeKaikki();
	
}