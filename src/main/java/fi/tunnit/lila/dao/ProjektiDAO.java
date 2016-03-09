package fi.tunnit.lila.dao;


import java.util.List;


import fi.tunnit.lila.bean.Projekti;

public interface ProjektiDAO {

	public abstract List<Projekti> haeKaikki();
	public abstract Projekti etsi(int projID);
}
