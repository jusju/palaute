package fi.tunnit.lila.bean;

import java.sql.Date;

public class PolettiImpl implements Poletti{
	
	private int id, kaytID;
	private String satunnainen;
	private Date pvm;
	public PolettiImpl() {
		super();
		
	}
	public PolettiImpl(int id, int kaytID, String satunnainen, Date pvm) {
		super();
		this.id = id;
		this.kaytID = kaytID;
		this.satunnainen = satunnainen;
		this.pvm = pvm;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getKaytID() {
		return kaytID;
	}
	public void setKaytID(int kaytID) {
		this.kaytID = kaytID;
	}
	public String getSatunnainen() {
		return satunnainen;
	}
	public void setSatunnainen(String satunnainen) {
		this.satunnainen = satunnainen;
	}
	public Date getPvm() {
		return pvm;
	}
	public void setPvm(Date pvm) {
		this.pvm = pvm;
	}
	@Override
	public String toString() {
		return "PolettiImpl [id=" + id + ", kaytID=" + kaytID
				+ ", satunnainen=" + satunnainen + ", pvm=" + pvm + "]";
	}

	
	

}
