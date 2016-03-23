package service.impl;


import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.RecompenseDAO;
import model.Recompense;
import service.RecompenseService;


@Service
@Transactional
public class RecompenseServiceImpl implements RecompenseService {

	@Autowired
	private RecompenseDAO recompenseDAO;

	public boolean save(Recompense recompense) {
		boolean res = false;
		
		if (recompense != null) {
			res = recompenseDAO.save(recompense);
		}
		
		return res;
	}

}