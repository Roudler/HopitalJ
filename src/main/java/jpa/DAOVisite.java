package jpa;

import java.util.List;

import javax.persistence.EntityManager;

import dao.IDAOVisite;
import metier.Visite;
import util.Context;



public class DAOVisite implements IDAOVisite{

	@Override
	public Visite findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Visite visite = em.find(Visite.class, id);
		em.close();
		return visite;
	}

	@Override
	public List<Visite> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void delete(Visite visite) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		
		visite=em.merge(visite);
		em.remove(visite);
		
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public Visite save(Visite visite) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		
		visite=em.merge(visite);
		
		em.getTransaction().commit();
		em.close();
		return visite;
	}


	@Override
	public List<Visite> selectAllByPatient(int secu) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
