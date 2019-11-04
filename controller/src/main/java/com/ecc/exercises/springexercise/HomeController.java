package com.ecc.exercises.springexercise.controller;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.ui.Model;

import java.util.List;
import java.util.Arrays;

@Controller
public class HomeController {
   
   @Value("${app.name}")
   String appName;

   @GetMapping(value = "/")
   public String home(Model model) {
    	model.addAttribute(appName);
    	return "home";
   }
}