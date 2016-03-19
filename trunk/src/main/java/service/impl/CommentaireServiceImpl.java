package service.impl;


import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CommentaireDAO;
import model.Commentaire;
import service.CommentaireService;



@Service
@Transactional
public class CommentaireServiceImpl implements CommentaireService {

	@Autowired
	private CommentaireDAO commentaireDAO;

	public boolean saveCommentaire(Commentaire commentaire) {
		boolean res = false;
		
		if (commentaire != null) {
			res = commentaireDAO.save(commentaire);
		}
		
		return res;
	}

}