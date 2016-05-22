package fi.palaute.bean;

public class PalautteenVastauksetImpl implements PalautteenVastaukset {

	private int palauteID;
	private int vastausID;
	
	public int getPalauteID() {
		return palauteID;
	}
	public void setPalauteID(int palauteID) {
		this.palauteID = palauteID;
	}
	public int getVastausID() {
		return vastausID;
	}
	public void setVastausID(int vastausID) {
		this.vastausID = vastausID;
	}
	@Override
	public String toString() {
		return "PalautteetnVastauksetImpl [palauteID=" + palauteID
				+ ", vastausID=" + vastausID + "]";
	}
	
	
	
}
