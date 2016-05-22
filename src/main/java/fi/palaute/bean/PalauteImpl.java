package fi.palaute.bean;

import java.util.ArrayList;
import java.util.List;


public class PalauteImpl implements Palaute {
	
	private int palauteID, toteutusID;
	private String vastaaja;
	private boolean vahvistettu;
	private String timestamp;
	private List<Vastaus> vastaukset;

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
	public boolean isVahvistettu() {
		return vahvistettu;
	}
	public void setVahvistettu(boolean vahvistettu) {
		this.vahvistettu = vahvistettu;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public List<Vastaus> getVastaukset() {
		return vastaukset;
	}
	public void setVastaukset(List<Vastaus> vastaukset) {
		this.vastaukset = vastaukset;
	}
	@Override
	public String toString() {
		return "PalauteImpl [palauteID=" + palauteID + ", toteutusID="
				+ toteutusID + ", vastaaja=" + vastaaja + ", vahvistettu="
				+ vahvistettu + ", timestamp=" + timestamp + ", vastaukset="
				+ vastaukset + "]";
	}
	
	
	

}
