package com.crud.gyme.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the trainer database table.
 * 
 */
@Entity(name = "trainer")
@NamedQuery(name="Trainer.findAll", query="SELECT t FROM trainer t")
public class Trainer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="trainer_id" ,columnDefinition = "serial")
	private Integer trainerId;

	@Column(name="trainer_cost")
	private BigDecimal trainerCost;

	@Column(name="trainer_name")
	private String trainerName;

	@Column(name="trianer_email")
	private String trianerEmail;

	
	@OneToMany(mappedBy="trainer")
	private List<Trainee> trainees;

	public Trainer() {
	}

	public Integer getTrainerId() {
		return this.trainerId;
	}

	public void setTrainerId(Integer trainerId) {
		this.trainerId = trainerId;
	}

	public BigDecimal getTrainerCost() {
		return this.trainerCost;
	}

	public void setTrainerCost(BigDecimal trainerCost) {
		this.trainerCost = trainerCost;
	}

	public String getTrainerName() {
		return this.trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public String getTrianerEmail() {
		return this.trianerEmail;
	}

	public void setTrianerEmail(String trianerEmail) {
		this.trianerEmail = trianerEmail;
	}

	public List<Trainee> getTrainees() {
		return this.trainees;
	}

	public void setTrainees(List<Trainee> trainees) {
		this.trainees = trainees;
	}

	public Trainee addTrainee(Trainee trainee) {
		getTrainees().add(trainee);
		trainee.setTrainer(this);

		return trainee;
	}

	public Trainee removeTrainee(Trainee trainee) {
		getTrainees().remove(trainee);
		trainee.setTrainer(null);

		return trainee;
	}

}