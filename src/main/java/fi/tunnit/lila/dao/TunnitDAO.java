package fi.tunnit.lila.dao;
import fi.tunnit.lila.bean.Tunnit;

import java.util.List;
public interface TunnitDAO {

	public abstract List<Tunnit> haeTunnit();
	
	
	public abstract List<Tunnit> etsi(int kaytID);
	
	public abstract void talleta(Tunnit tunnit);
	
}
