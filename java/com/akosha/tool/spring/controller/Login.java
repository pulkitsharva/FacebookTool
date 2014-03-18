package com.akosha.tool.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.akosha.tool.spring.service.BrandsService;

@Controller
public class Login 
{
	@Autowired
	private BrandsService brandsService;
	
	@RequestMapping(value="/index")
	public String index()
	{
		System.out.println("coming here");
		return "index";
	}
	
	@RequestMapping(value="/Home")
	public String home(@RequestParam("userId") String userId,Model model,HttpSession session)
	{
		session.setAttribute("sessionUserId", userId);
		model.addAttribute("brandsList", brandsService.getBrands());
		System.out.println("Id is:"+userId);
		return "Home";
	}
}
