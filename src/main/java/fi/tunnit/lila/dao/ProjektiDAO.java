package fi.tunnit.lila.dao;


import java.util.List;



import fi.tunnit.lila.bean.Projekti;
import fi.tunnit.lila.bean.Tunnit;

public interface ProjektiDAO {

	public abstract List<Projekti> haeKaikki();
	
	public abstract Projekti etsi(int projID);
	
	public abstract void talleta(Projekti projektit);
	
	public Projekti poistaProjekti(int projID);
	
}
