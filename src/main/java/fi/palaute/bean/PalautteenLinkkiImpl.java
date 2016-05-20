package fi.palaute.bean;

public class PalautteenLinkkiImpl implements PalautteenLinkki {

	private int linkkiID;
	
	private int toteutusID;
	
	private String satunnainen;
	
	private String timestamp;

	public int getLinkkiID() {
		return linkkiID;
	}

	public void setLinkkiID(int linkkiID) {
		this.linkkiID = linkkiID;
	}

	public int getToteutusID() {
		return toteutusID;
	}

	public void setToteutusID(int toteutusID) {
		this.toteutusID = toteutusID;
	}

	public String getSatunnainen() {
		return satunnainen;
	}

	public void setSatunnainen(String satunnainen) {
		this.satunnainen = satunnainen;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "PalautteenLinkkiImpl [linkkiID=" + linkkiID + ", toteutusID="
				+ toteutusID + ", satunnainen=" + satunnainen + ", timestamp="
				+ timestamp + "]";
	}
	
	
	
}
