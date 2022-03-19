package com.choco.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choco.demo.model.ChocoModel;
import com.choco.demo.repo.ChocoRepo;

@Service
public class ChocoService {
	
	
	
    @Autowired
	ChocoRepo repo;
	
    
    public List<ChocoModel> listAll(){
    	return repo.findAll();
    }
    public void save(ChocoModel model) {
    	
    	repo.save(model);
    }
    public ChocoModel findOne(String name)
    {
    	return repo.findById(name).get();
    	
    }
}
