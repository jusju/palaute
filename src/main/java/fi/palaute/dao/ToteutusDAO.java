package fi.palaute.dao;

import java.util.List;

import fi.palaute.bean.Toteutus;

public interface ToteutusDAO {
	
	public abstract void insertBatch(List<Toteutus> toteutukset);
	
	public abstract List<Toteutus> haeKaikki();
	
	public abstract Toteutus etsi(int id);

}