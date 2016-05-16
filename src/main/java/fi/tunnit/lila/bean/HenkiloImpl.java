package fi.tunnit.lila.bean;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import fi.tunnit.lila.bean.validation.PasswordCompare;
import fi.tunnit.lila.bean.validation.UniqueEmail;

@PasswordCompare(groups = {HenkiloImpl.uusiHenkilo.class, HenkiloImpl.uusiSalasana.class}, message ="Salasanat eiv‰t t‰sm‰‰!")
public class HenkiloImpl implements Henkilo {


	public interface uusiHenkilo {

	}
	
	public interface muokkaaHenkilo {

	}
	
	public interface uusiSalasana {

	}
	

	
	private int id;
	
	@Size(groups = {HenkiloImpl.uusiHenkilo.class, HenkiloImpl.muokkaaHenkilo.class}, min = 3, message = "Etunimess‰ pit‰‰ olla v‰hint‰‰n 3 kirjainta.")
	private String etunimi;
	
	@Size(groups = {HenkiloImpl.uusiHenkilo.class, HenkiloImpl.muokkaaHenkilo.class}, min = 1, message = "Kirjoita sukunimesi.")
	private String sukunimi;
	
	@Size(groups = {HenkiloImpl.uusiHenkilo.class, HenkiloImpl.muokkaaHenkilo.class}, min = 1, message = "Kirjoita s‰hkˆpostiosoite.")
	@Email(groups = {HenkiloImpl.uusiHenkilo.class, HenkiloImpl.muokkaaHenkilo.class}, message = "Anna s‰hk‰postiosoite oikeassa muodossa.")
    @UniqueEmail(groups = {HenkiloImpl.uusiHenkilo.class}, message = "Antamasi s‰hk‰postiosoite on jo k‰ytetty")
	private String sposti;
	
	@Pattern(groups = {HenkiloImpl.uusiHenkilo.class, HenkiloImpl.uusiSalasana.class}, regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}", message = "Salasanassa pit‰‰ olla v‰hint‰n yksi isokirjain ja yksi pieni, sen pit‰‰ sis‰lt‰ v‰hint‰n yksi numero ja salasanan pituus on v‰hint‰n 8 merkkia.")
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
