package com.mamad.dao.administration;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mamad.model.administration.User;
/**
 * Classe qui implémente les services de l'interface UserDAO: ajout, modification,
 * lecture supression. 
 * @author Mamadou
 *
 */
@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public UserDAOImpl() {
		
	}
	
	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/**
	 * Méthode qui retourne la liste des utilisateurs à partir de la session
	 * @return liste d'utilisateurs 
	 */
	@Transactional
	
	public List<User> list() {
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) sessionFactory.getCurrentSession()
				.createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listUser;
	}

	/**
	 * Méthode qui permet d'enregistrer ou de modifier un utilisateur
	 */
	@Transactional
	public void saveOrUpdate(User collaborateur) {
		sessionFactory.getCurrentSession().saveOrUpdate(collaborateur);
	}
	/**
	 * Méthode qui permet de supprimer un utilisateur à partir de son identifiant 
	 */
	@Transactional
	public void delete(int id) {
		User userToDelete = new User();
		userToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(userToDelete);
	}
	/**
	 * Méthode qui permet de récupérer un utilisateur via son id
	 */
	@Transactional
	public User get(int id) {
		String str = "from Collaborateur where id=" + id;
		Query query = sessionFactory.getCurrentSession().createQuery(str);
		
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) query.list();
		
		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}
		
		return null;
	}
}