package com.choco.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.choco.demo.model.CartModel;
import com.choco.demo.model.ChocoModel;
import com.choco.demo.service.CartService;
import com.choco.demo.service.ChocoService;

@Controller
public class ChocoController {
	@Autowired
	ChocoService service;
	@Autowired
	CartService cartservice;
	
	List<ChocoModel> cart = new ArrayList<>();
	
	@GetMapping("/")
	public ModelAndView homepage(){
		List<ChocoModel> model=service.listAll();
		ModelAndView mv=new ModelAndView("homepage");
		mv.addObject("list",model);
		mv.addObject("cartsize",cartservice.findval());
		return mv;
	}
	
	@RequestMapping("/add")
	public ModelAndView addItem() {
		ModelAndView mv=new ModelAndView("add");
		ChocoModel model =new ChocoModel();
		mv.addObject("newmodel",model);
		return mv;
	}
	
	@RequestMapping("/save")
	public String save(@ModelAttribute("model") ChocoModel model) {
		service.save(model);
		return "redirect:/add";
    }
	
	@RequestMapping("/addtocart/{name}")
  	public String addtocart(@PathVariable("name") String name) {
		CartModel n = cartservice.findOne(name);
		ChocoModel m = service.findOne(name);
		
		n.setName(name);
		n.setPrice(m.getPrice());
		n.setQt(n.getQt()+1);
		
		cartservice.replace(n);
		
		return "redirect:/";
		
	}
	
	@ResponseBody
	@RequestMapping("cart")
	public List<CartModel> showcart()
	{
		return cartservice.listAll();
	}
}
