package fi.palaute.bean;

import java.sql.Date;

public class PalauteImpl implements Palaute {
	
	private int palauteID, toteutusID;
	private String vastaaja;
	private boolean vastattu;
	private Date timestamp;
	public PalauteImpl() {
		super();
		
	}
	public PalauteImpl(int palauteID, int toteutusID, String vastaaja,
			boolean vastattu, Date timestamp) {
		super();
		this.palauteID = palauteID;
		this.toteutusID = toteutusID;
		this.vastaaja = vastaaja;
		this.vastattu = vastattu;
		this.timestamp = timestamp;
	}
	public int getPalauteID() {
		return palauteID;
	}
	public void setPalauteID(int palauteID) {
		this.palauteID = palauteID;
	}
	public int getToteutusID() {
		return toteutusID;
	}
	public void setToteutusID(int toteutusID) {
		this.toteutusID = toteutusID;
	}
	public String getVastaaja() {
		return vastaaja;
	}
	public void setVastaaja(String vastaaja) {
		this.vastaaja = vastaaja;
	}
	public boolean isVastattu() {
		return vastattu;
	}
	public void setVastattu(boolean vastattu) {
		this.vastattu = vastattu;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "PalauteImpl [palauteID=" + palauteID + ", toteutusID="
				+ toteutusID + ", vastaaja=" + vastaaja + ", vastattu="
				+ vastattu + ", timestamp=" + timestamp + "]";
	}
	
	
	

}
