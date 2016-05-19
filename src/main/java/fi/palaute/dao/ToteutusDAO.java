package fi.palaute.dao;

import java.util.ArrayList;
import java.util.List;

import fi.palaute.bean.Toteutus;

public interface ToteutusDAO {
	
	public abstract void insertBatch(ArrayList<Toteutus> toteutukset);

}