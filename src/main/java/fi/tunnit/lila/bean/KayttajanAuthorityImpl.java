package fi.tunnit.lila.bean;

public class KayttajanAuthorityImpl implements KayttajanAuthority  {
	
	private int kaytID,authID;
	
	public KayttajanAuthorityImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KayttajanAuthorityImpl(int kaytID,int authID) {
		super();
		this.kaytID = kaytID;
		this.authID = authID;
	}
	public int getKaytID() {
		return kaytID;
	}
	public void setKaytID(int kaytID) {
		this.kaytID = kaytID;
	}
	public int getAuthID() {
		return authID;
	}
	public void setAuthID(int authID) {
		this.authID = authID;
	}
	@Override
	public String toString() {
		return "KayttajanAuthorityImpl [kaytID=" + kaytID + ", authID="
				+ authID + "]";
	}
	
	
	

}
