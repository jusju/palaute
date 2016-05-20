package fi.palaute.bean;

public interface PalautteenLinkki {
	
	public abstract int getLinkkiID();

	public abstract void setLinkkiID(int linkkiID);

	public abstract int getToteutusID();

	public abstract void setToteutusID(int toteutusID);
	
	public abstract String getSatunnainen();

	public abstract void setSatunnainen(String satunnainen);
	
	public abstract String getTimestamp();

	public abstract void setTimestamp(String timestamp);


}

