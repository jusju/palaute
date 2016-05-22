package fi.palaute.bean;

public class VahvistusLinkkiImpl implements VahvistusLinkki {

	private int vahvistusID;
	
	private int palauteID;
	
	private String satunnainen;

	public int getVahvistusID() {
		return vahvistusID;
	}

	public void setVahvistusID(int vahvistusID) {
		this.vahvistusID = vahvistusID;
	}

	public int getPalauteID() {
		return palauteID;
	}

	public void setPalauteID(int palauteID) {
		this.palauteID = palauteID;
	}

	public String getSatunnainen() {
		return satunnainen;
	}

	public void setSatunnainen(String satunnainen) {
		this.satunnainen = satunnainen;
	}

	@Override
	public String toString() {
		return "VahvistusLinkkiImpl [vahvistusID=" + vahvistusID
				+ ", palauteID=" + palauteID + ", satunnainen=" + satunnainen
				+ "]";
	}
	
	

}
