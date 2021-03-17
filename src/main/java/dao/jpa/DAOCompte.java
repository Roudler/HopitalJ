package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.IDAOCompte;
import metier.Compte;
import util.Context;

public class DAOCompte implements IDAOCompte{

	

	@Override
	public Compte findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Compte compte = em.find(Compte.class, id);
		em.close();
		return compte;
	}

	@Override
	public List<Compte> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		List<Compte> comptes = em.createQuery("select c from Compte c", Compte.class).getResultList();
		em.close();
		return comptes;
	}

	@Override
	public Compte save(Compte compte) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		
		compte=em.merge(compte);
		
		em.getTransaction().commit();
		em.close();
		return compte;
	}

	@Override
	public void delete(Compte compte) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		
		compte=em.merge(compte);
		em.remove(compte);
		
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public Compte checkConnect(String log, String pass) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query q = em.createQuery("select c from Compte c where login = :log and password = :pass", Compte.class);
		q.setParameter("log", log);
		q.setParameter("pass", pass);
		Compte compte = (Compte) q.getSingleResult();
		em.close();
		return compte;
	}

}
