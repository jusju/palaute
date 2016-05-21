package fi.palaute.bean;

public class VastausImpl implements Vastaus {
	
	private int vastausID,kysymysID;
	private String vastausteksti;

	public int getVastausID() {
		return vastausID;
	}
	public void setVastausID(int vastausID) {
		this.vastausID = vastausID;
	}
	public int getKysymysID() {
		return kysymysID;
	}
	public void setKysymysID(int kysymysID) {
		this.kysymysID = kysymysID;
	}
	public String getVastausteksti() {
		return vastausteksti;
	}
	public void setVastausteksti(String vastausteksti) {
		this.vastausteksti = vastausteksti;
	}
	@Override
	public String toString() {
		return "VastausImpl [vastausID=" + vastausID + ", kysymysID="
				+ kysymysID + ", vastausteksti=" + vastausteksti + "]";
	}
	
	

}
