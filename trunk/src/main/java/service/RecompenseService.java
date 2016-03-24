package service;

import java.util.List;

import model.Projet;
import model.Recompense;



public interface RecompenseService {
	
	public boolean save(Recompense recompense);

	public boolean deleteByProjet(Projet projet);
}