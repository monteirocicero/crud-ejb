package com.facade;

import java.util.List;

import javax.ejb.EJB;

import com.dao.DogDAO;
import com.model.Dog;

public class DogFacadeImpl implements DogFacade {
	
	@EJB
	private DogDAO dogDAO;

	@Override
	public void save(Dog dog) {
		isDogWithAllDate(dog);
		dogDAO.save(dog);
	}
	
	@Override
	public Dog update(Dog dog) {
		isDogWithAllDate(dog);
		return dogDAO.update(dog);
	}

	@Override
	public void delete(Dog dog) {
		dogDAO.delete(dog);
	}

	@Override
	public Dog find(Integer entityID) {
		return dogDAO.find(entityID);
	}

	@Override
	public List<Dog> findAll() {
		return dogDAO.findAll();
	}
	
	private void isDogWithAllDate(Dog dog) {
		boolean hasError = false;
		
		if (dog == null) {
			hasError = true;
		}
		
		if (dog.getName() == null || "".equals(dog.getName().trim())) {
			hasError = true;
		}
		
		if (dog.getWeight() <= 0) {
			hasError = true;
		}
		
		if (hasError) {
			throw new IllegalArgumentException("The dog is missing data. Check the name and weight, they should have value.");
		}
	}

}
