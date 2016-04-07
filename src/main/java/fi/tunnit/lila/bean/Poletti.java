package fi.tunnit.lila.bean;

import java.sql.Date;

public interface Poletti {

	
	public abstract int getId();

	public abstract void setId(int id);
	
	public abstract int getKaytID();

	public abstract void setKaytID(int kaytID);
	
	public abstract String getSatunnainen();

	public abstract void setSatunnainen(String satunnainen);
	
	public abstract Date getPvm();

	public abstract void setPvm(Date pvm);
}
