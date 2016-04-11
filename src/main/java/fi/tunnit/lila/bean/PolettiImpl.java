package fi.tunnit.lila.bean;

import java.sql.Date;

public class PolettiImpl implements Poletti{
	
	private int polettiID, kaytID;
	private String satunnainen;
	private String pvm;
	public PolettiImpl() {
		super();
		
	}
	public PolettiImpl(int polettiID, int kaytID, String satunnainen, String pvm) {
		super();
		this.polettiID = polettiID;
		this.kaytID = kaytID;
		this.satunnainen = satunnainen;
		this.pvm = pvm;
	}
	public int getPolettiID() {
		return polettiID;
	}
	public void setPolettiID(int polettiID) {
		this.polettiID = polettiID;
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
	public String getPvm() {
		return pvm;
	}
	public void setPvm(String pvm) {
		this.pvm = pvm;
	}
	@Override
	public String toString() {
		return "PolettiImpl [polettiID=" + polettiID + ", kaytID=" + kaytID
				+ ", satunnainen=" + satunnainen + ", pvm=" + pvm + "]";
	}
	
	
	
	

	
	

}
