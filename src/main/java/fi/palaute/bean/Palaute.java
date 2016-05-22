package fi.palaute.bean;

import java.util.ArrayList;
import java.util.List;

public interface Palaute {
	
	public abstract int getPalauteID();

	public abstract void setPalauteID(int palauteID);
	
	public abstract int getToteutusID();

	public abstract void setToteutusID(int toteutusID);
	
	public abstract String getVastaaja();

	public abstract void setVastaaja(String vastaaja);
	
	public abstract boolean isVahvistettu();

	public abstract void setVahvistettu(boolean vahvistettu);
	
	public abstract String getTimestamp();

	public abstract void setTimestamp(String timestamp);
	
	public abstract List<Vastaus> getVastaukset();
	
	public abstract void setVastaukset(List<Vastaus> vastaukset);


}
