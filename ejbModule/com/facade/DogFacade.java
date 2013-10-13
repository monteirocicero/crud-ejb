package com.facade;

import java.util.List;

import javax.ejb.Local;

import com.model.Dog;

@Local
public interface DogFacade {
	void save(Dog dog);
	Dog update(Dog dog);
	void delete(Dog dog);
	Dog find(Integer entityID);
	List<Dog> findAll();
}
