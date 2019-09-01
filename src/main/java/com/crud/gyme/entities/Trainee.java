package com.crud.gyme.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the trainee database table.
 * 
 */
@Entity(name = "trainee")
@NamedQuery(name="Trainee.findAll", query="SELECT t FROM trainee t")
public class Trainee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="trainee_id" ,columnDefinition = "serial")
	private Integer traineeId;

	@Column(name="trainee_name")
	private String traineeName;

	@Column(name="trianee_email")
	private String trianeeEmail;

	
	@ManyToOne
	@JoinColumn(name="trianer_fk")
	private Trainer trainer;

	public Trainee() {
	}

	public Integer getTraineeId() {
		return this.traineeId;
	}

	public void setTraineeId(Integer traineeId) {
		this.traineeId = traineeId;
	}

	public String getTraineeName() {
		return this.traineeName;
	}

	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}

	public String getTrianeeEmail() {
		return this.trianeeEmail;
	}

	public void setTrianeeEmail(String trianeeEmail) {
		this.trianeeEmail = trianeeEmail;
	}

	public Trainer getTrainer() {
		return this.trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

}