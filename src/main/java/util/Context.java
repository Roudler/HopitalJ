package src.main.java.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.jpa.DAOCompte;
import dao.jpa.DAOPatient;
import dao.jpa.DAOVisite;
import src.main.java.dao.IDAOCompte;
import src.main.java.dao.IDAOPatient;
import src.main.java.dao.IDAOVisite;

public class Context {

	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("eshopJPA");
	private static Context _instance=null;
	private IDAOCompte daoCompte = new DAOCompte();
	private IDAOPatient daoPatient = new DAOPatient();
	private IDAOVisite daoVisite = new DAOVisite();

	private Context() 
	{}
	
	
	public static Context getInstance() 
	{
		if(_instance==null) {_instance=new Context();}
		return _instance;
	}
	
	
	public EntityManagerFactory getEmf() {
		return emf;
	}


	public void closeEmf() 
	{
		emf.close();
	}


	public IDAOCompte getDaoCompte() {
		return daoCompte;
	}


	public IDAOPatient getDaoPatient() {
		return daoPatient;
	}


	public IDAOVisite getDaoVisite() {
		return daoVisite;
	}


	
}
