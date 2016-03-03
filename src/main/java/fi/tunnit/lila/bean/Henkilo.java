package fi.tunnit.lila.bean;

public interface Henkilo {

	public abstract int getId();

	public abstract void setId(int id);

	public abstract String getEtunimi();

	public abstract void setEtunimi(String etunimi);

	public abstract String getSukunimi();

	public abstract void setSukunimi(String sukunimi);
	
	public abstract String getSposti();

	public abstract void setSposti(String sposti);
	
	public abstract String getSalasana();

	public abstract void setSalasana(String sukunimi);

}