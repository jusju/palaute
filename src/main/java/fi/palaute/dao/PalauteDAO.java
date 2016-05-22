package fi.palaute.dao;

import java.util.ArrayList;
import java.util.List;

import fi.palaute.bean.Palaute;
import fi.palaute.bean.PalautteenLinkki;
import fi.palaute.bean.PalautteenVastaukset;
import fi.palaute.bean.VahvistusLinkki;
import fi.palaute.bean.Vastaus;

public interface PalauteDAO {
	
	public abstract void talletaLinkki (PalautteenLinkki pl);
	
	public abstract List<PalautteenLinkki> haeKaikkiLinkit();
	
	public void talleta(Palaute palaute);
	
	public Palaute etsiPalaute(int id);
	
	public void insertVastaukset(ArrayList<Vastaus> vastaukset);
	
	public void talletaPalautteenVastaukset(int palauteID, int vastausID);
	
	public List<Palaute> haeVahvistetut();
	
	public void setVahvistus(Palaute p);
	
	public void talletaVahvistusLinkki(VahvistusLinkki vl);
	
	public List<VahvistusLinkki> haeKaikkiVahvistukset();
	
	public void poistaVahvistus(String satunnainen);
	
	public List<PalautteenVastaukset> haeKaikkiPalautteenVastaukset();

}
