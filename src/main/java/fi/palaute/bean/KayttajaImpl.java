package fi.palaute.bean;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import fi.palaute.bean.validation.PasswordCompare;
import fi.palaute.bean.validation.UniqueTunnus;

@PasswordCompare(groups = {KayttajaImpl.uusiKayttaja.class, KayttajaImpl.uusiSalasana.class}, message ="Salasanat eivät täsmä!")
public class KayttajaImpl implements Kayttaja {


	public interface uusiKayttaja {

	}
	
	public interface uusiSalasana {

	}
	
	
	private int id;
	
	@Size(groups = {KayttajaImpl.uusiKayttaja.class}, min = 1, message = "Anna opiskelijatunnus")
	@Pattern(groups = {KayttajaImpl.uusiKayttaja.class}, regexp = "^[aA][0-9]{7}$", message = "Anna opiskelijatunnus muodossa a1234567")
    @UniqueTunnus(groups = {KayttajaImpl.uusiKayttaja.class}, message = "Antamasi opiskelijatunnus on jo käytetty")
	private String tunnus;
	
	@Pattern(groups = {KayttajaImpl.uusiKayttaja.class, KayttajaImpl.uusiSalasana.class}, regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}", message = "Salasanassa pitää olla vähintän yksi isokirjain ja yksi pieni, sen pitää sisältä vähintän yksi numero ja salasanan pituus on vähintän 8 merkkia.")
	private String salasana;
	

	private String vertailu;
	
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getTunnus() {
		return tunnus;
	}
	public void setTunnus(String tunnus) {
		this.tunnus = tunnus;
	}
	public String getSalasana() {
		return salasana;
	}
	public void setSalasana(String salasana) {
		this.salasana = salasana;
	}
	public String getVertailu() {
		return vertailu;
	}
	public void setVertailu(String vertailu) {
		this.vertailu = vertailu;
	}
	@Override
	public String toString() {
		return "HenkiloImpl [id=" + id + ", tunnus=" + tunnus + ", salasana="
				+ salasana + ", vertailu=" + vertailu + "]";
	}

	

	
	
	
	
	
	
	
}
