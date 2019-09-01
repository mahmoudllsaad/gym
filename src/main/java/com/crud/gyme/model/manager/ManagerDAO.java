package com.crud.gyme.model.manager;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.crud.gyme.entities.Trainee;
import com.crud.gyme.entities.Trainer;




public class ManagerDAO {

	private static EntityManagerFactory factory;
	private static EntityManager em;
	
	public ManagerDAO() {
		if(factory == null)
			factory = Persistence.createEntityManagerFactory("gymeJPA");
		
		if(em == null)
			em = factory.createEntityManager();
	}
	
	public List<Trainee> findAllTrainees(){
		
		List<Trainee> trainee ;
		Query query;
		
		em.getTransaction().begin();
		query = em.createQuery("SELECT T FROM trainee T ORDER BY T.traineeId");
		
		trainee = query.getResultList();
		em.getTransaction().commit();
		return trainee;
	}
	
    public List<Trainer> findAllTrainers(){
		
		List<Trainer> trainer ;
		Query query;
		
		em.getTransaction().begin();
		query = em.createQuery("SELECT T FROM trainer T ORDER BY T.trainerId");
		
		trainer = query.getResultList();
		em.getTransaction().commit();
		return trainer;
	 }
    
    public void createTrainer(String name,String email, BigDecimal cost) {
    	
    	em.getTransaction().begin();
    	
    	Trainer trainer = new Trainer();
    	trainer.setTrainerName(name);
    	trainer.setTrianerEmail(email);
    	trainer.setTrainerCost(cost);
    	
    	em.persist(trainer);
    	em.getTransaction().commit();
    	
    	
    }
    
    public void createTrainee(String name,String email, Trainer trainer) {
    	
    	em.getTransaction().begin();
    	
    	Trainee trainee = new Trainee();
    	trainee.setTraineeName(name);
    	trainee.setTrianeeEmail(email);
    	trainee.setTrainer(trainer);
    	
    	em.persist(trainee);
    	em.getTransaction().commit();
    	
    	
    }
    public Trainer findTrainerById(Integer trainerId) {
    	em.getTransaction().begin();
    	Trainer trainer = em.find(Trainer.class, trainerId);
    	em.getTransaction().commit();
    	return trainer;
    }
    
    public void deleteTrainer(Integer trainerId) {
    	
    	Trainer trainer = findTrainerById(trainerId);
    	em.getTransaction().begin();
    	em.remove(trainer);
    	em.getTransaction().commit();
    	
    }
    
    public Trainee findTraineeById(Integer traineeId) {
    	em.getTransaction().begin();
    	Trainee trainee = em.find(Trainee.class, traineeId);
    	em.getTransaction().commit();
    	return trainee;
    }
    
    public List<Trainee> findTraineeByTrainer(Trainer trainer) {
    	List<Trainee> trainee ;
		Query query;
		
		em.getTransaction().begin();
		query = em.createQuery("SELECT T FROM trainee T WHERE T.trainer = :tra").setParameter("tra", trainer);
		
		trainee = query.getResultList();
		em.getTransaction().commit();
		return trainee;
    }
    
    public void deleteTrainee(Integer traineeId) {
    	
    	Trainee trainee = findTraineeById(traineeId);
    	em.getTransaction().begin();
    	em.remove(trainee);
    	em.getTransaction().commit();
    	
    }
    
    public void updateTrainee(Integer traineeId ,String name,String email,Trainer trainer) {
    	Trainee trainee = findTraineeById(traineeId);
    	em.getTransaction().begin();
    	trainee.setTraineeName(name);
    	trainee.setTrianeeEmail(email);
    	trainee.setTrainer(trainer);
    	em.merge(trainee);
    	em.getTransaction().commit();
    	
    }
    public void updateTrainer(Integer trainerId ,String name,String email,BigDecimal cost) {
    	Trainer trainer = findTrainerById(trainerId);
    	em.getTransaction().begin();
    	trainer.setTrainerName(name);
    	trainer.setTrianerEmail(email);
    	trainer.setTrainerCost(cost);
    	em.merge(trainer);
    	em.getTransaction().commit();
    	
    }
    
}
