package com.choco.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.choco.demo.model.CartModel;
import com.choco.demo.model.ChocoModel;

public interface CARTRepo extends JpaRepository<CartModel,String>{


}
