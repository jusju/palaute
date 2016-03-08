package fi.tunnit.lila.dao;
import fi.tunnit.lila.bean.Tunnit;
import java.util.List;
public interface TunnitDAO {

	public abstract List<Tunnit> haeTunnit();
	
	public abstract Tunnit etsi(int kaytID);
	
}
