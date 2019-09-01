package com.crud.gyme.controller;


import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import com.crud.gyme.entities.Trainee;
import com.crud.gyme.entities.Trainer;
import com.crud.gyme.model.manager.ManagerDAO;



@ManagedBean
@SessionScoped
public class TraineeBean {
	
	private ManagerDAO managerDAO;
	private String trainerId;
	private String name;
	private String email;
	private Trainer trainer;
	private Trainee trainee;
	
	private List<SelectItem> trainerList; 
	
	public TraineeBean() {
		managerDAO = new ManagerDAO();
		trainerList = new ArrayList<SelectItem>();
	}
	
	public List<Trainee> getListTrainees(){
		return managerDAO.findAllTrainees();
	}
	
	public String createTrainee() {
		
		if(trainerId.equals(""))
			return "trainerNotFound";
		
		managerDAO.createTrainee(name, email, managerDAO.findTrainerById(Integer.valueOf(trainerId)));
		name="";
		email="";
		trainerId = "";
		
		return"Trainee";		
	}
	
	public String deleteTrainee(Trainee trainee) {
		managerDAO.deleteTrainee(trainee.getTraineeId());
		return "";
	}
	
	public List<SelectItem> getTrainerList() {
		
		trainerList.clear();
		init();
		return trainerList;
	}
	public String updateTrainee(Trainee trainee) {
		name = trainee.getTraineeName();
		email=trainee.getTrianeeEmail();
	    trainer = trainee.getTrainer();
		this.trainee = trainee;
		return "editTrainee";
	}
	
	public String actualUpdatetrainee() {
		managerDAO.updateTrainee(trainee.getTraineeId(), name, email, trainer);
		
		name = "";
		email = "";
		trainer = null;
		trainee = null;
		return "Trainee";
	}

	public void init() {
		for(Trainer trainer : managerDAO.findAllTrainers()) {
			trainerList.add(new SelectItem(trainer.getTrainerId(),trainer.getTrainerName()));
		}
		
	}

	public String getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(String trainerId) {
		this.trainerId = trainerId;
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

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	
	

}
