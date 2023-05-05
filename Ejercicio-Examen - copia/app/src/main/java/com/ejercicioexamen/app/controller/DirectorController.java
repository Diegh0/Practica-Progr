package com.ejercicioexamen.app.controller;
import java.sql.Connection;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ejercicioexamen.app.DBUtil.DBUtil;
import com.ejercicioexamen.app.business.entity.Movies;
import com.ejercicioexamen.app.business.service.RepositoryDirectorService;
import com.ejercicioexamen.app.business.service.RepositoryMoviesService;
import com.ejercicioexamen.app.business.service.impl.RepositoryDirectorServiceImpl;
import com.ejercicioexamen.app.business.service.impl.RepositoryMoviesServiceImpl;

@RequestMapping("/director")
@Controller
public class DirectorController {

    RepositoryDirectorService repositoryDirectorService=new RepositoryDirectorServiceImpl();
    RepositoryMoviesService repositoryMoviesService=new RepositoryMoviesServiceImpl();
    
    @GetMapping
    public String dropDownDirector(Model model){

        try {

            Connection connection=DBUtil.getConnection();
            model.addAttribute("directors",repositoryDirectorService.findAllDirectors(connection));           
            DBUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "desplegable";
    }

    
    // @PostMapping
    // public List<Movies> insertarEjemplo(@RequestBody String title){

    // }
    
}
