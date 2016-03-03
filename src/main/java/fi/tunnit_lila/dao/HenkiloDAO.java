package fi.tunnit_lila.dao;

import java.util.List;

import fi.tunnit_lila.bean.Henkilo;



public interface HenkiloDAO {

	public abstract void talleta(Henkilo henkilo);

	public abstract Henkilo etsi(int id);

	public abstract List<Henkilo> haeKaikki();

}