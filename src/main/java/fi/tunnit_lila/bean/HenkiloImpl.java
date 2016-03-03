package fi.tunnit_lila.bean;

public class HenkiloImpl implements Henkilo {

	private int id;
	private String etunimi,sukunimi,sposti,salasana;
	public HenkiloImpl() {
		super();
		
	}
	public HenkiloImpl(int id, String etunimi, String sukunimi, String sposti,
			String salasana) {
		super();
		this.id = id;
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.sposti = sposti;
		this.salasana = salasana;
	}
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
	@Override
	public String toString() {
		return "HenkiloImpl [id=" + id + ", etunimi=" + etunimi + ", sukunimi="
				+ sukunimi + ", sposti=" + sposti + ", salasana=" + salasana
				+ "]";
	}
	
	
	
	
	
	
}
