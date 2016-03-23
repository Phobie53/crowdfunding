package service;

import java.util.List;

import model.Don;
import model.Utilisateur;



public interface DonService {

	public boolean saveDon(Don don);
	
	public int getCount();
	
	public int getMontantTotal();
}