package com.ejercicioexamen.app.controller;




import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;

import com.ejercicioexamen.app.DBUtil.DBUtil;
import com.ejercicioexamen.app.business.entity.Movies;
import com.ejercicioexamen.app.business.service.RepositoryDirectorService;
import com.ejercicioexamen.app.business.service.RepositoryMoviesService;
import com.ejercicioexamen.app.business.service.impl.RepositoryDirectorServiceImpl;
import com.ejercicioexamen.app.business.service.impl.RepositoryMoviesServiceImpl;

@RequestMapping("/movies")
@Controller
public class MovieController {

    RepositoryMoviesService repositoryMoviesService=new RepositoryMoviesServiceImpl();
    
    RepositoryDirectorService repositoryDirectorService=new RepositoryDirectorServiceImpl();

    @GetMapping("/listaPeliculas")
     public String listaPeliculas(Model model){
             try {
                 Connection connection = DBUtil.getConnection();
                 model.addAttribute("movies", repositoryMoviesService.findAllMovies(connection));
                 DBUtil.closeConnection(connection);
            } catch (SQLException e) {
                
             e.printStackTrace();
            }
            
         return "listaPeliculas";
    }
    
     @GetMapping("listaPeliculas/{id}")
     public String getById(@PathVariable ("id") int id, Model model){   
         try{
             Connection connection = DBUtil.getConnection();
             model.addAttribute("peliculaSeleccionada",repositoryMoviesService.findMovieById(id));
             DBUtil.closeConnection(connection);
         }catch(SQLException e){
             e.printStackTrace();
         }
        
         return "PeliculaDetallada";
 
 }

    @GetMapping("/insertarPelicula")
    public String mostrarInsert(Model model){
        try {
            Connection connection=DBUtil.getConnection();
            model.addAttribute("movie", new Movies());
            model.addAttribute("directors",repositoryDirectorService.findAllDirectors(connection));           
            DBUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "insercion";
    }

    @PostMapping("/guardar")//CREAR LA ENTIDAD MOVIE AHI  .EL CONTROLLER NO TIENE QUE LLAMAR EL CONNECTION
    public String insert(@ModelAttribute("movie")Movies movie, 
            Model model, HttpRequest request, HttpResponse response){   
        model.addAttribute("elementoPelicula", movie);
        
        return "resultadoFormulario";
     }

}
