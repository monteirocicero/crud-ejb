package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "DOGS")
@SequenceGenerator(name = Dog.DOG_SEQUENCE_NAME, sequenceName = Dog.DOG_SEQUENCE_NAME, allocationSize = 53)
public class Dog {
	
	public static final String DOG_SEQUENCE_NAME = "DOG_SEQUENCE_ID";

	private Integer id;
	private String name;
	private double weight;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = DOG_SEQUENCE_NAME)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	@Override
	public int hashCode() {
		return getId();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Dog) {
			Dog dog = (Dog) obj;
			return dog.getId() == getId();
		}
		return false;
	}

}
