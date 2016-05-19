package fi.palaute.bean;

public class KysymysImpl implements Kysymys {
	
	private int kysymysID;
	private String kysymysteksti;
	public KysymysImpl() {
		super();

	}
	public KysymysImpl(int kysymysID, String kysymysteksti) {
		super();
		this.kysymysID = kysymysID;
		this.kysymysteksti = kysymysteksti;
	}
	public int getKysymysID() {
		return kysymysID;
	}
	public void setKysymysID(int kysymysID) {
		this.kysymysID = kysymysID;
	}
	public String getKysymysteksti() {
		return kysymysteksti;
	}
	public void setKysymysteksti(String kysymysteksti) {
		this.kysymysteksti = kysymysteksti;
	}
	@Override
	public String toString() {
		return "KysymysImpl [kysymysID=" + kysymysID + ", kysymysteksti="
				+ kysymysteksti + "]";
	}
	
	

}
