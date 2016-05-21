package fi.palaute.dao;

import java.util.ArrayList;
import java.util.List;

import fi.palaute.bean.Palaute;
import fi.palaute.bean.PalautteenLinkki;
import fi.palaute.bean.Vastaus;

public interface PalauteDAO {
	
	public abstract void talletaLinkki (PalautteenLinkki pl);
	
	public abstract List<PalautteenLinkki> haeKaikkiLinkit();
	
	public void talleta(Palaute palaute);
	
	public void insertVastaukset(ArrayList<Vastaus> vastaukset);
	
	public void talletaPalautteenVastaukset(int palauteID, int vastausID);

}
