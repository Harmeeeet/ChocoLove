package com.choco.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.choco.demo.model.ChocoModel;

public interface ChocoRepo extends JpaRepository<ChocoModel,Integer>{

}
