package fi.palaute.bean;

public interface Vastaus {
	
	public abstract int getVastausID();

	public abstract void setVastausID(int vastausID);
	
	public abstract int getKysymysID();

	public abstract void setKysymysID(int kysymysID);

	public abstract String getVastausteksti();

	public abstract void setVastausteksti(String vastausteksti);

}
