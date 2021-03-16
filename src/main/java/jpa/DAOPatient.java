package jpa;

import java.util.List;

import javax.persistence.EntityManager;
import metier.Patient;
import util.Context;

public class DAOPatient implements IDAOPatient{

	@Override
	public Patient findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Patient patient = em.find(Patient.class, id);
		em.close();
		return patient;
	}

	@Override
	public List<Patient> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Patient save(Patient patient) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		
		patient=em.merge(patient);
		
		em.getTransaction().commit();
		em.close();
		return patient;
	}

	@Override
	public void delete(Patient patient) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		
		patient=em.merge(patient);
		em.remove(patient);
		
		em.getTransaction().commit();
		em.close();
		
	}

	

}
