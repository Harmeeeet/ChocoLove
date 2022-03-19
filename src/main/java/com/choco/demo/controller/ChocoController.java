package com.choco.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.choco.demo.model.ChocoModel;
import com.choco.demo.service.ChocoService;

@Controller
public class ChocoController {

	
	@Autowired
	ChocoService service;
	
	
	@GetMapping("/")
	public ModelAndView homepage(){
		List<ChocoModel> model=service.listAll();
		ModelAndView mv=new ModelAndView("homepage");
		mv.addObject("list",model);
		return mv;
	}
	
	@GetMapping("/add")
	public ModelAndView addItem() {
		ModelAndView mv=new ModelAndView("new");
		ChocoModel model =new ChocoModel();
		mv.addObject("newmodel",model);
		return mv;
	}
	
	@PostMapping("/save")
	public String save(ChocoModel model) {
		service.save(model);
		return "redirect:/";
    }
	
	
//	public ModelAndView addtocart(ChocoModel model) {
//		ModelAndView mv=new ModelAndView("");
//		
//	}
}
