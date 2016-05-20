package fi.palaute.dao;

import java.util.List;

import fi.palaute.bean.PalautteenLinkki;

public interface PalauteDAO {
	
	public abstract void talletaLinkki (PalautteenLinkki pl);
	
	public abstract List<PalautteenLinkki> haeKaikkiLinkit();

}
