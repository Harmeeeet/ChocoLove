package com.choco.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choco.demo.model.CartModel;
import com.choco.demo.model.ChocoModel;
import com.choco.demo.repo.CARTRepo;
import com.choco.demo.repo.ChocoRepo;
@Service
public class CartService {

	
	
    @Autowired
	CARTRepo repo;
	
    
    public List<CartModel> listAll(){
    	return repo.findAll();
    }
    public void save(CartModel m) {
    	
    	repo.save(m);
    }
    public CartModel findOne(String name)
    {
    	if(repo.existsById(name))
    	return repo.findById(name).get();
    	else return new CartModel();
    	
    }
    public void replace(CartModel m)
    {
    	if(repo.existsById(m.getName()))
    	{
    	repo.deleteById(m.getName());
    	repo.save(m);
    	}
    	else
    		repo.save(m);
    }
    public long findval()
    {
    	long sum = 0;
    	
    	for(CartModel el : repo.findAll())
    	{
    		sum += el.getQt();
    	}
    	return sum;
    	
    }
}
