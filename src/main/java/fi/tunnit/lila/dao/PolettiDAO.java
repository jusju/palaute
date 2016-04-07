package fi.tunnit.lila.dao;

import fi.tunnit.lila.bean.Poletti;

public interface PolettiDAO {
	
	public abstract void tallenna (Poletti poletti);
	
	public abstract Poletti etsi (int kaytID);

}
