package com.crud.gyme.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.crud.gyme.entities.Trainee;
import com.crud.gyme.entities.Trainer;
import com.crud.gyme.model.manager.ManagerDAO;



@ManagedBean
@SessionScoped
public class TrainerBean {
	
	private ManagerDAO managerDAO;
	
	private String name;
	private String email;
	private BigDecimal cost;
	private Trainer trainer;
	
	public TrainerBean() {
		managerDAO = new ManagerDAO();
	}
	
	public List<Trainer> getListTrainers(){
		return managerDAO.findAllTrainers();
	}
	
	public String createTrainer() {
		
		if(name =="" || email ==""  || cost.equals(BigDecimal.ZERO))
			return "";
		
		managerDAO.createTrainer(name, email, cost);
		name="";
		email="";
		cost=BigDecimal.ZERO;
		
		return"";		
	}
	
	public String deleteTrainer(Trainer trainer) {
		
		List<Trainee> trainee = managerDAO.findTraineeByTrainer(trainer);
		if(!trainee.isEmpty())
			return "parentKeyFound";
		
		managerDAO.deleteTrainer(trainer.getTrainerId());
		return "";
	}
	public String updateTrainer(Trainer trainer) {
		name = trainer.getTrainerName();
		email=trainer.getTrianerEmail();
		cost = trainer.getTrainerCost();
		this.trainer = trainer;
		return "editTrainer";
	}
	
	public String actualUpdatetrainer() {
		managerDAO.updateTrainer(trainer.getTrainerId(), name, email, cost);
		
		name = "";
		email = "";
		cost = BigDecimal.ZERO;
		trainer = null;
		return "Trainer";
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

}
