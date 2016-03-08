package fi.tunnit.lila.bean;

public interface Tunnit {
	
	
	public abstract int getTuntiID();

	public abstract void setTuntiID(int tuntiID);

	public abstract int getKaytID();

	public abstract void setKaytID(int kaytID);

	public abstract int getProjID();

	public abstract void setProjID(int projID);
	
	public abstract String getDate();

	public abstract void setDate(String date);
	
	public abstract String getAloitusaika();

	public abstract void setAloitusaika(String aloitusaika);
	
	public abstract String getLopetusaika();

	public abstract void setLopetusaika(String lopetusaika);
	
	public abstract String getKuvaus();

	public abstract void setKuvaus(String kuvaus);

}
