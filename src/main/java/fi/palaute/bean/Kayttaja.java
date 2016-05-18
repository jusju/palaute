package fi.palaute.bean;

public interface Kayttaja {

	public abstract int getId();

	public abstract void setId(int id);
	
	public abstract String getTunnus();

	public abstract void setTunnus(String tunnus);
	
	public abstract String getSalasana();

	public abstract void setSalasana(String salasana);
	
	public abstract String getVertailu();

	public abstract void setVertailu(String vertailu);
	
	

}
