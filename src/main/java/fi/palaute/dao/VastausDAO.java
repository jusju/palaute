package fi.palaute.dao;
import java.util.List;
import fi.palaute.bean.Vastaus;

public interface VastausDAO {
	
	public abstract void talleta(List<Vastaus> vastaukset);

}
