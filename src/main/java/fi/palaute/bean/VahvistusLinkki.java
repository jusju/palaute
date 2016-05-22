package fi.palaute.bean;

public interface VahvistusLinkki {
	
	public abstract int getVahvistusID();

	public abstract void setVahvistusID(int vahvistusID);

	public abstract int getPalauteID();

	public abstract void setPalauteID(int palauteID);
	
	public abstract String getSatunnainen();

	public abstract void setSatunnainen(String satunnainen);
	


}