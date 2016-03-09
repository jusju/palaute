package fi.tunnit.lila.bean;

public class ProjektiImpl implements Projekti  {
	
	private int projID;
	private String projnimi;
	public ProjektiImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProjektiImpl(int projID, String projnimi) {
		super();
		this.projID = projID;
		this.projnimi = projnimi;
	}
	public int getProjID() {
		return projID;
	}
	public void setProjID(int projID) {
		this.projID = projID;
	}
	public String getProjnimi() {
		return projnimi;
	}
	public void setProjnimi(String projnimi) {
		this.projnimi = projnimi;
	}
	@Override
	public String toString() {
		return "ProjektiImpl [projID=" + projID + ", projnimi=" + projnimi
				+ "]";
	}
	
	

}
