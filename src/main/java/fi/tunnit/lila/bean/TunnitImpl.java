package fi.tunnit.lila.bean;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class TunnitImpl implements Tunnit {

	private int tuntiID,kaytID,projID;
	@Size(min = 1, message = "Anna päivämäärä")
	@Pattern(regexp = "^[0-3]?[0-9].[0-3]?[0-9].(?:[0-9]{2})?[0-9]{2}$", message = "Anna päivämäärä oikeassa muodossa")
	private String date;
	@Size(min = 1, message = "Anna aloitusaika")
	@Pattern(regexp = "([01]?[0-9]|2[0-3]):[0-5][0-9]", message = "Anna aloitusaika muodossa TT:MM")
	private String aloitusaika;
	@Size(min = 1, message = "Anna lopetusaika")
	@Pattern(regexp = "([01]?[0-9]|2[0-3]):[0-5][0-9]", message = "Anna lopetusaika muodossa TT:MM")
	private String lopetusaika;
	@Size(min = 1, message = "Kirjoita kuvaus")
	private String kuvaus;
	
	public TunnitImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TunnitImpl(int tuntiID, int kaytID, int projID, String date,
			String aloitusaika, String lopetusaika, String kuvaus) {
		super();
		this.tuntiID = tuntiID;
		this.kaytID = kaytID;
		this.projID = projID;
		this.date = date;
		this.aloitusaika = aloitusaika;
		this.lopetusaika = lopetusaika;
		this.kuvaus = kuvaus;
	}
	public int getTuntiID() {
		return tuntiID;
	}
	public void setTuntiID(int tuntiID) {
		this.tuntiID = tuntiID;
	}
	public int getKaytID() {
		return kaytID;
	}
	public void setKaytID(int kaytID) {
		this.kaytID = kaytID;
	}
	public int getProjID() {
		return projID;
	}
	public void setProjID(int projID) {
		this.projID = projID;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAloitusaika() {
		return aloitusaika;
	}
	public void setAloitusaika(String aloitusaika) {
		this.aloitusaika = aloitusaika;
	}
	public String getLopetusaika() {
		return lopetusaika;
	}
	public void setLopetusaika(String lopetusaika) {
		this.lopetusaika = lopetusaika;
	}
	public String getKuvaus() {
		return kuvaus;
	}
	public void setKuvaus(String kuvaus) {
		this.kuvaus = kuvaus;
	}
	@Override
	public String toString() {
		return "TunnitImpl [tuntiID=" + tuntiID + ", kaytID=" + kaytID
				+ ", projID=" + projID + ", date=" + date + ", aloitusaika="
				+ aloitusaika + ", lopetusaika=" + lopetusaika + ", kuvaus="
				+ kuvaus + "]";
	}
	
	
}
