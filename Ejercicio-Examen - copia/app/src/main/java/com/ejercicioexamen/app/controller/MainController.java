package com.ejercicioexamen.app.controller;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.ejercicioexamen.app.DBUtil.DBUtil;
import com.ejercicioexamen.app.business.service.RepositoryMoviesService;
import com.ejercicioexamen.app.business.service.impl.RepositoryMoviesServiceImpl;

import org.springframework.ui.Model;

@Controller
public class MainController {
 

   @GetMapping("/")
    public String index(){
        return "index";
    }
   
   
    
    

}
