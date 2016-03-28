package fi.tunnit.lila.bean;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import fi.tunnit.lila.bean.validation.PasswordCompare;
import fi.tunnit.lila.bean.validation.UniqueEmail;

@PasswordCompare(message ="Salasanat eivät täsmä!")
public class HenkiloImpl implements Henkilo {

	private int id;
	
	@Size(min = 3, message = "Etunimissa pitää olla vähintän 3 kirjainta.")
	private String etunimi;
	
	@Size(min = 1, message = "Kirjoita sukunimesi.")
	private String sukunimi;
	
	@Size(min = 1, message = "Kirjoita sähköpostiosoite.")
	@Email(message = "Anna sähköpostiosoite oikeassa muodossa.")
    @UniqueEmail(message = "Antamasi sähköpostiosoite on jo käytetty")
	private String sposti;
	
	@Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}", message = "Salasanassa pitää olla vähintän yksi isokirjain, yksi pieni, sen pitää sisältä vähintän yksi numero ja yksi erikoismerkki, salasanan pituus on vähintän 8 merkkia.")
	private String salasana;
	

	private String vertailu;
	
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEtunimi() {
		return etunimi;
	}
	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}
	public String getSukunimi() {
		return sukunimi;
	}
	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}
	public String getSposti() {
		return sposti;
	}
	public void setSposti(String sposti) {
		this.sposti = sposti;
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
		return "HenkiloImpl [id=" + id + ", etunimi=" + etunimi + ", sukunimi="
				+ sukunimi + ", sposti=" + sposti + ", salasana=" + salasana
				+ ", vertailu=" + vertailu + "]";
	}

	
	
	
	
	
	
	
}
