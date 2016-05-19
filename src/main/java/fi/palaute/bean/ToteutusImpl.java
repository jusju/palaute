package fi.palaute.bean;

public class ToteutusImpl implements Toteutus{
	
	private int toteutusID;
	private String toteutusTunnus, toteutusNimi, opettajaNimi;
	public ToteutusImpl() {
		super();
	
	}
	@Override
	public String toString() {
		return "ToteutusImpl [toteutusID=" + toteutusID + ", toteutusTunnus="
				+ toteutusTunnus + ", toteutusNimi=" + toteutusNimi
				+ ", opettajaNimi=" + opettajaNimi + "]";
	}
	public int getToteutusID() {
		return toteutusID;
	}
	public void setToteutusID(int toteutusID) {
		this.toteutusID = toteutusID;
	}
	public String getToteutusTunnus() {
		return toteutusTunnus;
	}
	public void setToteutusTunnus(String toteutusTunnus) {
		this.toteutusTunnus = toteutusTunnus;
	}
	public String getToteutusNimi() {
		return toteutusNimi;
	}
	public void setToteutusNimi(String toteutusNimi) {
		this.toteutusNimi = toteutusNimi;
	}
	public String getOpettajaNimi() {
		return opettajaNimi;
	}
	public void setOpettajaNimi(String opettajaNimi) {
		this.opettajaNimi = opettajaNimi;
	}
	public ToteutusImpl(int toteutusID, String toteutusTunnus,
			String toteutusNimi, String opettajaNimi) {
		super();
		this.toteutusID = toteutusID;
		this.toteutusTunnus = toteutusTunnus;
		this.toteutusNimi = toteutusNimi;
		this.opettajaNimi = opettajaNimi;
	}
	
	

}
